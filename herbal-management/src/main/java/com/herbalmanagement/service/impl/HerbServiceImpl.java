package com.herbalmanagement.service.impl;

import com.herbalmanagement.service.HerbService;
import com.herbalmanagement.mapper.HerbInfoMapper;
import com.herbalmanagement.pojo.HerbInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerbServiceImpl implements HerbService {
    @Autowired
    private HerbInfoMapper mapper;
    @Override
    public List<HerbInfo> findAll(int page,int size) {
        page = (page - 1) * size;
        List<HerbInfo> herbInfos = mapper.selectByExampleWithBLOBs(null,page,size);
        return herbInfos;
    }

    @Override
    public long countAll() {
        long l = mapper.countByExample(null);
        return l;
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(HerbInfo herbInfo) {
        mapper.insertSelective(herbInfo);
    }

    @Override
    public void update(HerbInfo herbInfo) {
        mapper.updateByName(herbInfo);
    }

    @Override
    public HerbInfo findById(int id) {
        HerbInfo herbInfo = mapper.selectByPrimaryKey(id);
        if (herbInfo == null) {//如果没找到，返回错误信息在前端显示
            throw new RuntimeException("没有找到药材信息，请重新输入药材id");
        }
        return herbInfo;
    }
    // 进货
    @Override
    public void purchase(Integer id, Integer quantity) {
        mapper.updateStock(id, quantity);
    }

    // 购买
    @Override
    public void buy(Integer id, Integer quantity) {
        mapper.updateStock(id, -quantity); // 注意这里传递负值来减少库存
    }
    // 检查药材名称是否存在
    public boolean checkHerbNameExists(String herbName) {
        return mapper.existsByHerbName(herbName) > 0;
    }
}
