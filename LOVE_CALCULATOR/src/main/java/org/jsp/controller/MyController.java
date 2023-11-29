package org.jsp.controller;

import org.jsp.dto.User;
import org.jsp.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({ "fname", "sname", "result", "mail" })
public class MyController {

	@Autowired
	private MyService s;

	@RequestMapping("/takenames")
	public String takeNames(Model m) {
		m.addAttribute("u", new User());
		return "first";
	}

	@RequestMapping("/process")
	public ModelAndView processNames(ModelAndView view, @ModelAttribute User user) {

		String res = s.doProcess(user);
		view.setViewName("second");
		view.addObject("result", res);
		view.addObject("fname", user.getFname());
		view.addObject("sname", user.getSname());

		return view;
	}

	@RequestMapping("/takeemail")
	public String takeEmail(Model m) {
		return "receivemail";
	}

	@RequestMapping("/emailprocess")
	public String processEmail(Model model, @RequestParam String mail) {
		model.addAttribute("mail", mail);

		String fname = (String) model.getAttribute("fname");
		String sname = (String) model.getAttribute("sname");
		String result = (String) model.getAttribute("result");
		s.sendMail(mail, fname, sname, result);
		System.out.println("sendMail() is execued");
		return "successemail";

	}

}
