package com.sermo.ksc.service;

import com.sermo.ksc.doman.SubMenu;

import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
public interface SubMenuService {

    List<SubMenu> findAll();

    List<SubMenu> findByMenuId(String menuId);
}
