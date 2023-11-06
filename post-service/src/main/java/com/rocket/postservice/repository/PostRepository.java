package com.rocket.postservice.repository;


import com.rocket.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByPostName(String postName);
    @Modifying
        @Transactional
        @Query("DELETE FROM Post m WHERE m.deletionTime < :date")
        Integer removeOlderThan(@Param("date") LocalDateTime date);

    Post removeByPostName(String postName);
}
