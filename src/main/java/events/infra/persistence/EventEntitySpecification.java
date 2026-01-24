package events.infra.persistence;

import events.core.enums.EventType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
            predicates.add(cb.like(cb.lower(root.get("identifier")), like));

            List<String> stringList = Arrays.stream(EventType.values()).map(Enum::toString).toList();

            Optional<String> eventTypeAsLike = stringList.stream().filter(like::equalsIgnoreCase).findFirst();

            if(eventTypeAsLike.isPresent()){
                EventType eventType = EventType.valueOf(like.toUpperCase());
                predicates.add(cb.equal(root.get("type"),eventType));
            }

            if(search.matches("\\d+")){
                predicates.add(
                        cb.equal(
                                root.get("capacity"),
                                Integer.valueOf(search))
                );
            };

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }
}
