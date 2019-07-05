package com.pc.blog.model;

public class User {
    private String host;

    private String user;

    public User(String host, String user) {
        this.host = host;
        this.user = user;
    }

    public User() {
        super();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}