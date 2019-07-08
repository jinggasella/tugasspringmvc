package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@RequestMapping("hello")
	public String hello() {
		return "hello" ;  // hello ini manggil nama hello.html. jadi namanya harus sama
	}
//-------------------------------------------------------------------------------------

//http://localhost:8080/my/myName?name=Sella
	@RequestMapping("myName")
	public String myName(@RequestParam String name, Model model) { // fungsi model : menguhubungkan dan mengirimkan java ke html
		
		model.addAttribute("name", name);  //pilih yg model // "name" nama parameter utk dikirim ke html (cek coding di html)
		
		return "myname" ;  
	}

}
