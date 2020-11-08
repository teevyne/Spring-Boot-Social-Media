package com.socialnetwork.repository;

import com.socialnetwork.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    Post findByTitle(String title);
}
