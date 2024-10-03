package com.example.load;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadRepo extends JpaRepository<Load, UUID> {

    List<Load> findByShipperId(UUID shipperId);
}
