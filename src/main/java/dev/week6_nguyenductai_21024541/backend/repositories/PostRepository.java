package dev.week6_nguyenductai_21024541.backend.repositories;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
