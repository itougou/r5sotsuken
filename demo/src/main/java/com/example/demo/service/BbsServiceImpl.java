package com.example.demo.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BbsAddRequest;
import com.example.demo.entity.Bbs;
import com.example.demo.repository.BbsMapper;
/**
 * BBS Service　（処理ロジック）　クラス　
 */
@Service
public class BbsServiceImpl implements BbsService{
    /**
     * BBS サービス　クラス
     */
    @Autowired
    private BbsMapper bbsMapper;

    
    //データ1件追加処理
    @Override
    public void addProcess( BbsAddRequest message ) {

    	Bbs bbs = new Bbs( message.getName(), message.getText() , new Date() );
    	bbsMapper.add( bbs );
    }
    
    //全件読み出し処理
    @Override
    public List<Bbs> getBbsProcess(){
    	return bbsMapper.findMany();
    }
}