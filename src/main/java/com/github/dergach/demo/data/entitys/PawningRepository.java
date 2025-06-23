package com.github.dergach.demo.data.entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PawningRepository extends CrudRepository<Pawning, Long> {
    Iterable<Pawning> findAllByOrderByPawningIdAsc();
    Iterable<Pawning> findAllByOrderByPawningIdDesc();

    @Query("SELECT p FROM Pawning p JOIN p.client c JOIN p.category cat WHERE " +
            "LOWER(p.productDescription) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "CAST(p.amount AS string) LIKE CONCAT('%', :searchTerm, '%') OR " +
            "CAST(p.commission AS string) LIKE CONCAT('%', :searchTerm, '%') OR " +
            "LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(cat.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Iterable<Pawning> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}
