package com.example.demo.controller;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.CustomerService;

/**
 * 顧客情報 Controller　2923.10
 */
@Controller
public class LoginController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  CustomerService customerService;
  
  @Autowired
  ModelMapper modelMapper;
  
  @Autowired
  HttpSession session; 
  
  /*
   * Get へのマッピング
   */
	@GetMapping(value = "/")	//デフォルトページ（チャットページ）へのGETリクエスト受付
	public String displayDefault(Model model) {
		System.out.println("GetMapping /");
		return "/main_menu";	//index.htmlへフォワード
	}
	@GetMapping(value = "/main_menu")	//デフォルトページ（チャットページ）へのGETリクエスト受付
	public String displayIndex(Model model) {
		return "/main_menu";	//index.htmlへフォワード
	}
	@GetMapping(value = "/chat/login")	//ログインフォームへのGETリクエスト受付
	public String displayLogin(Model model) {
		return "/chat/login";	//login.htmlへフォワード
	}
	@GetMapping(value = "/chat/index")	//ログインフォームへのGETリクエスト受付
	public String displayChat(Model model) {
		return "/chat/index";	//login.htmlへフォワード
	}
  /*
   * Post へのマッピング
   */
	@PostMapping("/chat/login")	//検索画面からの顧客検索のPOSTリクエスト受付
	public String search(@ModelAttribute LoginRequest loginRequest, Model model) {
		System.out.println("loginRequest："+loginRequest.getName());
		model.addAttribute("loginRequest", loginRequest);
		session.setAttribute( "loginRequest", loginRequest );	//セッションスコープへログイン情報セット
		return "/chat/index";	// index.htmlへフォワード
	}

}