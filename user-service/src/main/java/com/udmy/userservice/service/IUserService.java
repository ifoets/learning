package com.udmy.userservice.service;

import org.springframework.stereotype.Service;

import com.udmy.userservice.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IUserService {

	public Flux<UserDto> getAll();

	public Mono<UserDto> getUserById(Integer id);

	public Mono<UserDto> createUser(Mono<UserDto> userdtoMono);

	public Mono<UserDto> updateUser(Integer id, Mono<UserDto> userdtoMono);

	public Mono<Void> delete(Integer id);
}
