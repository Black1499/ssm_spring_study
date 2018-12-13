package com.lzx.entity;

import java.util.List;

public class Author {
    private String name;
    private String sex;
    private String height;

    private Book book;

    public Author(String name, String sex, String height, Book book, List<Book> list) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.book = book;
        this.list = list;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    private List<Book> list;

    public Author() {
    }

    public Author(String name, String sex, String height) {
        this.name = name;
        this.sex = sex;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
