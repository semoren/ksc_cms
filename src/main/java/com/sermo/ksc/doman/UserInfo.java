package com.sermo.ksc.doman;

import com.sermo.components.biz.util.Generator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息表
 * @author sermo
 * 
 */
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 689381614379376460L;

	private String id = (String)Generator.generate();

	/**
	 * 登陆邮箱
	 */
    private String email;
    
    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Timestamp createtime = new Timestamp(System.currentTimeMillis());

    /**
     * 状态 0-禁用 1-启用
     */
    private Integer state = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Map<String, String> copy(){
        Map<String, String> map = new HashMap<>();
        map.put("email", this.email);
        map.put("name", this.name);
        return map;
    }
}