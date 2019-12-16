package com.lesstom.singleUser;

import com.github.javafaker.Faker;
import com.lessons.models.create.CreateUserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class GetAllUsersTest {
    private String testUrl = "https://reqres.in/";
    private Faker faker = new Faker();

    @BeforeClass
    public void preClass(){
        RestAssured. baseURI= testUrl;

    }
    @Test
    public void testGetAllUsersTest() {
        CreateUserModel createUserModel = new CreateUserModel()
                .setName(faker.name().firstName())
                .setJob(faker.job().position());

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(createUserModel)
                .when()
                .get( "api/users/")
                .then().log().all()
                .assertThat()
                .statusCode(200);



    }
}

