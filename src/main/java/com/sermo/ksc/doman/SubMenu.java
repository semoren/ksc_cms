package com.sermo.ksc.doman;

/**
 * @author sermo
 * @version 2016/12/13.
 */
public class SubMenu {

    private String id;

    private String menuId;

    private String url;

    private String name;

    private int disabled;

    private boolean selected;

    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisabled() {
        return disabled == 0 ? false : true;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public SubMenu copy() {
        SubMenu menu = new SubMenu();
        menu.name = this.name;
        menu.url = this.url;
        menu.disabled = this.disabled;
        return menu;
    }
}
