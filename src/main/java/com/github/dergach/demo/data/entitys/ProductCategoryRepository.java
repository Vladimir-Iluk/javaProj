package com.github.dergach.demo.data.entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
    Iterable<ProductCategory> findAllByOrderByCategoryIdAsc();
    Iterable<ProductCategory> findAllByOrderByCategoryIdDesc();

    @Query("SELECT c FROM ProductCategory c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.notes) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Iterable<ProductCategory> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}
