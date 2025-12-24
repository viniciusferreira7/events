package com.example.events.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventsRepository extends JpaRepository<EventEntity, UUID> {
    List<EventEntity> findBySponsorId(UUID sponsorId);
}
