package com.example.demo.controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.CustomerAddRequest;
import com.example.demo.dto.CustomerSearchRequest;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

/**
 * 顧客情報 Controller　伊藤剛　2023.12.23 17：17
 */
@Controller
public class CustomerController {
  /**
   * ユーザー情報 Service
   */
	  @Autowired
	  CustomerService customerService;
	  
	  @Autowired
	  ModelMapper modelMapper;
  
  /*
   * Get へのマッピング
   */
  @GetMapping(value = "/customer/")	//顧客のデフォルトページ(メニュー)へのGETリクエスト受付
  public String displayIndex(Model model) {
    return "customer/menu";	//menu.htmlへフォワード
  }
  @GetMapping(value = "/customer/menu")	//顧客メニューへのGETリクエスト受付
  public String displayMenu(Model model) {
    return "customer/menu";	//menu.htmlへフォワード
  }
  @GetMapping(value = "/customer/search")
  public String displaySearch(Model model) {	//顧客検索ページへのGETリクエスト受付
    return "customer/search";	//search.htmlへフォワード
  }
  @GetMapping(value = "/customer/list")	//顧客一覧ページへのGETリクエスト受付
  public String displaySearchAll(Model model) {
	//System.out.println("customerService="+customerService);
	List<Customer> customer = customerService.getCustomer();	//プルダウン表示用に顧客情報を読み出す
	model.addAttribute("customerlist", customer);	//list.htmlへ顧客情報を渡す　
    return "customer/list";	//list.htmlへフォワード
  }
  @GetMapping(value = "/customer/add")	//顧客追加ページへのGETリクエスト受付
  public String displayAdd(Model model) {
    return "customer/add";	//add.htmlへフォワード
  }

  /*
   * Post へのマッピング
   */
  @PostMapping("/customer/id_search")	//検索画面からの顧客検索のPOSTリクエスト受付
  public String search(@ModelAttribute CustomerSearchRequest customerSearchRequest, Model model) {
	Customer customer = customerService.search(customerSearchRequest);
    model.addAttribute("customerinfo", customer);
    return "customer/search";	//search.htmlへフォワード
  }
  @PostMapping("/customer/add")	//追加画面からの顧客追加のPOSTリクエスト受付
  public String add(@ModelAttribute CustomerAddRequest customerAddRequest, Model model) {
	Customer customer = modelMapper.map( customerAddRequest, Customer.class );	//リクエスト受け渡しデータからcustomerエンティティへデータ変換
	customerService.add( customer );
    
	model.addAttribute("customerData", customer );
	 return "customer/addResult"; 	//addResult.htmlへフォワード
    
  }
}
