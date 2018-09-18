package com.stewartNinjaGold;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gold")
public class NinjaGoldController {
	
	@GetMapping("")
	public String main(HttpSession session) {
		if(session.getAttribute("gold") == null || session.getAttribute("activities") == null) {
			session.setAttribute("gold", 0);
			
			ArrayList<Activity> activities = new ArrayList<Activity>();
			session.setAttribute("activities", activities);
		}
		return "gold.jsp";
	}
	
	@PostMapping("/process/m/{location}")
	public String process(HttpSession session, @PathVariable("location") String location) {
		
		Activity task = new Activity(location);
		task.calculate();
		session.setAttribute("gold", (int) session.getAttribute("gold") + task.getGoldGain());
		
		@SuppressWarnings("unchecked")
		ArrayList<Activity> activities = (ArrayList<Activity>)session.getAttribute("activities");
		
		activities.add(task);
		
		session.setAttribute("activities", activities);
		
		return "redirect:/gold";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		ArrayList<Activity> activities = new ArrayList<Activity>();
		session.setAttribute("activities", activities);
		return "redirect:/gold";
	}
}
