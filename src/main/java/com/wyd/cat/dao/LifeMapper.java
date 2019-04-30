package com.wyd.cat.dao;

import com.wyd.cat.model.Life;
import com.wyd.cat.model.LifeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface LifeMapper {
    long countByExample(LifeExample example);

    int deleteByExample(LifeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Life record);

    int insertSelective(Life record);

    List<Life> selectByExample(LifeExample example);

    Life selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByExample(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByPrimaryKeySelective(Life record);

    int updateByPrimaryKey(Life record);
}