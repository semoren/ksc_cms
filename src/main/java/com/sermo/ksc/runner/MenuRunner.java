package com.sermo.ksc.runner;

import com.sermo.ksc.doman.Menu;
import com.sermo.ksc.doman.SubMenu;
import com.sermo.ksc.service.MenuService;
import com.sermo.ksc.service.SubMenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Component
@Order(value = 1)
public class MenuRunner implements CommandLineRunner {

    @Resource
    private MenuService menuService;
    @Resource
    private SubMenuService subMenuService;

    private Map<String, List<Menu>> mainMenus = new HashMap<>();

    public List<Menu> process(String path) {
        List<Menu> menus = mainMenus.get(path);
        if (menus != null) {
            return convert(path, menus);
        }
        return null;
    }

    private List<Menu> convert(String path, List<Menu> menus) {
        List<Menu> list = new ArrayList<>(menus.size());
        for (Menu menu : menus) {
            Menu menus1 = menu.copy();
            menus1.setSubMenus(new ArrayList<SubMenu>());
            for (SubMenu subMenu : menu.getSubMenus()) {
                if (subMenu.isDisabled()) {
                    if (path.equals(subMenu.getUrl())) {
                        menus1.setSelected(true);
                    }
                } else {
                    SubMenu sub = subMenu.copy();
                    if (path.equals(subMenu.getUrl())) {
                        sub.setSelected(true);
                        menus1.setSelected(true);
                    }
                    menus1.getSubMenus().add(sub);
                }
            }
            list.add(menus1);
        }
        return list;
    }

    private void init() {
        Map<String, List<SubMenu>> listMap = new HashMap<>();
        List<SubMenu> subMenuList = subMenuService.findAll();
        List<SubMenu> subMenus;
        for (SubMenu subMenu : subMenuList) {
            subMenus = listMap.get(subMenu.getMenuId());
            if (subMenus == null || subMenus.size() == 0){
                subMenus = new ArrayList<>();
            }
            subMenus.add(subMenu);
            listMap.put(subMenu.getMenuId(), subMenus);
        }

        List<Menu> list = menuService.findAll();
        for (int i =0; i < list.size(); i++) {
            Menu menu = list.get(i);

            List<SubMenu> listSubs = listMap.get(menu.getId()) == null ? new ArrayList<SubMenu>() : listMap.get(menu.getId());
            for (SubMenu subMenu : listSubs) {
                mainMenus.put(subMenu.getUrl(), list);
            }
            menu.setSubMenus(listSubs);
            list.set(i, menu);
        }
        mainMenus.put("/home", list);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start---------------------------------------------");
        init();
        System.out.println("end----------------------------------------------");
    }
}
