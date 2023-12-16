package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.CustomerSearchRequest;
import com.example.demo.entity.Customer;
/**
 * 顧客情報 サービス　クラス　用インターフェース
 */
public interface CustomerService {

    Customer search(CustomerSearchRequest customer);
    Customer searchById(int id );	//2023.12.16 追加
    void add(Customer customer);
    List<Customer> getCustomer();
}