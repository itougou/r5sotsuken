package com.example.demo.controller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;

@RestController	//JSONやXMLをレスポンスするようなAPI形式の場合は、@RestControllerを使う
@RequestMapping("/J") //パスに「/J」を指定
public class JsonController {
  @GetMapping("/get")
  public Map<String, String> hello(@ModelAttribute LoginRequest loginRequest, Model model) {
	  System.out.println("loginRequest.name="+loginRequest.getName());
    return Map.of("msg", loginRequest.getName()+"さん、こんにちは。");
  }
  @PostMapping("/post")
 // public Map<String, String> hello_post(@ModelAttribute LoginRequest loginRequest, Model model) {
  //JSON形式で受信する場合こっち @RequestBody LoginRequest loginRequest
  public Map<String, String> hello_post(@RequestBody LoginRequest loginRequest, Model model) {
	  System.out.println("loginRequest.name="+loginRequest.getName());
    return Map.of("msg", loginRequest.getName()+"さん、こんにちは。");
  }
}