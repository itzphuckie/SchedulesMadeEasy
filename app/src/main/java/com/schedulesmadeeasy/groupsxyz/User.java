package com.schedulesmadeeasy.groupsxyz;

/**
 * Created by agaa2 on 4/8/2018.
 */

public class User {
    private String mUserName;
    private String mEmail;
    private String mFirstName;
    private String mLastName;
    private String userId;

    public User(){

    }

    public User(String mUserName, String mEmail, String mFirstName, String mLastName, String userId) {
        this.mUserName = mUserName;
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.userId = userId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getUserId() {
        return userId;
    }
}
