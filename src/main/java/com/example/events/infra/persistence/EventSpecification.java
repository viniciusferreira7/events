package com.example.events.infra.persistence;

import com.example.events.core.enums.EventType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EventSpecification {
    public static Specification<EventEntity> filter(
            String name,
            String description,
            String type,
            String location,
            String capacity,
            String identifier
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (description != null) {
                predicates.add(cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%"));
            }
            if (location != null) {
                predicates.add(cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%"));
            }
            if (capacity != null) {
                predicates.add(cb.equal(root.get("capacity"), capacity));
            }
            if (type != null) {
                EventType eventType = EventType.valueOf(type);
                predicates.add(cb.equal(root.get("type"), eventType));
            }
            if (identifier != null) {
                predicates.add(cb.equal(root.get("identifier"), identifier));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
