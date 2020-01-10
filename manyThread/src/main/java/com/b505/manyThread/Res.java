package com.b505.manyThread;

/**
 * 描述：共享资源实体类
 * author：yulin
 * Create date 2020-1-10 17
 */
public class Res {

    private String userSex;
    private String userName;

    public String getUserSex() {
        return userSex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
