package dev.week6_nguyenductai_21024541.backend.repositories;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import dev.week6_nguyenductai_21024541.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByPublishedAtIsTrueOrderByUpdatedAtDesc();
    List<Post> findAllByPublishedAtIsTrueOrderByUpdatedAtAsc();
    List<Post> findAllByAuthorIdAndParentIdIsNull(User authorId);
}
