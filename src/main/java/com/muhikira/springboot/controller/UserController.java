package com.muhikira.springboot.controller;

import com.muhikira.springboot.exception.ErrorDetails;
import com.muhikira.springboot.exception.ResourceNotFoundException;
import com.muhikira.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.muhikira.springboot.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag (name = "CRUD REST APIs for User Resource",
      description= "Create User, UpdateUser, Get User, GEt All Users, Delete a;ll Users")
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    @Operation(
            summary="Create User REST API",
            description ="Create User RestAPI is used to save user in a database "
    )
    @ApiResponse(
            responseCode ="201",
            description ="Http status 201 created"
    )

    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1

    @Operation(
            summary="Get User  by ID REST API",
            description ="Get User By ID REST API  User RestAPI is used to get a single  user in a database "
    )
    @ApiResponse(
            responseCode ="200",
            description ="Http status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @Operation(
            summary="Get All Users  by ID REST API",
            description ="Get All Users is used to get all users from the  database "
    )
    @ApiResponse(
            responseCode ="200",
            description ="Http status 200 Success"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API

    @Operation(
            summary="Update user REST API",
            description ="Update User REST API is used to update a particular user in  the  database "
    )
    @ApiResponse(
            responseCode ="200",
            description ="Http status 200 Success"
    )
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API

    @Operation(
            summary="Delete User REST API",
            description ="Delete User REST API is used to delete a particular user  from the  database "
    )
    @ApiResponse(
            responseCode ="200",
            description ="Http status 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails (
//                LocalDateTime.now (),
//                exception.getMessage (),
//                webRequest.getDescription (false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<> (errorDetails, HttpStatus.NOT_FOUND);
//
//    }
}