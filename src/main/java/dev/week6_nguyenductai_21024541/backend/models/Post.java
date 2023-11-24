package dev.week6_nguyenductai_21024541.backend.models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "Post")


public class Post {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User authorId;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private Post parentId;

    @Column(length = 75, nullable = false)
    @NonNull
    private String title;

    @Column(length = 100, nullable = false)
    @NonNull
    private String metaTitle;

    @Column(columnDefinition = "TINYTEXT", nullable = false)
    @NonNull
    private String summary;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean publised;

    @Column(nullable = false)
    @NonNull
    private LocalDate createdAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate updateAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate publishedAt;

    @Column(nullable = false)
    @NonNull
    private String content;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", publised=" + publised +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
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

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public Post getParentId() {
        return parentId;
    }

    public void setParentId(Post parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPublised() {
        return publised;
    }

    public void setPublised(boolean publised) {
        this.publised = publised;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
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

    public Post(long id, User authorId, @NonNull Post parentId, @NonNull String title, @NonNull String metaTitle, @NonNull String summary, boolean publised, @NonNull LocalDate createdAt, @NonNull LocalDate updateAt, @NonNull LocalDate publishedAt, @NonNull String content) {
        this.id = id;
        this.authorId = authorId;
        this.parentId = parentId;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.publised = publised;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public Post() {
    }
}