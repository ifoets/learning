package com.udmy.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udmy.userservice.dto.UserDto;
import com.udmy.userservice.repository.UserRepository;
import com.udmy.userservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Flux<UserDto> getAll() {
		return this.repository.findAll()
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> getUserById(Integer id) {
		return this.repository.findById(id)
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> createUser(Mono<UserDto> useDto) {
		return useDto.map(EntityDtoUtil::toEntity)
		        .flatMap(this.repository::save)
		        .map(EntityDtoUtil::toDto);

	}

	@Override
	public Mono<UserDto> updateUser(Integer id, Mono<UserDto> userdtoMono) {

		return this.repository.findById(id)
		        .flatMap(u -> userdtoMono.map(EntityDtoUtil::toEntity)
		                .doOnNext(e -> e.setId(id)))
		        .flatMap(this.repository::save)
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return this.repository.deleteById(id);
	}
}
