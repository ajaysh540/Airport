package com.cognizant.Airport.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Model.PlaneHangarStatus;
import com.cognizant.Airport.Service.IAssignHangarPlane;

@Controller
public class AssignHangarPlane {

	@Resource(name="assignHangarPlaneService")
	IAssignHangarPlane assignHangarPlane;
	
	public AssignHangarPlane() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/ViewUnassignedHangarPlane", method=RequestMethod.GET)
	public ModelAndView viewUnssigned() {
		ModelAndView modelAndView = new ModelAndView("hangarPlane");
		List<PlaneDetails> planeList = assignHangarPlane.getUnassignedPlane();
		List<HangarStatus> hangarList = assignHangarPlane.getUnassignedHangar();
		modelAndView.addObject("planeList",planeList);
		modelAndView.addObject("hangarList",hangarList);
		return modelAndView;
	}
	
	@RequestMapping(value="/AssignHangarPlane", method=RequestMethod.POST)
	public String assignPlaneToHangar(String hangarId, String planeId, String availableFD, String availableTD, String occupancyFD, String occupancyTD) {
		PlaneHangarStatus planeHangarStatus = new PlaneHangarStatus();
		HangarDetails hangarDetails = assignHangarPlane.findHangarDetailsById(Integer.parseInt(hangarId));
		PlaneDetails planeDetails = assignHangarPlane.findPlaneDetailsById(Integer.parseInt(planeId));
		planeHangarStatus.setHangarDetails(hangarDetails);
		planeHangarStatus.setPlaneDetails(planeDetails);
		assignHangarPlane.assignHangarPlane(planeHangarStatus);
		assignHangarPlane.updateHangarStatusDetails(Integer.parseInt(hangarId),availableFD,availableTD,occupancyFD,occupancyTD);
		return "redirect:/app/checkhangarstatus";
		//return null;
	}
}
