package com.pastebin.project;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class PasteBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime expirationTime;  // Can be null if no expiration is set

    private Integer accessLimit;  // Max allowed views (nullable)

    private Integer currentViews = 0;  // Initialized to 0

    private String uniqueLink;

    @PrePersist
    public void generateUniqueLinkAndTimestamp() {
        this.createdAt = LocalDateTime.now();
        this.uniqueLink = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getAccessLimit() {
        return accessLimit;
    }

    public void setAccessLimit(Integer accessLimit) {
        this.accessLimit = accessLimit;
    }

    public Integer getCurrentViews() {
        return currentViews;
    }

    public void setCurrentViews(Integer currentViews) {
        this.currentViews = currentViews;
    }

    public String getUniqueLink() {
        return uniqueLink;
    }

    public void setUniqueLink(String uniqueLink) {
        this.uniqueLink = uniqueLink;
    }
}
