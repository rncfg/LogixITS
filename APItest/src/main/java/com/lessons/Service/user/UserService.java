package com.lessons.Service.user;

import com.lessons.AssertableResponse;
import com.lessons.models.create.CreateUserModel;
import com.lessons.Service.SetupApiService;
import io.restassured.response.Response;
//@Slf4j

public class UserService extends SetupApiService {

    public AssertableResponse postUser(CreateUserModel user) {
        Response response =
                baseSetupHeaders()
                        .body(user)
                        .when()
                        .post("users")
                        .then().extract().response();
        return new AssertableResponse(response);
    }

}
