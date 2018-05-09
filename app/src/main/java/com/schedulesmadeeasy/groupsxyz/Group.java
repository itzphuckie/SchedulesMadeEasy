package com.schedulesmadeeasy.groupsxyz;

import java.util.List;

/**
 * Created by agaa2 on 3/14/2018.
 */

public class Group {
    String title;
    String members;
    String status;
    String id;

    public Group(){};

    public Group(String title, String members, String status, String id) {
        this.title = title;
        this.members = members;
        this.status = status;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nMembers: %s, Status: %s, ID: %s", title, members, status, id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}


