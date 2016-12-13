package com.sermo.ksc.doman;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Mapper
public interface SubMenuRepository {

    @Select("select id, url, name, disabled from m_sub_menu where menu_id=#{menuId}")
    List<SubMenu> findByMenuId(String menuId);

    @Select("select id, menu_id, url, name, disabled, sort from m_sub_menu order by sort")
    List<SubMenu> findAll();

    @Update("update m_sub_menu set url=#{url}, name=#{name}, disabled=#{disabled}, sort=#{sort}, menu_id=#{menuId} where id=#{id}")
    void updateSubMenu(SubMenu subMenu);

    @Delete("delete from m_sub_menu where id=#{id}")
    void deleteById(String id);

    @Delete("delete from m_sub_menu where menu_id=#{menuId}")
    void deleteByMenuId(String menuId);
}
