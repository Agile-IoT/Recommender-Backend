package at.tugraz.ist.agileRecommender;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
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
import at.tugraz.ist.agileRecommender.mahout.FileOperations;
import at.tugraz.ist.agileRecommender.mahout.UserBased;
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
		
		setDefaultSelections(model);
		return "home";
	}
	
	public Model setDefaultSelections( Model model) {
		RandomProfileGenerator randomProfile = new RandomProfileGenerator();
		Profile gwProfile = randomProfile.generateProfile();
		String data = FileOperations.readFile("AppRatings", -1);
		
		model.addAttribute("userID",gwProfile.userID);
		model.addAttribute("apps",gwProfile.apps);
		model.addAttribute("wfs",gwProfile.wfs);
		model.addAttribute("resources",gwProfile.resources);
		model.addAttribute("devices",gwProfile.devices);
		model.addAttribute("algorithm","CB");
		model.addAttribute("output","App");
		model.addAttribute("knowledgebase","AppRatings");
		model.addAttribute("fileData",data);
		
		return model;
	}
	
	public ModelAndView setDefaultGateway(ModelAndView model) {
		RandomProfileGenerator randomProfile = new RandomProfileGenerator();
		Profile gwProfile = randomProfile.generateProfile();
		String data = FileOperations.readFile("AppRatings", -1);
		
		model.addObject("userID",gwProfile.userID);
		model.addObject("userID",gwProfile.userID);
		model.addObject("apps",gwProfile.apps);
		model.addObject("wfs",gwProfile.wfs);
		model.addObject("resources",gwProfile.resources);
		model.addObject("devices",gwProfile.devices);
		model.addObject("algorithm","CB");
		model.addObject("output","App");
		
		return model;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/app/getCBAppRecomm", method = RequestMethod.POST)
	public Set<App> getCBAppRecomm(@RequestBody Profile profile) {
		
		return Recommenders.getCBAppRecomm(profile);
	}
	
	@ResponseBody
	@RequestMapping(value = "/workflow/getCBWFRecomm", method = RequestMethod.POST)
	public Set<WorkFlow> getCBWFRecomm(@RequestBody Profile profile) {
		return Recommenders.getCBWfRecomm(profile);
	}
	
	@ResponseBody
	@RequestMapping(value = "/app/UBCFAppRecomm", method = RequestMethod.POST)
	public List<App> getUBCFAppRecomm(@RequestBody Profile profile) {
		return Recommenders.getUBCFAppRecomm(profile.userID);
	}
	
	@ResponseBody
	@RequestMapping(value = "/workflow/getUBCFWfRecomm", method = RequestMethod.POST)
	public List<WorkFlow> getUBCFWfRecomm(@RequestBody Profile profile) {
		return Recommenders.getUBCFWfRecomm(profile.userID);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getProfile", method = RequestMethod.GET)
	public Profile getProfile() {
		
		RandomProfileGenerator randomProfile = new RandomProfileGenerator();
		Profile gwProfile = randomProfile.generateProfile();
		
		return gwProfile;
	}
	
	@ResponseBody
	@RequestMapping(value = "/readFile", method = RequestMethod.POST)
	public ModelAndView readFile(HttpServletRequest request, Model model) {
		
		String knowledgebase = request.getParameter("kb");
		
		String data = FileOperations.readFile(knowledgebase, -1);
		
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("fileData",data);
		mav.addObject("knowledgebase",knowledgebase);
		return setDefaultGateway(mav);
	}
	

	@ResponseBody
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST)
	public ModelAndView updateFile(HttpServletRequest request, Model model) {
		
		String fileData = request.getParameter("fd");
		String knowledgebase = request.getParameter("kbUpdate");
		
		boolean response = FileOperations.writeFile(knowledgebase, fileData);

		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("fileData",fileData);
		mav.addObject("knowledgebase",knowledgebase);
		
		return setDefaultGateway(mav);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getRecommendation", method = RequestMethod.POST)
	public ModelAndView getRecommendation(HttpServletRequest request, Model model) {
		
		String userID = request.getParameter("userID");
		String apps = request.getParameter("apps");
		String wfs = request.getParameter("wfs");
		String devices = request.getParameter("devices");
		String resources = request.getParameter("resources");
		String algorithm = request.getParameter("alg");
		String output = request.getParameter("out");
		String knowledgebase = request.getParameter("kbUpdate");
		String fileData = request.getParameter("fd");
		
		Profile profile = new Profile();
		profile.userID= Long.valueOf(userID);
		profile.apps= apps;
		profile.wfs= wfs;
		profile.devices= devices;
		profile.resources= resources;
	
		String results ="<b>Recommended "+output+"s using "+algorithm+" Algorithm</b><br><br>";
		
		if(output.equals("App")){
			if(algorithm.equals("CB")){
				results = Recommenders.getCBAppRecomm(profile, results);
			}
			if(algorithm.equals("UBCF")){
				results = Recommenders.getUBCFAppRecomm(profile.userID, results);
			}
			if(algorithm.equals("IBCF")){
				results += "Not implemented yet<br>";
			}
		}	
		else if(output.equals("Workflow")){
			if(algorithm.equals("CB")){
				results = Recommenders.getCBWfRecomm(profile, results);
			}
			if(algorithm.equals("UBCF")){
				results = Recommenders.getUBCFWfRecomm(profile.userID, results);
			}
			if(algorithm.equals("IBCF")){
				results += "Not implemented yet<br>";
			}
			
		}
		else if(output.equals("Device")){
			if(algorithm.equals("CB")){
				results += "Not implemented yet<br>";
			}
			if(algorithm.equals("UBCF")){
				results += "Not implemented yet<br>";
			}
			if(algorithm.equals("IBCF")){
				results += "Not implemented yet<br>";
			}
	
		}

		ModelAndView mav = new ModelAndView("home");
		mav.addObject("results",results);
		
		mav.addObject("userID",userID);
		mav.addObject("apps",apps);
		mav.addObject("wfs",wfs);
		mav.addObject("resources",resources);
		mav.addObject("devices",devices);
	
		mav.addObject("algorithm",algorithm);
		mav.addObject("output",output);
		mav.addObject("knowledgebase",knowledgebase);
		mav.addObject("fileData",fileData);
		
		return mav;
	}
		
}
