package com.github.dergach.demo.data.auth;

import com.github.dergach.demo.data.user.PlatformUser;
import com.github.dergach.demo.data.user.PlatformUserRequest;
import com.github.dergach.demo.data.user.PlatformUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiqnUpRestController {
    private final PlatformUserService platformUserService;
    public SiqnUpRestController(PlatformUserService platformUserService) {
        this.platformUserService = platformUserService;
    }
    @PostMapping("/siqnup")
    public PlatformUser siqnupPlatformUser(@RequestBody PlatformUserRequest platformUserRequest) {
        return platformUserService.signUp(platformUserRequest);
    }
}
