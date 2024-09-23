package com.example.kinino_nawa.repository;

import com.example.kinino_nawa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity , UUID> {}
