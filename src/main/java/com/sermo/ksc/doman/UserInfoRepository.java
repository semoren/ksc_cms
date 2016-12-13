package com.sermo.ksc.doman;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Mapper
public interface UserInfoRepository {

    @Insert("insert into k_user_info(id, email, name, password, create_time, state) values(#{id}, #{email}, #{name}, #{password}, #{createtime}, #{state}) ")
    boolean insert(UserInfo userInfo);

    @Select("select id, email, name, create_time, state from k_user_info order by create_time desc")
    List<UserInfo> findAll();

    @Select("select email, name, password from k_user_info where email=#{email}")
    UserInfo findByEmail(String email);

    @Update("update set state=#{state} where id=#{id}")
    void updateState(String id, Integer state);
}
