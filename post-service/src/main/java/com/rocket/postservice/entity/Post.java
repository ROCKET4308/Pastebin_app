package com.rocket.postservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    Integer postId;
    String postName;
    String postText;
    LocalDateTime creationTime;
    LocalDateTime deletionTime;


    public Post(String postName, String postText, LocalDateTime creationTime) {
        this.postName = postName;
        this.postText = postText;
        this.creationTime = creationTime;
    }

    public Post(String postName, String postText, LocalDateTime creationTime, LocalDateTime deletionTime) {
        this.postName = postName;
        this.postText = postText;
        this.creationTime = creationTime;
        this.deletionTime = deletionTime;
    }
}
