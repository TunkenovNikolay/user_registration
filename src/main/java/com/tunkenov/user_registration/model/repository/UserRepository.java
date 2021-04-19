package com.tunkenov.user_registration.model.repository;

import com.tunkenov.user_registration.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
