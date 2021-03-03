package com.twitter.user;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {

	ACTIVE("A"), BLOCKED("B"), IDEAL("I");

	private String code;

	private UserStatus(String code) {

		this.code = code;
	}
	@JsonValue
	public String getCode() {
		return code;
	}
	@JsonCreator
	public static UserStatus decode(String code) {
		return Stream.of(UserStatus.values()).filter(p -> p.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
