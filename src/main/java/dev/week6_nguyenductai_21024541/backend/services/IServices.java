package dev.week6_nguyenductai_21024541.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IServices<T>{
    void save(T t);
    void delete(Long id);
    void delete(T t);
    List<T> findAll();
    Optional<T> findById(Long id);
}
