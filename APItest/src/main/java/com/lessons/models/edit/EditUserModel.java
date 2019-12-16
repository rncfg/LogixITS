package com.lessons.models.edit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class EditUserModel{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;


		}