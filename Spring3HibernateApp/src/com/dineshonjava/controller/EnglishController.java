package com.dineshonjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.model.rule;
import com.dineshonjava.service.ArticleService;

@Controller
public class EnglishController {
	

	
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

}
