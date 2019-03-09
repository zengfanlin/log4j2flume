package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Person;

@Controller
public class usercontroller {
	/**
	 * 请求地址: localhost:8080/person/show?name=zhang&age=23 请求方式是get
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String show() { /** @RequestParam("name")绑定请求地址中的name到参数name中 ModelMap map 存放返回内容 */
//		Person person = new Person();
//		person.setName(name);
//		person.setAge(age);
//		map.addAttribute("person", person);
		return "index"; /** 返回的是显示数据的html的文件名 */
	}
}
