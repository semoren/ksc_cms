package com.sermo.ksc.service.impl;

import com.sermo.ksc.doman.Menu;
import com.sermo.ksc.doman.MenuRepository;
import com.sermo.ksc.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuRepository repository;

    @Override
    public List<Menu> findAll() {
        return repository.findAll();
    }
}
