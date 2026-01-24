package events.core.entities;

import events.core.enums.EventType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Event {

    private UUID id;
    private UUID sponsorId;
    private String identifier;
    private EventType type;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Short capacity;
    private LocalDateTime createdAt;
    private Optional<LocalDateTime> updatedAt;

    public Event(
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
            Optional<LocalDateTime> updatedAt
    ) {
        this.id = id;
        this.sponsorId = sponsorId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        System.out.println(identifier + ' ' + ' ' + generateIdentifier());

        this.identifier = Objects.requireNonNullElseGet(identifier, this::generateIdentifier);
    }

    public UUID getId() {
        return id;
    }

    public UUID getSponsorId() {
        return sponsorId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public EventType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public Short getCapacity() {
        return capacity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Optional<LocalDateTime> getUpdatedAt() {
        return updatedAt;
    }

    private static Integer decodeIdentifier(String timestampPart){
        String encoding = "0123456789ABCDEFGHJKMNPQRSTVWXYZ";
        int time = 0;

        for (int i = 0; i < timestampPart.length(); i++) {
            char c = timestampPart.charAt(i);
            int value = encoding.indexOf(c);
            time = time * 32 + value;
        }

        return time;

    }

    private static Boolean validateIdentifier(String identifier){
        String ulidRegex = "^[0-7][0-9A-HJKMNP-TV-Z]{25}$";

        if(identifier.matches(ulidRegex)){
            return false;
        }

        String timestampPart = identifier.substring(0, 10).toUpperCase();
        int timestamp = decodeIdentifier(timestampPart);

        return timestamp <= Instant.now().toEpochMilli();
    }

    private String generateIdentifier(){
        String encoding = "0123456789ABCDEFGHJKMNPQRSTVWXYZ";

        long time =  Instant.now().toEpochMilli();;
        StringBuilder timeStr = new StringBuilder();
        long tempTime = time;

        for(int i = 9; i >= 0; i--){
            long mod = tempTime % 32;
            timeStr.append(encoding.charAt((int) mod));
           tempTime =  tempTime / 32;
        }

        return timeStr.toString();


    }
}

