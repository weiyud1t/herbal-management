package com.herbalmanagement.service;

import com.herbalmanagement.pojo.HerbInfo;

import java.util.List;

public interface HerbService {
    List<HerbInfo> findAll(int page,int size);
    long countAll();
    void deleteById(int id);
    void add(HerbInfo herbInfo);
    void update(HerbInfo herbInfo);
    HerbInfo findById(int id);
    void purchase(Integer id, Integer quantity);
    void buy(Integer id, Integer quantity);
    boolean checkHerbNameExists(String herbName);
}
