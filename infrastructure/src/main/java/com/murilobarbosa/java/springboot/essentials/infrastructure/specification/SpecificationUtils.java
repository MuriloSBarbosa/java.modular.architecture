package com.murilobarbosa.java.springboot.essentials.infrastructure.specification;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

public class SpecificationUtils {

    //    builder.like(userAccount.get("name"), "%" + search.getName() + "%")
    public static Predicate like(CriteriaBuilder cb, Path path, String search) {
        return cb.like(cb.lower(path), likeFilter(search));
    }

    public static String likeFilter(String value) {
        return "%" + value.toLowerCase() + "%";
    }

}
