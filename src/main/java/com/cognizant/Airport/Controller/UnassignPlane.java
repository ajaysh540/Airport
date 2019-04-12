package com.cognizant.Airport.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Service.IAssignHangarPlane;
import com.cognizant.Airport.Service.IUnassignPlane;

@Controller
public class UnassignPlane {

	@Resource(name="unassignPlaneService")
	IUnassignPlane unassignPlane;
	
	@Resource(name="assignHangarPlaneService")
	IAssignHangarPlane assignHangarPlane;
	
	@RequestMapping(value="/checkhangarstatus",method=RequestMethod.GET)
	public ModelAndView checkHangar(String hangarId) {
		ModelAndView modelAndview=new ModelAndView("HangarStatus");
		List<HangarStatus> li=unassignPlane.getAssignedHangar();
		System.out.println(li.size());
		modelAndview.addObject("assignedHangarList",li);
		modelAndview.addObject("unassignedHangarList",assignHangarPlane.getUnassignedHangar());
		return modelAndview;
	}
	
	@RequestMapping(value="/unassignHangar",method=RequestMethod.POST)
	public String unassignHangar(String hangarId) {
		unassignPlane.unassignHangar(hangarId);
		return "redirect:/app/checkhangarstatus";
	}
}
