package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @Test
    public void addNewDevice() {
        String requestBody = "{\n" +
                "  \"name\": \"Apple Max Pro 1TB\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2023,\n" +
                "    \"price\": 7999.99,\n" +
                "    \"CPU model\": \"Apple ARM A7\",\n" +
                "    \"Hard disk size\": \"1 TB\"\n" +
                "  }\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/objects")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo("Apple Max Pro 1TB"))
                .body("createdAt", notNullValue())
                .body("data.year", equalTo(2023))
                .body("data.price", equalTo(7999.99f))
                .body("data.CPU model", equalTo("Apple ARM A7"))
                .body("data.Hard disk size", equalTo("1 TB"))
                .extract()
                .response();

        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        assert id != null;
        assert createdAt != null;
    }
}
