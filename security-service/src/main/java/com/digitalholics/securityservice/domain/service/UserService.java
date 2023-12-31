package com.digitalholics.securityservice.domain.service;

import com.digitalholics.securityservice.domain.model.entity.User;
import com.digitalholics.securityservice.resource.CreateUserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User getById(Integer userId);
    User create(CreateUserResource user);
    User update(Integer userId, User request);
    ResponseEntity<?> delete(Integer userId);
}
