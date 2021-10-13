package com.example.newsb.repository;

import com.example.newsb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u FROM Customer u where u.login = :login")
    Customer findByLogin(@Param("login") String login);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM Customer u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);
}

