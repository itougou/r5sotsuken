package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Customer;
/**
 * ユーザー情報 Service
 */
import com.example.demo.service.CustomerService;
@RestController	//JSONやXMLをレスポンスするようなAPI形式の場合は、@RestControllerを使う
@RequestMapping("/J") //パスに「/J」を指定
public class JsonController {

  @Autowired
  CustomerService customerService;
	
  @GetMapping("/get")
  public Map<String, String> hello(@ModelAttribute LoginRequest loginRequest, Model model) {
		System.out.println("loginRequest.name="+loginRequest.getName());
	  
		return Map.of("msg", loginRequest.getName()+"さん、こんにちは。");
  }
	
  @GetMapping("/get/list")
  //public Map<String, String> list(@ModelAttribute LoginRequest loginRequest, Model model) {
  public List<Customer> list(@ModelAttribute LoginRequest loginRequest, Model model, HttpServletRequest request) {
		System.out.println("loginRequest.name(仮のパラメータ)="+loginRequest.getName());

		HttpSession session = request.getSession(true);	//セッションスコープ生成
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		System.out.println("/get/list セッションスコープ内容："+loginCustomer);
		if( loginCustomer == null  ) {
			return new ArrayList<Customer>();
		}
		List<Customer> customer = customerService.getCustomer();	//プルダウン表示用に顧客情報を読み出す
		//return Map.of("list", "顧客リスト");
		return customer;
		//return new ArrayList<Customer>();
  }
  @PostMapping("/post")
 // public Map<String, String> hello_post(@ModelAttribute LoginRequest loginRequest, Model model) {
  //JSON形式で受信する場合こっち @RequestBody LoginRequest loginRequest
  public Map<String, String> hello_post(@RequestBody LoginRequest loginRequest, Model model) {
		System.out.println("loginRequest.name="+loginRequest.getName());
		return Map.of("msg", loginRequest.getName()+"さん、こんにちは。");
  }
  @PostMapping("/post/login")
 // public Map<String, String> hello_post(@ModelAttribute LoginRequest loginRequest, Model model) {
  //JSON形式で受信する場合こっち @RequestBody LoginRequest loginRequest
  public Map<String, String> login(@RequestBody LoginRequest loginRequest, Model model , HttpServletRequest request) {
		System.out.println("/post/login loginRequest.name="+loginRequest.getName());
  	
		int id;
		String ret = "";
		try{
			id = Integer.parseInt( loginRequest.getName() ) ;	
			Customer customer = customerService.searchById( Integer.parseInt(loginRequest.getName()) );
			if( customer == null ) {
				ret = "ログイン失敗";
			} else {
				//ret = loginRequest.getName()+"さん、こんにちは。";
				ret = customer.getName();
				HttpSession session = request.getSession(true);	//セッションスコープ生成
				session.setAttribute("loginCustomer", customer );   	//セッションスコープにログイン成功した顧客のエンティティ保存	
				//model.addAttribute( "customerinfo", customer );//不要？
			}
		}catch(Exception e) {
			ret  = "サーバー側でエラー発生";
		}
  		return Map.of("msg", ret );
  }
}