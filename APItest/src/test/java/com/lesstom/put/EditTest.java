package com.lesson.api.editUser;
import com.github.javafaker.Faker;
import com.lessons.models.create.CreateUserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;


public class EditTest {
    private String testUrl = "https://reqres.in/";
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
                .post("/api/users")
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
                .put("/api/user/" + userId)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("name", containsString(user.getName()))
                .body("job", containsString(user.getJob()));
    }
}