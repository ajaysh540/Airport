package com.cognizant.Airport.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Service.IPilotDao;

@Controller
public class PilotController {

	@Resource(name = "pilotService")
	IPilotDao pilotService;

	@RequestMapping(value = "/viewAllPilots", method = RequestMethod.GET) // displaying the pilot details with edit
																			// button
	public ModelAndView pilotlist() {
		ModelAndView modelAndView = new ModelAndView("viewPilot");
		List<PilotDetails> pd = pilotService.pilotreqList();
		modelAndView.addObject("pilotList", pd);

		return modelAndView;
	}

	@RequestMapping(value = "/editpilotdet", method = RequestMethod.POST) // action for the edit button
	public ModelAndView editpilotdet(int pilotid) {
		ModelAndView modelAndView = new ModelAndView("editPilot");
		PilotDetails pd = pilotService.editPilotDetails(pilotid);
		modelAndView.addObject("pilot", pd);

		return modelAndView;
	}

	@RequestMapping(value = "/saveEditpilotdet", method = RequestMethod.POST) // updating the pilot details in the db
	public String saveeditpilotdet(PilotDetails pd) {

		pilotService.saveEditPilotDetails(pd);

		return "redirect:/app/viewAllPilots";
	}

	@RequestMapping(value = "/Addpilot", method = RequestMethod.GET)
	String addPilot() {
		return "addPilot";
	}

	@RequestMapping(value = "/addPilotDetails", method = RequestMethod.POST)
	public String addPilot(PilotDetails pilotDetails) {
		pilotService.addPilotDetails(pilotDetails);
		return "redirect:/app/viewAllPilots";
	}

	@RequestMapping(value = "/removepilot", method = RequestMethod.POST)
	public String removePilot(int pilotId) {
		pilotService.removePilotDetails(pilotId);
		return "redirect:/app/viewAllPilots";
	}

}
