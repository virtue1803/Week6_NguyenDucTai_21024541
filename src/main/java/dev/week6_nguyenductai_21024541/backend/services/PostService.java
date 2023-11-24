package dev.week6_nguyenductai_21024541.backend.services;

import dev.week6_nguyenductai_21024541.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostRepository {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
