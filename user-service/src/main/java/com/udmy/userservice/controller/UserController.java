package com.udmy.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udmy.userservice.dto.UserDto;
import com.udmy.userservice.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("all")
	public Flux<UserDto> getAll() {
		return userService.getAll();
	}

	@GetMapping("{id}")
	public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable Integer id) {
		return this.userService.getUserById(id)
		        .map(ResponseEntity::ok)
		        .defaultIfEmpty(ResponseEntity.notFound()
		                .build());
	}

	@PostMapping("create")
	public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userdtoMono) {
		return this.userService.createUser(userdtoMono);
	}

	@PutMapping("update/{id}")
	public Mono<ResponseEntity<UserDto>> updateUser(@PathVariable Integer id, @RequestBody Mono<UserDto> userdtoMono) {
		return this.userService.updateUser(id, userdtoMono)
		        .map(ResponseEntity::ok)
		        .defaultIfEmpty(ResponseEntity.notFound()
		                .build());
	}

	@DeleteMapping("delete/{id}")
	public Mono<Void> delete(@PathVariable Integer id) {
		return this.userService.delete(id);
	}
}
