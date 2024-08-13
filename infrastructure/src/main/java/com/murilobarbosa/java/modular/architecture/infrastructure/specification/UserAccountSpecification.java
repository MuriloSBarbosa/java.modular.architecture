package com.murilobarbosa.java.modular.architecture.infrastructure.specification;

import static com.murilobarbosa.java.modular.architecture.infrastructure.specification.SpecificationUtils.like;

import com.murilobarbosa.java.modular.architecture.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.modular.architecture.infrastructure.entity.UserAccountEntity;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class UserAccountSpecification {

    public static Specification<UserAccountEntity> filter(SearchUserAccountDto search) {
        return (userAccount, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (search.getName() != null) {
                predicates.add(like(builder, userAccount.get("name"), search.getName()));
            }

            if (search.getEmail() != null) {
                predicates.add(like(builder, userAccount.get("email"), search.getEmail()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
