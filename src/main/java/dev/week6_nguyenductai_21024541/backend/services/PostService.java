package dev.week6_nguyenductai_21024541.backend.services;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import dev.week6_nguyenductai_21024541.backend.models.User;
import dev.week6_nguyenductai_21024541.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IServices<Post> {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllByPublishedIsTrue(boolean desc) {
        return desc ? postRepository.findAllByPublishedAtIsTrueOrderByUpdatedAtDesc() :
                postRepository.findAllByPublishedAtIsTrueOrderByUpdatedAtAsc();
    }

    public List<Post> findPostsByAuthorIdAndNotParentPost(User authorId) {
        return postRepository.findAllByAuthorIdAndParentIdIsNull(authorId);
    }
}
