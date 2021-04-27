package br.com.jeyzandra.agropopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlleragro {
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
