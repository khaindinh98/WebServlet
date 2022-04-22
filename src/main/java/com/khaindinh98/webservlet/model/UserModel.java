package com.khaindinh98.webservlet.model;

import javax.management.relation.Role;

public class UserModel extends AbstractModel<UserModel>{

    public static final String ACTIVE = "ACTIVE";
    public static final String INACTIVE = "INACTIVE";

    private String username;
    private String password;
    private String fullName;
    private String status;
    private RoleModel role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRoleName(String roleName) {
        if(this.role==null){
            this.role = new RoleModel();
        }
        this.role.setName(roleName);
    }

    public String getRoleName(){
        return role.getName();
    }

    public void setRoleCode(String roleCode) {
        if(this.role==null){
            this.role = new RoleModel();
        }
        this.role.setCode(roleCode);
    }

    public String getRoleCode(){
        return role.getCode();
    }

}