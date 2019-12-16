package com.lessons.Service.user;

import com.lessons.AssertableResponse;
import com.lessons.Service.SetupApiService;
import com.lessons.models.create.CreateUserModel;
import com.lessons.models.edit.EditUserModel;
import io.restassured.response.Response;

public class PutUserService extends SetupApiService {
    public AssertableResponse putUser(int userId, CreateUserModel user) {
        Response response =
                baseSetupHeaders()
                        .body(user)
                        .when()
                        .put("/users/"+userId)
                        .then().extract().response();
        return new AssertableResponse(response);
    }
}
