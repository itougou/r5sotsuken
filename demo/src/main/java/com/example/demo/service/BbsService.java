package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.BbsAddRequest;
import com.example.demo.entity.Bbs;
/**
 * BBS サービス　クラス　用インターフェース
 */
public interface BbsService {

    void addProcess( BbsAddRequest message );
    List<Bbs> getBbsProcess();
}