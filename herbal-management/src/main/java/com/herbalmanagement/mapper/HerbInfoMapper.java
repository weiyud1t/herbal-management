package com.herbalmanagement.mapper;

import com.herbalmanagement.pojo.HerbInfo;
import com.herbalmanagement.pojo.HerbInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HerbInfoMapper {
    long countByExample(HerbInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(HerbInfo row);
    List<HerbInfo> selectByExampleWithBLOBs(HerbInfoExample example,@Param("page") int page,@Param("size") int size);
    HerbInfo selectByPrimaryKey(Integer id);
    // 检查药材名称是否存在
    @Select("SELECT COUNT(*) FROM herb_info WHERE herb_name = #{herbName}")
    int existsByHerbName(String herbName);
    int updateByName(HerbInfo row);
    // 更新库存，quantity可以是正数（进货）或负数（购买）
    @Update("UPDATE herb_info SET stock_quantity = stock_quantity + #{quantity} WHERE id = #{id}")
    void updateStock(@Param("id") Integer id, @Param("quantity") Integer quantity);
}