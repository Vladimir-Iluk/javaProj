package com.github.dergach.demo.data.entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Iterable<Client> findAllByOrderByClientIdAsc();
    Iterable<Client> findAllByOrderByClientIdDesc();


    @Query("SELECT c FROM Client c WHERE " +
            "LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.patronymic) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.passportNumber) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.passportSeries) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Iterable<Client> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}