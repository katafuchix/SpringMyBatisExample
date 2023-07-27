package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.EmployeeMapper;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping("list")
	public ModelAndView listAll() {
		
		logger.info("Called getWhiskies.");
        logger.error("Error getWhiskies.");
        
		ModelAndView mav = new ModelAndView("list");
		
		// すべてのユーザーを取得する
		mav.addObject("employees", employeeMapper.selectAll());
		
		System.out.println(""
				+ ""
				+ "ああああ");
		logger.info("access GET sample");
		return mav;
	}
	
    //@RequestMapping(value = "emp", method = RequestMethod.GET) // /sample でアクセス
	@GetMapping("/index")
    public String getSomething() {
        
        return "do something";
    }
}
