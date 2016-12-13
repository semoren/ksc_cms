package com.sermo.ksc.doman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
public class Menu implements Cloneable{

    private String id;

    private String name;

    private String style;

    private List<SubMenu> subMenus;

    private boolean selected = false;

    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus == null ? new ArrayList<SubMenu>() : subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Menu copy() {
        Menu menu = new Menu();
        menu.name = this.name;
        menu.style = this.style;
        menu.selected = this.selected;
        return menu;
    }
}
