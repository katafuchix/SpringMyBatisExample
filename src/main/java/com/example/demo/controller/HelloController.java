package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation. RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
	
	//@RequestMapping("/hello") // ここをhelloでアクセスする場合
	@GetMapping("view") // hello/view でアクセス  クラス/メソッド の形式でURLを作成する場合
	public String hello() {
		return "hello";
	}

}