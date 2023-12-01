package dev.week6_nguyenductai_21024541.backend.repositories;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import dev.week6_nguyenductai_21024541.backend.models.Post_comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Post_commentRepository extends JpaRepository<Post_comment,Long> {
    List<Post_comment> findAllByPostIdAndParentIdNullOrderByPublishedAtDesc(Post post);
    List<Post_comment> findAllByParentId(Post_comment comment);
}
