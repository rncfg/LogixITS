package com.lessons.Service.user;

import com.lessons.AssertableResponse;
import com.lessons.Service.SetupApiService;
import io.restassured.response.Response;

public class GetUserListService extends SetupApiService {

    public AssertableResponse getUserList(){
        Response response =
                baseSetupHeaders()
                .when()
                .get("/users")
                .then().extract().response();
        return new AssertableResponse(response);
    }
}
