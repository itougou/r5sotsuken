package com.example.demo.service;
import java.util.List;

import com.example.demo.bean.HelloMessage;
import com.example.demo.entity.Chat;
/**
 * チャット サービス　クラス　用インターフェース
 */
public interface ChatService {

    void addProcess( HelloMessage message );
    List<Chat> getChatProcess();
}