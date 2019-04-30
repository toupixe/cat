package com.wyd.cat.dao;

import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.model.Contact;
import com.wyd.cat.model.ContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactMapper {
    long countByExample(ContactExample example);

    int deleteByExample(ContactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    List<Contact> selectByExample(ContactExample example);

    Contact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
    /**
     * <p>Title: 插入一条联系记录</p>  
     * <p>Description: </p>  
     * @param contactDto
     * @return 被影响的条数
     */
    int insertContact(@Param("con") ContactDto contactDto);
}