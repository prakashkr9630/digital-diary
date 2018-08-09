package com.dineshonjava.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.model.FinalResult;
import com.dineshonjava.model.QuestionSet;
import com.dineshonjava.model.rule;
import com.dineshonjava.service.ArticleService;

@Controller
public class EnglishController {
	
	List<FinalResult> finalresultList= new ArrayList<FinalResult>();
	List<QuestionSet> ls = new ArrayList<QuestionSet>();
	int index=0;
	int maxQuestion=10;
	String currectTopic;
	
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * entry api
	 * @return
	 */
	@RequestMapping(value = "/english", method = RequestMethod.GET)
	public ModelAndView startPage() {
		return new ModelAndView("english");
	}
	
	
	
	@RequestMapping(value = "/englishadmin", method = RequestMethod.GET)
	public ModelAndView englishadmin() {
		ModelAndView mvc = new ModelAndView("englishadmin");
		List<rule> allrules = articleService.getrule();		
		mvc.addObject("rule", allrules);
		return mvc;
	}
	
	
	@RequestMapping(value = "/englishstudent", method = RequestMethod.GET)
	public ModelAndView englishstudent() {		
		return new ModelAndView("englishstudent");
	}
	
	
	
	
	@RequestMapping(value = "/addrule", method = RequestMethod.GET)
	public ModelAndView addrule() {
		return new ModelAndView("addrule");
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public ModelAndView takeTest(@RequestParam("id") String topic) {
//		
//		ModelAndView mvc = new ModelAndView("test");
//		List<QuestionSet> ls = articleService.getAllExample(topic);		
//		mvc.addObject("questions", ls);
//		return mvc;
//	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView takeTest(@RequestParam("id") String topic) {
		currectTopic = topic;
		ModelAndView mvc = new ModelAndView("test1");
		 ls = articleService.getAllExample(currectTopic);
		 if(index < ls.size() && index < maxQuestion){
			 mvc.addObject("questions", ls.get(index++));
			 mvc.addObject("number", index);
		 }else{
			 List<FinalResult> temp = new ArrayList<FinalResult>();
			 temp.addAll(finalresultList); 
			 mvc = new ModelAndView("result");
			 mvc.addObject("result", temp);
			 mvc.addObject("score",getfinalScore(temp));
			 for(int i=0;i<ls.size();i++){
				 ls.remove(i);				 
			 }
			 
			 for(int p=0; p < finalresultList.size();p++){
				 finalresultList.remove(p);
			 }
			 
			 index=0;
			 currectTopic = null;
		 }
		
		return mvc;
	}
	
	
	
	private String getfinalScore(List<FinalResult> temp) {
		
		int total = temp.size();
		int correct=0;
		for(FinalResult fr :temp){
			if("y".equalsIgnoreCase(fr.getIscorrect())){
				++correct;
			}
		}
		String ff = correct +"out of "+ total;
		return ff;
	}



	@RequestMapping(value = "/validateanswerandnext", method = RequestMethod.POST)		
	public ModelAndView validateanswerandnext(@RequestParam("qnumber") String qnumber,@RequestParam("useranswer") String useranswer 
			,@RequestParam("quest") String quest
			,@RequestParam("currectoption") String currectoption)  {
		
		ModelAndView mvc = new ModelAndView("redirect:/test.html?id="+currectTopic);
		System.out.println("----------------New--------------");
		/*System.out.println(qnumber);*/		
		System.out.println(useranswer);
		System.out.println(quest);
		System.out.println(currectoption);

		FinalResult result= new FinalResult();
		result.setQuestion(quest);
		result.setUseranser(useranswer);
		result.setCorrectanswer(currectoption);
		result.setIscorrect(getstatus(useranswer,currectoption));
		finalresultList.add(result);
		
		
		return mvc;		
	}
	
	private String getstatus(String useranswer, String currectoption) {
		if(useranswer.equalsIgnoreCase(currectoption)){
			return "y";
		}else{
			return "n";
		}		
	}



	@RequestMapping(value = "/addexample", method = RequestMethod.GET)
	public ModelAndView addexample() {
		return new ModelAndView("addexample");
	}				
	
	@RequestMapping(value = "/addrulefortopic", method = RequestMethod.POST)		
	public ModelAndView addrulefortopic(@RequestParam("title") String title, @RequestParam("topic") String topic,@RequestParam("ruletext") String ruletext) {
		ModelAndView mvc = new ModelAndView("addrule");
		rule Rule= new rule();
		Rule.setRuletext(ruletext);
		Rule.setTopic(topic);
		Rule.setTitle(title);
		articleService.addrule(Rule);		
		mvc.addObject("status", "ok");
		return mvc;		
	}
	
	
	
	@RequestMapping(value = "/addexamplefortopic", method = RequestMethod.POST)		
	public ModelAndView addexamplefortopic(@RequestParam("topic") String topic,@RequestParam("questionset") String questionset)  {
		ModelAndView mvc = new ModelAndView("addexample");
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();			
			List<QuestionSet> ls =prepare(mapper.readValue(questionset, QuestionSet[].class),topic);
			articleService.saveExample(ls);
			mvc.addObject("status", ls.size()+" example saved successfully");
		} catch (Exception e) {
			mvc.addObject("error", "Error while parsing json :"+e.getMessage());
		}					
		return mvc;		
	}
	
	
	



	private List<QuestionSet> prepare(QuestionSet[] set,String topic) {
		List<QuestionSet> ls = Arrays.asList(set);
		List<QuestionSet> newList = new ArrayList<QuestionSet>();
		QuestionSet qset=null;
		for(QuestionSet  qs : ls){
			qset= new QuestionSet();
			qset.setTopic(topic);
			qset.setQuestion(qs.getQuestion());
			qset.setCorrectoption(qs.getCorrectoption());			
			newList.add(qset);
		}
		
		return newList;
		
	}



	

}
