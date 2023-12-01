package dev.week6_nguyenductai_21024541.backend.repositories;

import dev.week6_nguyenductai_21024541.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmailAndPasswordHash(String email, String password);
}
