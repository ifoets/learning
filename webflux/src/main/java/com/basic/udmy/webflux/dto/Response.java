package com.basic.udmy.webflux.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Response {

	private Date date = new Date();
	private int output;

	public Response(int output) {
		super();
		this.output = output;
	}

}
