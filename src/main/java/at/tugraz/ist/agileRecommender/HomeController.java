package at.tugraz.ist.agileRecommender;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import at.tugraz.ist.agileRecommender.lucene.app.*;
import at.tugraz.ist.agileRecommender.lucene.workflow.ParseWF;
import at.tugraz.ist.agileRecommender.lucene.workflow.RecommendedWorkFlowList;
import at.tugraz.ist.agileRecommender.lucene.workflow.WorkFlow;
import at.tugraz.ist.agileRecommender.profile.Profile;
import at.tugraz.ist.agileRecommender.profile.RandomProfileGenerator;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		RandomProfileGenerator randomProfile = new RandomProfileGenerator();
		Profile gwProfile = randomProfile.generateProfile();
	   
		model.addAttribute("apps",gwProfile.apps);
		model.addAttribute("wfs",gwProfile.wfs);
		model.addAttribute("resources",gwProfile.resources);
		model.addAttribute("devices",gwProfile.devices);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAppRecomm", method = RequestMethod.POST)
	public Set<App> getAppRecomm(@RequestBody App app) {
		
		ParseApp.getAppList(app.getTitle());
		RecommendedAppList.appList.clear();
		
		try {
			RecommendApps.getRecommendation(app.getTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedAppList.appList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getWFRecomm", method = RequestMethod.POST)
	public Set<WorkFlow> getWFRecomm(@RequestBody WorkFlow wf) {
		
		ParseWF.getWorkFlows();
		RecommendedWorkFlowList.workflowList.clear();
		
		try {
			RecommendWorkFlow.getRecommendation(wf.getDatatag());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedWorkFlowList.workflowList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getProfile", method = RequestMethod.POST)
	public Profile getProfile(@RequestBody Profile p) {
		
		RandomProfileGenerator randomProfile = new RandomProfileGenerator();
		Profile gwProfile = randomProfile.generateProfile();
		
		return gwProfile;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getRecommendation", method = RequestMethod.POST)
	public ModelAndView getRecommendation(HttpServletRequest request) {
		
		String apps = request.getParameter("apps");
		String wfs = request.getParameter("wfs");
		String devices = request.getParameter("devices");
		String algorithm = request.getParameter("alg");
		String output = request.getParameter("out");
		int i = 0;
		
	
		ModelAndView mav = new ModelAndView(new RedirectView ("home.jsp"));
		mav.addObject("results","HEBELE");
		
		return mav;
	}
	
	
}
