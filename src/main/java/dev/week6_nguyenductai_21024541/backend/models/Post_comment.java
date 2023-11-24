package dev.week6_nguyenductai_21024541.backend.models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "post_comment")

public class Post_comment {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @NonNull
    private Post postID;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private Post_comment parentID;

    @ManyToOne
    @Column(nullable = false)
    @NonNull
    private User userID;

    @Column(nullable = false)
    private long title;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean published;

    @Column(nullable = false)
    @NonNull
    private LocalDate createdAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate publishedAt;

    @Column(nullable = false)
    @NonNull
    private String content;

    @Override
    public String toString() {
        return "Post_comment{" +
                "id=" + id +
                ", postID=" + postID +
                ", parentID=" + parentID +
                ", userID=" + userID +
                ", title=" + title +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPostID() {
        return postID;
    }

    public void setPostID(Post postID) {
        this.postID = postID;
    }

    public Post_comment getParentID() {
        return parentID;
    }

    public void setParentID(Post_comment parentID) {
        this.parentID = parentID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public long getTitle() {
        return title;
    }

    public void setTitle(long title) {
        this.title = title;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post_comment(long id, @NonNull Post postID, @NonNull Post_comment parentID, @NonNull User userID, long title, boolean published, @NonNull LocalDate createdAt, @NonNull LocalDate publishedAt, @NonNull String content) {
        this.id = id;
        this.postID = postID;
        this.parentID = parentID;
        this.userID = userID;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public Post_comment() {
    }
}
