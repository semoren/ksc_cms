package com.sermo.ksc.service.impl;

import com.sermo.ksc.doman.SubMenu;
import com.sermo.ksc.doman.SubMenuRepository;
import com.sermo.ksc.service.SubMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Service
public class SubMenuServiceImpl implements SubMenuService{

    @Resource
    private SubMenuRepository repository;

    @Override
    public List<SubMenu> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SubMenu> findByMenuId(String menuId) {
        return repository.findByMenuId(menuId);
    }
}
