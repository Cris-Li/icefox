package icefox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/icefox")
public class SearchController {
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value="/searchcompany")
	public String searchCompanyInfo(){
		System.out.println("ok");
		return null;
		
	}

}
