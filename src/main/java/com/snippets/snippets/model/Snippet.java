package com.snippets.snippets.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "snippets")
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String language;
    private String content;

    @Column(name = "userid")
    private long userid;

    public Snippet(){}

    public Snippet(String title, String language, String content, long userid){
        this.title = title;
        this.language = language;
        this.content = content;
        this.userid = userid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "User [id= " + id + ", title= " + title + ", language= " + language
                + "content= " + content + "userid= " + userid;
    }
}