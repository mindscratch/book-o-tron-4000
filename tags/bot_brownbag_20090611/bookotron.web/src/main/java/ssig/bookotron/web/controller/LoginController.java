package ssig.bookotron.web.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssig.bookotron.web.constants.View;

@Controller
public class LoginController {
	
	

	@RequestMapping("/login.htm")
    public ModelAndView indexHandler() { 
		Map<String, String> model = new HashMap<String, String>();	       
		model.put("time", Calendar.getInstance().getTime().toString());
	    return new ModelAndView(View.LOGIN, model);

    }

}

