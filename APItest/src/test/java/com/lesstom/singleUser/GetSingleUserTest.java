package com.lesstom.singleUser;

import com.github.javafaker.Faker;
import com.lessons.Service.user.GetUserService;
import com.lessons.Service.user.PostUserService;
import com.lessons.models.create.CreateUserModel;
import com.lessons.models.response.CreateUserResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.lessons.conditions.Conditions.bodyField;
import static com.lessons.conditions.Conditions.statusCode;
import static org.hamcrest.CoreMatchers.containsString;

public class GetSingleUserTest {
    private String testUrl = "https://reqres.in/";
    private Faker faker = new Faker();
    //    PostUserService postUserService = new PostUserService();
    GetUserService getUserService = new GetUserService();

    @BeforeClass
    public void preClass() {
        RestAssured.baseURI = testUrl;

    }

    @Test
    public void testGetSingleUser() {
        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .when()
                .get("api/users/2")
                .then().log().all()
                .assertThat()
                .statusCode(200);


    }


    @Test
    public void testGetSingleUserV3() {

        getUserService.getSingleUser(2)
                .shouldHave(statusCode(200));


    }


}

