package com.example.events.infra.persistence;

import com.example.events.core.enums.EventType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EventEntitySpecification {
    public static Specification<EventEntity> filter(
           String search
    ) {
        return (root, query, cb) -> {
            if(search == null || search.isBlank()){
                return cb.conjunction();
            }

            String like = "%" + search.toLowerCase() + "%";

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.like(cb.lower(root.get("name")), like));
            predicates.add(cb.like(cb.lower(root.get("description")), like));
            predicates.add(cb.like(cb.lower(root.get("location")), like));
            predicates.add(cb.like(cb.lower(root.get("type")), like));
            predicates.add(cb.like(cb.lower(root.get("identifier")), like));

            if(search.matches("\\d+")){
                predicates.add(
                        cb.equal(
                                root.get("capacity"),
                                Integer.valueOf(search))
                );
            };

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
