package com.example.events.infra.persistence;

import com.example.events.core.enums.EventType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "sponsor_id")
    private UUID sponsorId;
    private String identifier;

    @Enumerated(EnumType.STRING)
    private EventType type;
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    private String location;

    @Column(nullable = true)
    private Short capacity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    public EventEntity(
           UUID id,
           UUID sponsorId,
           String identifier,
           EventType type,
           String name,
           String description,
           LocalDateTime startTime,
           LocalDateTime endTime,
           String location,
           Short capacity,
           LocalDateTime createdAt,
           LocalDateTime updatedAt
    ) {
        this.id = id;
        this.sponsorId = sponsorId;
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
