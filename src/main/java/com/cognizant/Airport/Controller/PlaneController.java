package com.cognizant.Airport.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Service.IAddPlane;

@Controller
public class PlaneController {

	@Resource(name = "AddPlaneService")
	IAddPlane addPlaneDaoservice;

	@RequestMapping(value = "/addPlane", method = RequestMethod.GET)
	String addproductPage() {
		return "addPlane"; // JSP name of add plane page
	}

	@RequestMapping(value = "/AddPlaneController", method = RequestMethod.POST)
	public String addPlane(PlaneDetails planeDetails) {
		addPlaneDaoservice.addPlane(planeDetails);
		return "redirect:/app/viewAllPlanes";
	}

	@RequestMapping(value = "/viewAllPlanes", method = RequestMethod.GET)
	public ModelAndView viewPlanes() {
		ModelAndView modelAndView = new ModelAndView("viewPlane");
		List<PlaneDetails> li = addPlaneDaoservice.viewAllPlanes();
		modelAndView.addObject("planeList", li);
		return modelAndView;
	}

	@RequestMapping(value = "/ViewPlaneDetail", method = RequestMethod.GET)
	public ModelAndView planeDetail(Integer pid) {
		ModelAndView modelAndView = new ModelAndView("editPlane");
		modelAndView.addObject("planeDetails", addPlaneDaoservice.viewDetails(pid));
		return modelAndView;
	}

	@RequestMapping(value = "/updatePlane", method = RequestMethod.POST)
	public String updatePlane(PlaneDetails pd) {
		addPlaneDaoservice.updatePlane(pd);
		return "redirect:/app/viewAllPlanes";
	}

}
