package com.lessons.Service;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SetupApiService {

    private String testUrl = "https://reqres.in/api";

    protected RequestSpecification baseSetupHeaders(){
        return RestAssured.given()
                .baseUri(testUrl)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());

    }

}
