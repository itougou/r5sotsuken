package com.example.demo.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.HelloMessage;
import com.example.demo.entity.Chat;
import com.example.demo.repository.ChatMapper;
/**
 * Chat Service　（処理ロジック）　クラス　
 */
@Service
public class ChatServiceImpl implements ChatService{
    /**
     * Chat サービス　クラス
     */
    @Autowired
    private ChatMapper chatMapper;

    
    //データ1件追加処理
    @Override
    public void addProcess( HelloMessage message ) {

    	Chat chat = new Chat( message.getName(), message.getMessage() , new Date() );
    	chatMapper.add( chat );
    }
    
    //全件読み出し処理
    @Override
    public List<Chat> getChatProcess(){
    	return chatMapper.findMany();
    }
}