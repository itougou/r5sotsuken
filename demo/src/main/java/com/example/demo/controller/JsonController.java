package com.example.demo.controller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;

@RestController
public class JsonController {
  @GetMapping("/json")
  public Map<String, String> hello(@ModelAttribute LoginRequest loginRequest, Model model) {
	  System.out.println("loginRequest.name="+loginRequest.getName());
    return Map.of("msg", loginRequest.getName()+"さん、こんにちは。");
  }
}