package com.github.dergach.demo.data.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserService {

    private final PlatformUserRepository platformUserRepository;
    private final PasswordEncoder passwordEncoder;
    public PlatformUserService(PlatformUserRepository platformUserRepository, PasswordEncoder passwordEncoder) {
        this.platformUserRepository = platformUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public PlatformUser signUp(PlatformUserRequest platformUserRequest) {
        var platformUser = new PlatformUser();
        platformUser.setUsername(platformUserRequest.username());
        platformUser.setPassword(passwordEncoder.encode(platformUserRequest.password()));
        platformUser.setRole(platformUserRequest.role());
        var result = platformUserRepository.save(platformUser);
        return result;
    }
}