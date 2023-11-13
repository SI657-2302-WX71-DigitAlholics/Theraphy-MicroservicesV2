package com.digitalholics.securityservice.api.rest;

import com.digitalholics.securityservice.domain.service.UserService;
import com.digitalholics.securityservice.mapping.UserMapper;
import com.digitalholics.securityservice.resource.CreateUserResource;
import com.digitalholics.securityservice.resource.UpdateUserResource;
import com.digitalholics.securityservice.resource.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
@Tag(name = "Users", description = "Create, read, update and delete users")
public class UsersController {

    private final UserService userService;

    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable) {
        return mapper.modelListPage(userService.getAll(), pageable);
    }

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Integer userId) {
        return mapper.toResource(userService.getById(userId));
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Integer userId,
                                         @RequestBody UpdateUserResource resource) {
        return mapper.toResource(userService.update(userId, mapper.toModel(resource)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        return userService.delete(userId);
    }
}
