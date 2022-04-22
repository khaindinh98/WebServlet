package com.khaindinh98.webservlet.model;

public class RoleModel extends AbstractModel<RoleModel>{

    public final static String ADMIN_ROLE="ADMIN_ROLE";
    public final static String USER_ROLE="USER_ROLE";

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
