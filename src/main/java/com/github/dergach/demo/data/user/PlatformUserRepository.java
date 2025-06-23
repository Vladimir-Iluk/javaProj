package com.github.dergach.demo.data.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlatformUserRepository extends CrudRepository<PlatformUser, Long> {
    Optional<PlatformUser> findByUsername(String username);
}
