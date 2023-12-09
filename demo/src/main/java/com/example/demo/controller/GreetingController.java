package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.bean.Greeting;
import com.example.demo.bean.HelloMessage;
import com.example.demo.entity.Chat;
import com.example.demo.service.ChatService;

@Controller
public class GreetingController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ChatService chatService;
	  
    @MessageMapping("/hello")	//クライアントからの/hello宛のデータ受信した際にGreetingメソッドを呼び出す宣言
    @SendTo("/topic/greetings")	//クライアント側の全ての/topic/greetings宛に Greetingメソッドの戻り値をブロードキャスト送信する宣言
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("message.name:"+message.getName()+"message.message:"+message.getMessage());
        chatService.addProcess( message );
        return new Greeting(HtmlUtils.htmlEscape(message.getName())
                + " : "
                + HtmlUtils.htmlEscape( message.getMessage()) );
    }
    
    /*
     * Get へのマッピング
     */
  	@GetMapping(value = "/chat/list")	//過去のチャットへのGETリクエスト受付
  	 public String displaySearchAll(Model model) {
  		
  		List<Chat> chatlist = chatService.getChatProcess();	//
  		model.addAttribute("chatlist", chatlist);	//list.htmlへ顧客情報を渡す　

  		return "/chat/chat_list";	//index.htmlへフォワード
  	}
  	
    
}