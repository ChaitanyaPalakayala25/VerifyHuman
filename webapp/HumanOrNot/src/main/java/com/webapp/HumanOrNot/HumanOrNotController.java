package com.webapp.HumanOrNot;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanOrNotController  {
	
	Random rand = new Random();
	HttpSession session = null;
	@RequestMapping("home")
	public String home( HttpServletRequest req) 
	{
		session = req.getSession();
		
		int a = rand.nextInt(10);
		int b = rand.nextInt(10);
		int c = rand.nextInt(10);
		int actualsum = a+b+c;
		String question = a+ "," +b+ "," +c;
		session.setAttribute("question", question);
		session.setAttribute("actualsum", actualsum);
		return "home.jsp";
	
	}
	
	@RequestMapping(value = "/checksum", method = RequestMethod.GET)
    public String checksum(@RequestParam("Sum") String sum,Model model) {
         System.out.println(sum);
         System.out.println(session.getAttribute("actualsum"));
        if((sum).equals(session.getAttribute("acutalsum"))) {
        		model.addAttribute("message","successfull");
        }
        	model.addAttribute("message","Try again");
        return "home.jsp";
    }
	
}
