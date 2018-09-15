package com.school.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.data.entities.Token;

public interface TokenRepository extends JpaRepository<Token, String> {
}
