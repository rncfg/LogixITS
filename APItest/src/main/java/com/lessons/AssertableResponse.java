package com.lessons;

import com.lessons.conditions.Condition;
import lombok.AllArgsConstructor;
import io.restassured.response.Response;

@AllArgsConstructor
public class AssertableResponse {

    private Response response;
    public AssertableResponse shouldHave(Condition condition){
        condition.check(response);
        return this;

    }
    public String getBodyByPath(String path) {
        return response.then().extract().path(path).toString();
    }

    public <T> T responseAs(Class<T> tClass){
        return response.as(tClass);

    }
}
