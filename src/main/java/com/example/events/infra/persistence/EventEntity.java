package com.example.events.infra.persistence;

import com.example.events.core.enums.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", nullable = false)
    private UUID id;

    @Column(name = "sponsor_id", nullable = false)
    private UUID sponsorId;

    @Column(length = 64, unique = true, nullable = false)
    private String identifier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType type;

    @Column(length = 300, nullable = false)
    private String name;

    @Column(length = 600)
    private String description;

    @Column(nullable = false)
    private String location;

    private Short capacity;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    public EventEntity(UUID sponsorId, String identifier, EventType type, String name, String description, String location, Short capacity, LocalDateTime startTime, LocalDateTime endTime) {
        this.sponsorId = sponsorId;
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.description = description;
        this.location = location;
        this.capacity = capacity;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
