package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
private String content;
@CreationTimestamp
private Date pubDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog(int userId, String content, String title, User user) {
        this.userId = userId;
        this.content = content;
        this.title = title;
        this.user = user;
    }

    public Blog() {
    }

    public Blog(int userId, String content, String title) {
        this.userId = userId;
        this.content = content;
        this.title = title;
    }

    private String title;
@ManyToOne
@JoinColumn
private User user;

    public Date getPubDate() {
        return pubDate;
    }

    public List<Image> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<Image> listOfImages) {
        this.listOfImages = listOfImages;
    }

    @OneToMany(mappedBy = "blog" , cascade = CascadeType.ALL)
    private List<Image> listOfImages = new ArrayList<>();



    public void setPubDate(Date date) {
        this.pubDate = date;
    }
}