package com.github.dergach.demo.data.user;

public record PlatformUserRequest(String username, String password, Role role) {
}