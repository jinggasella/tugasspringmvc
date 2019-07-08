package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// controller sebagai router
@Controller
public class HelloController {
	
	@RequestMapping("/hello") // kalo di running yg belum ditambahin @responbody, di localhost bakal muncum whitelabel
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}
//crud thymeleaf
	
//------------------------------------------------------------------------------------------	
//http://localhost:8080/myName?myName=Jingga \\  parameter nya ?. j
	@RequestMapping("/myName") 
	@ResponseBody
	public String myName(@RequestParam String myName) {
		return "Hello " + myName;
// menampung parameter : requestparam
// menampilkan nilai fungsi yg kita buat : requestbody
// untuk mapping url kita : requestmapping
	}
	
//---------------------------------------------------------------------------------------------	
//http://localhost:8080/namaSaya/JinggaSella  \\ ini bentuknya pakai slash"/" untuk menampung variabel nya
	@RequestMapping("/namaSaya/{myName}") 
	@ResponseBody
	public String namaSaya(@PathVariable String myName) {
		return "Hello " + myName;
	}
	
//-----------------------------------------------------------------------------------------------------
// http://localhost:8080/toGoogle	\\bikin link
//	@RequestMapping("/toYoutube") 
//	@ResponseBody
//	public String toGoogle() {
//		return "<a href = 'https://www.youtube.com'> Klik disini menuju Youtube </a>";
//	}
	
//	@RequestMapping("/toYoutube") 
//	@ResponseBody
//	public String toGoogle() {
//		return "<a href = 'https://www.youtube.com'> Klik disini menuju Youtube </a> "
//				+ "</br> <a href = 'https://www.google.com'> Klik disini menuju Google </a>" ;
//	}
	
//-----------------------------------------------------------------------------------------	
// tambahkan target='_blank' untuk dibuka dia di new tab	
	@RequestMapping("/toYoutube") 
	@ResponseBody
	public String toGoogle() {
		return "<a href = 'https://www.youtube.com' target ='_blank'> Klik disini menuju Youtube </a> "
				+ "</br> <a href = 'https://www.google.com' target ='_blank'> Klik disini menuju Google </a>" ;
	}
	
//-------------------------------------------------------------------------------------------
	
	
}
