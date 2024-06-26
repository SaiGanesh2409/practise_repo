package com.springrest.ganesh.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.springrest.ganesh.dto.UserDto;
import com.springrest.ganesh.entity.User;
import com.springrest.ganesh.exception.ErrorDetails;
import com.springrest.ganesh.exception.ResourceNotFoundException;
import com.springrest.ganesh.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserId(@PathVariable("id") long userId) {
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("allusers")
	public ResponseEntity<List<UserDto>> getAllusers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id, @Valid @RequestBody UserDto user) {
		user.setId(id);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteId(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}

	/*
	 * @ExceptionHandler(ResourceNotFoundException.class) public
	 * ResponseEntity<ErrorDetails>
	 * handleResponseNotFoundExcention(ResourceNotFoundException exception,
	 * WebRequest request) {
	 * 
	 * ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
	 * exception.getMessage(), request.getDescription(false), ("USER_NOT_FOUND"));
	 * return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	 * }
	 */

}
