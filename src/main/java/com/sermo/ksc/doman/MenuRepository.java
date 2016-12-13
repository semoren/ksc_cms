package com.sermo.ksc.doman;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Mapper
public interface MenuRepository {

    @Select("select id, name, style, sort from m_menu order by sort ")
    List<Menu> findAll();

    @Select("select id, name, style, sort from m_menu where id=#{id} ")
    Menu findById(@Param("id") String id);

    @Update("update m_menu set name=#{name}, style=#{style}, sort=#{sort}")
    void update(Menu menu);

    @Delete("delete from m_menu where id=#{id}")
    void delete(String id);
}
