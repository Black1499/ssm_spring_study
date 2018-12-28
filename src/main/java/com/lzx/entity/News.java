package com.lzx.entity;

import java.io.Serializable;

public class News implements Serializable {

    private int id;
    private String title;
    private String body;

    // 使用该关键字序列化时忽略该对象
    private transient String date;

    public News(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public News(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
