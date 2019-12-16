package com.lesstom.singleUser;

import com.github.javafaker.Faker;
import com.lessons.Service.user.GetUserService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.lessons.conditions.Conditions.statusCode;

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

        getUserService.getSingleUser(2) //присваем значение переменной id объявленной в классе GetUserService
                .shouldHave(statusCode(200));

    }

    @Test
    public void testGetSingleUserNeg() {
        getUserService.getSingleUser( 555555)
                .shouldHave(statusCode(404));
    }
}

