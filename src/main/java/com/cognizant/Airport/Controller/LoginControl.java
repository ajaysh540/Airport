package com.cognizant.Airport.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.Airport.Model.AdminDetails;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;
import com.cognizant.Airport.Service.IAirport;
import com.cognizant.Airport.Service.IManagerDetailsService;

@Controller
public class LoginControl {
	@Resource(name = "managerDetailsService")
	IManagerDetailsService managerDetailsService;

	@Resource(name = "adminService")
	IAirport airportService;

	ModelAndView modelAndView;

	@RequestMapping(value = "/login")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/Register")
	public String register(String submit) {
		if (submit.equals("Register-Manager"))
			return "RegisterManager";
		else
			return "RegisterAdmin";
	}

	@RequestMapping(value = "/AdminRegister", method = RequestMethod.POST)
	public ModelAndView adminreg(AdminDetails ad) // for storing admin details in the database
	{
		ModelAndView modelAndView = new ModelAndView("Success");
		AdminDetails adminDetails = airportService.adminreg(ad);
		modelAndView.addObject("Message", adminDetails.getAdminId());
		return modelAndView;
	}

	@RequestMapping(value = "/ManagerRegister", method = RequestMethod.POST)
	public ModelAndView RegisterManager(ManagerDetails managerDetails) {
		// System.out.println(managerDetails);
		ManagerDetails md = managerDetailsService.saveManagerDetails(managerDetails);
		modelAndView = new ModelAndView("Success");
		modelAndView.addObject("Message", md.getManagerId());
		// System.out.println("\n\n\n\\n\n\n\nn\n\n\\nn\n\\n\naaaaaaa");
		return modelAndView;

	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView UserLogin(String Profile, Integer userId, String password, HttpServletRequest request,
			HttpServletResponse response) {
		LoginDetails.setProfile(Profile);
		LoginDetails.setUserId(userId);
		LoginDetails.setPassword(password);
		HttpSession session = request.getSession();

		if (LoginDetails.getProfile().equalsIgnoreCase("manager")) {
			String s = managerDetailsService.managerLogin(LoginDetails.getLoginDetails());
			if (s.equals("success")) {
				System.out.println("\n\n\n\nSuccess");
				modelAndView = new ModelAndView("ManagerAirport");
				ManagerDetails md = managerDetailsService.getManagerDetails(LoginDetails.getUserId());
				modelAndView.addObject("Manager", md);
				session.setAttribute("Name", md.getFirstName());
			} else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("error", s);
			}
		} else {
			String s = airportService.adminLogin(LoginDetails.getLoginDetails());
			if (s.equals("success")) {
				System.out.println("\n\n\n\nSuccess");
				modelAndView = new ModelAndView("AdminAirport");
				AdminDetails ad = airportService.getAdminDetails(LoginDetails.getUserId());
				modelAndView.addObject("Admin", ad);
				session.setAttribute("Name", ad.getFirstName());
			} else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("error", s);
			}
		}

		return modelAndView;
	}

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println(LoginDetails.getUserId());
		if (LoginDetails.getProfile().equalsIgnoreCase("manager")) {
			String s = managerDetailsService.managerLogin(LoginDetails.getLoginDetails());
			if (s.equals("success")) {
				System.out.println("\n\n\n\nSuccess");
				modelAndView = new ModelAndView("ManagerAirport");
				ManagerDetails md = managerDetailsService.getManagerDetails(LoginDetails.getUserId());
				modelAndView.addObject("Manager", md);

			} else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("error", s);
			}
		} else {
			String s = airportService.adminLogin(LoginDetails.getLoginDetails());
			if (s.equals("success")) {
				System.out.println("\n\n\n\nSuccess");
				modelAndView = new ModelAndView("AdminAirport");
				AdminDetails ad = airportService.getAdminDetails(LoginDetails.getUserId());
				modelAndView.addObject("Admin", ad);

			} else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("error", s);
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String logout(ModelAndView modelAndView, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/app/login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public ModelAndView error(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView=new ModelAndView("index");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		modelAndView.addObject("error", "SOME ERROR OCCURED PLEASE LOGIN AGAIN");
		return modelAndView;
	}
}
