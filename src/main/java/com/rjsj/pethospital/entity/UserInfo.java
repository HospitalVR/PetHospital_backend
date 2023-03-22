package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String account;
    private String userName;
    private String password;

    private Date lastLoginTime;

    private boolean enabled;
    private boolean notExpired;
    private boolean accountNotLocked;
    private boolean credentialsNotExpired;

    private Date createTime;
    private Date updateTime;

    private int createUser;
    private int updateUser;
}
