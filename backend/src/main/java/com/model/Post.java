/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Kone Adama
 */
        
import javax.persistence.*;


/**
 *
 * @author Kone Adama
 */

@Entity
@Table(name = "post")

public class Post {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;


     @Column(name = "title") 
    private String title;
     
    @Column(name = "content") 
    private String content;

    @Column(name = "published") 
    private boolean published;
    
    @Column(name = "tags") 
    private String tags;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    
    
    
}
