package dev.week6_nguyenductai_21024541.backend.repositories;

import dev.week6_nguyenductai_21024541.backend.models.Post_comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_commentRepository extends JpaRepository<Post_comment,Long> {
}
