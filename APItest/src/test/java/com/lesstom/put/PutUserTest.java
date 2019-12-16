package com.lesson.api.editUser;
import com.github.javafaker.Faker;
import com.lessons.Service.user.GetUserService;
import com.lessons.Service.user.PostUserService;
import com.lessons.Service.user.PutUserService;
import com.lessons.models.create.CreateUserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.lessons.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.containsString;


public class PutUserTest {
    private String testUrl = "https://reqres.in/";
    private  PutUserService putUserService = new PutUserService();
    private GetUserService getUserService = new GetUserService();
    Faker faker = new Faker();

    @BeforeClass
    public void preClass() {
        RestAssured.baseURI = testUrl;
    }
    @Test
    public void testEditUser() {
        CreateUserModel user = new CreateUserModel()
                .setName(faker.name().firstName())
                .setJob(faker.job().position());
        String userId = RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("/api/users/2")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract().body().path("id");
        user
                .setName(faker.name().firstName())
                .setJob(faker.job().position());
        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .put("/api/user/2" )
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("name", containsString(user.getName()))
                .body("job", containsString(user.getJob()));
    }

  @Test
    public void testPutUser(){
      CreateUserModel createUserName = new CreateUserModel()
              .setName(faker.name().firstName())
              .setJob(faker.job().position());
      putUserService.putUser( 2, createUserName)
              .shouldHave(statusCode(200));
      getUserService.getSingleUser(2) //второй метод в тесте testPutUser
              .shouldHave(statusCode(200));
  }





}