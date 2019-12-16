package com.lessons.Service.user;

import com.lessons.AssertableResponse;
import com.lessons.models.create.CreateUserModel;
import com.lessons.Service.SetupApiService;
import io.restassured.response.Response;
//@Slf4j


public class GetUserService extends SetupApiService {

    public AssertableResponse getSingleUser(int id){
        Response response=
                baseSetupHeaders()
                        .when()
                        .get( "api/users/"+id)
                        .then().extract().response();
        return new AssertableResponse(response);


    }
}
