package com.cognizant.Airport.Controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Service.IHangarDao;

@Controller
public class HangarController {

	static Logger logger = Logger.getLogger(HangarController.class);

	public HangarController() {
		// TODO Auto-generated constructor stub
	}

	@Resource(name = "HangarHibService")
	IHangarDao HangarHibService;

	@RequestMapping(value = "/addHangar", method = RequestMethod.GET)
	public String addPage() {
		return "addHangar";
	}

	@RequestMapping(value = "/addhangardetails", method = RequestMethod.POST)
	public String addhangdetails(HangarDetails hd) {
		HangarHibService.addHangarDetails(hd);
		return "redirect:/app/viewAllHangars";
	}
	

	@RequestMapping(value = "/viewAllHangars", method = RequestMethod.GET)
	public ModelAndView added(HangarDetails hd) {
		ModelAndView modelAndView = new ModelAndView("viewHangar");

		List<HangarDetails> hd1 = HangarHibService.getAllHangar();

		//modelAndView = new ModelAndView(/* "jsp name" */);
		modelAndView.addObject("hangarList", hd1);

		return modelAndView;
	}

	@RequestMapping(value = "/viewhanger", method = RequestMethod.GET)
	public ModelAndView viewhanger(int hId) {
		
		ModelAndView modelAndView = new ModelAndView("editHangar");
		modelAndView.addObject("hangar", HangarHibService.getHangarDetails(hId));
		return modelAndView;
	}
	@RequestMapping(value="/edithangar",method=RequestMethod.POST)
	public String editHangar(HangarDetails hangarDetails) {
		HangarHibService.editHangarDetails(hangarDetails);
		return "redirect:/app/viewAllHangars";
	}

}
