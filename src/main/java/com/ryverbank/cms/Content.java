package com.ryverbank.cms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Content {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="content_id")
    private int id;

    private String title;
    private String summary;
    private String content;
    private String link;
    private boolean approved;

    // GETTERS
    public int getCID() { return this.id; }
    public String getTitle() { return this.title; }
    public String getSummary() { return this.summary; }
    public String getContent() { return this.content; }
    public String getLink() { return this.link; }
    public boolean getStatus() { return this.approved; }

    // SETTERS
    public void setTitle(String title) { this.title = title; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setContent(String content) { this.content = content; }
    public void setLink(String link) { this.link = link; }
    public void setApproval(boolean approval) { this.approved = approval; }

    public String toString() {
        if (!this.approved) {
            return "Content has not been approved.";
        }
        return title + "\n" + summary + "\n" + content;
    }
}