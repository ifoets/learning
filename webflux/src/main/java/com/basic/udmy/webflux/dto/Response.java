package com.basic.udmy.webflux.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Response {

	private Date date = new Date();
	private int output;

	public Response() {
		super();
	}

	public Response(int output) {
		super();
		this.output = output;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "Response [date=" + date + ", output=" + output + "]";
	}

}
