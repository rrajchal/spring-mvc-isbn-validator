package com.rajesh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping("/validateIsbn")
public class IsbnValidatorController {

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView submit (@RequestParam("isbnNum") String isbnNum) {	
		//String userInput = request.getParameter("isbnNum");
		IsbnValidator isbn = new IsbnValidator(isbnNum);
		String result = null;
		if (isbn.getValidate()) {
			result = isbnNum + ": " + "is a valid ISBN number.";
		}
		else {
			result = isbnNum + ": " + "is NOT a valid ISBN number.";
		}
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("result", result);
		//HttpSession session = request.getSession();
		//session.setAttribute("result", result);
		//response.sendRedirect("/isbn/index.jsp");
		return mv;
	}
}
