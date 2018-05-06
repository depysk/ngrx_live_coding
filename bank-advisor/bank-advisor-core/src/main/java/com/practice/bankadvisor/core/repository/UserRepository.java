package com.practice.bankadvisor.core.repository;

import com.practice.bankadvisor.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
