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

@Getter
@Setter
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final String id;

    @Column(name = "organizer_id")
    private String organizerId;
    private String identifier;
    private EventType type;
    private String name;
    private String description;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    private String local;
    private Short capacity;

    @Column(name = "created_at")
    private final LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    public EventEntity(
            String id,
           String organizerId,
           String identifier,
           EventType type,
           String name,
           String description,
           LocalDateTime startTime,
           LocalDateTime endTime,
           String local,
           Short capacity,
           LocalDateTime createdAt,
           LocalDateTime updatedAt
    ) {
        this.id = id;
        this.organizerId = organizerId;
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.local = local;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
