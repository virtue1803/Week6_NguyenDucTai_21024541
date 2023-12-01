package dev.week6_nguyenductai_21024541.backend.services;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import dev.week6_nguyenductai_21024541.backend.models.Post_comment;
import dev.week6_nguyenductai_21024541.backend.repositories.Post_commentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Post_commentService implements IServices<Post_comment> {
    @Autowired
    private final Post_commentRepository commentRepository;

    @Autowired
    public Post_commentService(Post_commentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Post_comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void delete(Post_comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Post_comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Post_comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Post_comment> findListCommentByPostId(Post postId) {
        return commentRepository.findAllByPostIdAndParentIdNullOrderByPublishedAtDesc(postId);
    }

    public List<Post_comment> findSubComments(Post_comment comment) {
        return commentRepository.findAllByParentId(comment);
    }
}