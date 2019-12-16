package com.lessons.models.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;



@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class CreateUserModel {

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

}