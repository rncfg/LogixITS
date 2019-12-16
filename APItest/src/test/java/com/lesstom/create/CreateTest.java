package com.lesstom.create;

import com.github.javafaker.Faker;
import com.lessons.Service.user.GetUserService;
import com.lessons.models.create.CreateUserModel;
import com.lessons.Service.user.PostUserService;
import com.lessons.models.response.CreateUserResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.lessons.conditions.Conditions.bodyField;
import static com.lessons.conditions.Conditions.statusCode;
import static org.hamcrest.CoreMatchers.containsString;


public class CreateTest {

    private String testUrl = "https://reqres.in/";
    private Faker faker = new Faker();
    PostUserService postUserService = new PostUserService();

    @BeforeClass
    public void preClass(){
        RestAssured. baseURI= testUrl;

    }




    @Test
    public void testCreateUser() {
        CreateUserModel createUserModel = new CreateUserModel()
                .setName(faker.name().firstName())
                .setJob(faker.job().position());

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(createUserModel)
                .when()
                .post( "api/users")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("name",  containsString(createUserModel.getName()))
                .body("job", containsString(createUserModel.getJob()));

    }
    @Test
    public void testCreateUserV2() {
        CreateUserModel createUserModel = new CreateUserModel()
                .setName(faker.name().firstName())
                .setJob(faker.job().position());
CreateUserResponseModel createUserResponseModel=
       postUserService.postUser(createUserModel)
            .shouldHave(statusCode(201))
            .shouldHave(bodyField("job", containsString(createUserModel.getJob())))
            .responseAs(CreateUserResponseModel.class);


        System.out.println(createUserResponseModel.getId());
    }

}
