package com.cognizant.Airport.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Model.PilotPlaneDetails;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Model.PlaneHangarStatus;
import com.cognizant.Airport.Service.IAssignPlanePilot;

@Controller
public class AssignPlanePilot {
	
	@Resource(name="assignPlanePilotService")
	IAssignPlanePilot assignPlanePilot;
	
	@RequestMapping(value="/ViewUnassignedPlaneHangar", method=RequestMethod.POST)
	public ModelAndView viewUnssigned(PlaneHangarStatus planeHangarStatus, PilotPlaneDetails pilotPlaneDetails, PlaneDetails planeDetails, HangarStatus hangarStatus, PilotDetails pilotDetails) {
		ModelAndView modelAndView = new ModelAndView("assignPilotPlane");
		List<PlaneDetails> planeList = assignPlanePilot.getUnassignedPlane();
		List<PilotDetails> pilotList = assignPlanePilot.getUnassignedPilot();
		modelAndView.addObject("planeList",planeList);
		modelAndView.addObject("pilotList",pilotList);
		return modelAndView;
	}
	
	@RequestMapping(value="/AssignPilotPlane", method=RequestMethod.POST)
	public ModelAndView assignPlaneToPilot(String planeId, String pilotId) {
		ModelAndView modelAndView = new ModelAndView("Success");	// JSP name
		modelAndView.addObject("message","Assigned successfully"); //attribute value
		PilotPlaneDetails pilotPlaneDetails = new PilotPlaneDetails();
		PilotDetails pilotDetails = assignPlanePilot.findPilotDetailsById(Integer.parseInt(pilotId));
		PlaneDetails planeDetails = assignPlanePilot.findPlaneDetailsById(Integer.parseInt(planeId));
		pilotPlaneDetails.setPilotDetails(pilotDetails);
		pilotPlaneDetails.setPlaneDetails(planeDetails);
		assignPlanePilot.assignPlaneToPilot(pilotPlaneDetails);
		return modelAndView;
	}

}
