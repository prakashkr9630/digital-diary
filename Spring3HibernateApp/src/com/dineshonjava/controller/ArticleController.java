package com.dineshonjava.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dineshonjava.bean.ArticleBean;
import com.dineshonjava.bean.CategoryBean;
import com.dineshonjava.model.Article;
import com.dineshonjava.model.Category;
import com.dineshonjava.model.Relate;
import com.dineshonjava.model.RelateUrl;
import com.dineshonjava.service.ArticleService;
import com.dineshonjava.service.CategoryService;
import com.dineshonjava.service.RelateService;
import com.dineshonjava.service.RelateUrlService;
import com.dineshonjava.util.Operation;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author Prakash
 *
 */
@Controller
public class ArticleController {
	
	String text;
	String mode;
	ArticleBean articlebeanforhtml;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService catservice;
	@Autowired
	private RelateService relateservice;
	@Autowired
	private RelateUrlService relateUrlService;
	
	/**
	 * This will be in action when save button 
	 * @param articleBean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveArticle(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {
		
		
		ModelAndView modelandview = new ModelAndView("addArticle");				
		if (validateArticleBean(articleBean)) {
			Article article = prepareModel(articleBean);
			articleService.addArticle(article);
			modelandview = new ModelAndView("redirect:/add.html");
		}else{
			/*when blank submit */
			modelandview.addObject("article", new Article());
			modelandview.addObject("error","Either of the field is Empty");
		}
		

		return modelandview;
	}

	/**
	 * this will check of title/article text is empty not
	 * 
	 * @param articleBean
	 * @return
	 */
	private boolean validateArticleBean(ArticleBean articleBean) {
		Boolean validate = false;
		if (articleBean.getTitle() != null && articleBean.getTitle().length() > 0
				&& articleBean.getArticletext() != null && articleBean.getArticletext().length() > 0) {
			validate = true;
		}
		return validate;
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("article", prepareListofBean(articleService.listArticle()));
		return new ModelAndView("articleList", model);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertArticle(@ModelAttribute("command") ArticleBean articleBean,CategoryBean catbean,  BindingResult result) {
		ModelAndView modelview = new ModelAndView("addArticle");		
		modelview.addObject("cats",prepareCat(catservice.listArticle()));		
		modelview.addObject("article", new Article());		
		return modelview;
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("articles", prepareListofBean(articleService.listArticle()));
		return new ModelAndView("listArticle", model);
	}
	
	/***
	 * This method will Map url to article 
	 * @param s_article
	 * @param url_id
	 * @return
	 */
	@RequestMapping(value = "/relateUrl", method = RequestMethod.POST)
	public ModelAndView addRelatedUrl(@RequestParam("s_article") String s_article,
			@RequestParam("url_id") String url_id) {
		
		RelateUrl relatedUrl = new RelateUrl();		
		String art_id = s_article;
		String url = url_id;
		
		ModelAndView mdv = null;
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if(art_id.length()>0 && art_id!=null && url.length()>0 && url!=null){
			
			int article_id = 0;
			try{
				article_id = Integer.parseInt(art_id);	
			}catch(Exception e){
				model.put("error", "Error while parsing article id");
				mdv = new ModelAndView("addrelated",model);
			}
			
			relatedUrl.setSourceID(article_id);
			relatedUrl.setUrl(url);
			try{
				relateUrlService.relateUrl(relatedUrl);	
			}catch(Exception e){
				model.put("error", e.getMessage());
			}
			
			mdv = new ModelAndView("addrelated",model);			
		}else{
			model.put("error", "Either of the field is Empty");
			mdv = new ModelAndView("addrelated",model);
		}
		
		return mdv;
	}
	
	
	/**
	 * Add related article operation
	 * @param articleBean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/relateArticle", method = RequestMethod.POST)
	public ModelAndView addRelatedArticle(@RequestParam("s_article") String s_article,
			@RequestParam("d_article") String d_article) {
		
		ModelAndView mdv = null;
		Map<String, Object> model = new HashMap<String, Object>();
		
		String s_art = s_article.trim();
		String d_art = d_article.trim();
		
		/*relateservice.getRelatedArticle(22);*/
		
		
		if(s_art!=null && s_art.length() > 0 && d_art!=null && d_art.length() > 0){						
			Relate relatearticle = new Relate();
			int sourceId =0;
			int destinationId=0;
			try{
				sourceId = Integer.parseInt(s_article);
				destinationId = Integer.parseInt(d_article);	
			}catch(Exception e){				
				model.put("error", "Either of the id is not String..!");
				return mdv = new ModelAndView("addrelated",model);	
			}
			
			relatearticle.setSourceID(sourceId);
			relatearticle.setDesinationId(destinationId);
			
			
			/**
			 * when article A add B article as relate, 
			 * then B article should also show A article as relate   
			 */
			
			try{
			relateservice.relateArticle(relatearticle);		
			relateservice.relateArticle(populateReverse(sourceId,destinationId));
			}catch(Exception e){				
				model.put("error", e.getMessage());	
			}
			mdv = new ModelAndView("addrelated",model);
		}else{					
			model.put("error", "Either of the field is empty");
			mdv = new ModelAndView("addrelated",model);			
		}		
		return mdv;
	}
	
	private Relate populateReverse(int sourceId,int destinationId) {
		
		Relate relate = new  Relate();
		relate.setSourceID(destinationId);
		relate.setDesinationId(sourceId);
		return relate;
	}

	/**
	 * this will redirect to relate article page
	 * @param s_article
	 * @param d_article
	 * @return
	 */
	@RequestMapping(value = "/relate", method = RequestMethod.GET)
	public ModelAndView relateArticle() {
		
		return new ModelAndView("addrelated");
	}


	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/
	
	/**
	 * this is html view of article
	 * @return
	 */
	@RequestMapping(value = "/htmlview", method = RequestMethod.GET)
	public ModelAndView getHtmlView(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {
		ModelAndView mv = new ModelAndView("htmlview");		
		mv.addObject("article",articlebeanforhtml);		
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {		
		articleService.deleteArticle(prepareModel(articleBean, articleBean.getId()));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("article", null);
		model.put("articles", prepareListofBean(articleService.listArticle()));
		//relateservice.deleteRelateArticle(articleBean.getId());
		return new ModelAndView("listArticle", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteArticle(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		ArticleBean articlebean = prepareArticleBean(articleService.getArticle(articleBean.getId()));
		model.put("article", articlebean);		
		model.put("cats",prepareCat(catservice.listArticle()));		
		model.put("articles", prepareListofBean(articleService.listArticle()));

		return new ModelAndView("addArticle", model);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewArticle(@ModelAttribute("command") ArticleBean articleBean, BindingResult result) {
				
		
		Map<String, Object> model = new HashMap<String, Object>();
		ArticleBean articlebean = prepareArticleBean(articleService.getArticle(articleBean.getId()));
		//object duplicate for html view
		 articlebeanforhtml = articlebean; 
		model.put("article", articlebean);
		
		List<ArticleBean> articleBeanList = prepareListofBean(articleService.listArticle()); 
		model.put("articles", articleBeanList);		
		List<Relate> relatedarticle = relateservice.getRelatedArticle(articleBean.getId());
		
		List<ArticleBean> relatedarticlebeans = Operation.getRelatedArticle(relatedarticle,articleBeanList);		
		model.put("related", relatedarticlebeans);
		
		List<RelateUrl> relatedUrl = relateUrlService.getRelatedArticle(articleBean.getId());		
		model.put("relatedurl", relatedUrl);
		
		/*
		 * Populate some error logic
		 */
		
		/*model.put("error", "Some Error");*/
		
		return new ModelAndView("view", model);
	}
	
	
	/**
	 * Call up the setting page
	 * @param articleBean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public ModelAndView viewSetting(@ModelAttribute("command") CategoryBean categoryBean, BindingResult result) {
		ModelAndView mdview = new ModelAndView("setting");		
		mdview.addObject("cats", prepareCat(catservice.listArticle()));		
		return mdview;
	}
	
	/**
	 * this method will open url 
	 * @param categoryBean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/openUrl", method = RequestMethod.GET)
	public RedirectView openUrl(@RequestParam("url") String url) {		
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(url);
	    return redirectView;
	}
	
	/**
	 * This will call up search page
	 * @param categoryBean
	 * @param result
	 * @return
	 */	
	@RequestMapping(value="/search" ,method=RequestMethod.GET)
	public ModelAndView getSearch(@ModelAttribute("command") ArticleBean articlebean, BindingResult result) {					
		ModelAndView mdview = new ModelAndView("search");		
		
		if(mode!=null && !mode.equals("--Select--") ){
			
			List<ArticleBean> articleList = prepareListofBean(articleService.listArticle());
			List<ArticleBean> sortlistedarticleList = articleSearch(articleList,text,mode);						
			mdview.addObject("articles", sortlistedarticleList);	
			text=null;
			mode=null;
		}
		
		return mdview;
	}	
	
	
	/**
	 * This will search for article
	 * @param articleList
	 * @param text
	 * @param mode
	 * @return
	 */
	private List<ArticleBean> articleSearch(List<ArticleBean> articleList, String searchtext, String mode) {
		List<ArticleBean> articlelist = null;
		if(searchtext!=null && searchtext.length()>0){
			 articlelist = new ArrayList<ArticleBean>();
			 
			//Search in title			 
			if ("title".equalsIgnoreCase(mode)) {
				for (ArticleBean bean : articleList) {															
					if(StringUtils.containsIgnoreCase(bean.getTitle(), searchtext.trim())){						
						articlelist.add(bean);
					}
					
				}
			}
			//Search in article 
			if ("Article".equalsIgnoreCase(mode)) {
				for (ArticleBean bean : articleList) {
					if(StringUtils.containsIgnoreCase(bean.getArticletext(), searchtext.trim())){						
						articlelist.add(bean);
					}
					
				}
			}			
			//Search in article or title
			if ("both".equalsIgnoreCase(mode)) {
				for (ArticleBean bean : articleList) {
					if(StringUtils.containsIgnoreCase(bean.getArticletext(), searchtext.trim())||StringUtils.containsIgnoreCase(bean.getTitle(), searchtext.trim())){						
						articlelist.add(bean);
					}
					
				}
			}
			
			//Search by category
			if ("category".equalsIgnoreCase(mode)) {
				for (ArticleBean bean : articleList) {
					if(StringUtils.containsIgnoreCase(bean.getCatname(), searchtext.trim())){						
						articlelist.add(bean);
					}
					
				}
			}
		}
		
		return articlelist;
	}

	/**
	 * 
	 * @param articlebean
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/searchlist" ,method=RequestMethod.POST)	
		public ModelAndView getList(@RequestParam("searchtext")String text,@RequestParam("mode")String mode) {		
		ModelAndView mdview = new ModelAndView("redirect:/search.html");		
		this.text = text;
		this.mode=  mode;		
		return mdview;
	}
	
	
	/**
	 * this will save category
	 * @param categoryBean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/savecat", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("command") CategoryBean categoryBean, BindingResult result) {
		ModelAndView mdview = new ModelAndView("setting");
		//validation for null values 
		if(categoryBean.getName()!=null && categoryBean.getName().trim().length()>0){
			Category cat = populateCat(categoryBean);
			catservice.addCategory(cat);	
		}		
		mdview.addObject("cats", prepareCat(catservice.listArticle()));		
		return mdview;
	}
	
	
	
	private Category populateCat(CategoryBean categoryBean) {
		Category cat = new Category();
		cat.setId(categoryBean.getId());
		cat.setName(categoryBean.getName());
		return cat;
	}

	/**
	 * populating category bean 
	 * @param listArticle
	 * @return
	 */
	private List<CategoryBean> prepareCat(List<Category> listArticle) {
		List<CategoryBean> catbean = new ArrayList<CategoryBean>();
		CategoryBean cbean = null;
		for(Category cat: listArticle){
			cbean = new CategoryBean();
			cbean.setId(cat.getId());
			cbean.setName(cat.getName());
			catbean.add(cbean);
		}
		return catbean;
	}

	/**
	 * Preparing model
	 * 
	 * @param article
	 *            bean
	 * @return
	 */

	private Article prepareModel(ArticleBean articleBean) {
		Article article = new Article();
		article.setId(articleBean.getId());
		article.setTitle(articleBean.getTitle());
		article.setDate(getDate());
		article.setArticletext(articleBean.getArticletext());
		article.setCatname(articleBean.getCatname());
		return article;
	}

	/**
	 * in case for deletion
	 * 
	 * @param articleBean
	 * @return
	 */
	private Article prepareModel(ArticleBean articleBean, Integer id) {
		Article article = new Article();
		article.setId(id);
		article.setTitle(articleBean.getTitle());
		article.setDate(new Date());
		article.setArticletext(articleBean.getArticletext());
		article.setCatname(articleBean.getCatname());
		return article;
	}

	/**
	 * 
	 * @param articles
	 * @return
	 */
	private List<ArticleBean> prepareListofBean(List<Article> articles) {
		List<ArticleBean> beans = null;
		if (articles != null && !articles.isEmpty()) {
			beans = new ArrayList<ArticleBean>();
			ArticleBean bean = null;
			for (Article article : articles) {
				bean = new ArticleBean();
				bean.setId(article.getId());
				bean.setTitle(article.getTitle());
				bean.setDate(article.getDate());
				bean.setCatname(article.getCatname());
				bean.setArticletext(article.getArticletext());
				beans.add(bean);
			}
		}
		return beans;
	}

	/**
	 * Get Current Date
	 * @return
	 */
	private Date getDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			//Date date = sdf.format(new Date());
		
		
		return new Date();
	}

	/**
	 * 
	 * @param article
	 * @return
	 */
	private ArticleBean prepareArticleBean(Article article) {
		ArticleBean bean = new ArticleBean();
		bean.setId(article.getId());
		bean.setTitle(article.getTitle());
		bean.setDate(article.getDate());
		bean.setArticletext(article.getArticletext());
		bean.setCatname(article.getCatname());
		return bean;
	}
}
