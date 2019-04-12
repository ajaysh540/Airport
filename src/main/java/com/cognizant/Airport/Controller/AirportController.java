package com.cognizant.Airport.Controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.Airport.Model.AdminDetails;
import com.cognizant.Airport.Model.ManagerDetails;
import com.cognizant.Airport.Service.IAirport;

@Controller
public class AirportController {

	public AirportController() {

	}

	@Resource(name = "adminService")
	IAirport adminService;

	@RequestMapping(value = "/RequestList", method = RequestMethod.GET)
	public ModelAndView reqlist() // to display the unapproved admins and managers
	{
		ModelAndView modelAndView = new ModelAndView("pending");
		List<AdminDetails> ad = adminService.adminreqList();
		modelAndView.addObject("adminList", ad);
		List<ManagerDetails> md = adminService.managerreqList();
		modelAndView.addObject("managerList", md);
		return modelAndView;
	}

	@RequestMapping(value = "/AdminApproveRequest", method = RequestMethod.POST)
	public String adminapprovereq(Integer adminid) // to approve the another admin
	{
		adminService.adminapproverequest(adminid);
		return "redirect:/app/RequestList";

	}

	@RequestMapping(value = "/ManagerApproveRequest", method = RequestMethod.POST)
	public String managerapprovereq(Integer managerid) // to approve the manager
	{
		// System.out.println(managerid);
		adminService.managerapproverequest(managerid);
		return "redirect:/app/RequestList";
	}
}
