package helper;

import com.reqres.pojos.requestPojos.CreateUser;
import com.reqres.pojos.requestPojos.RegisterUser;
import com.reqres.pojos.requestPojos.UpdateUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.reqres.utils.Utility.getEndpoint;
import static com.reqres.utils.Utility.getJsonBody;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;

public class ApiHelper {
    final String baseUrl = "https://reqres.in";

    private void printCurl(String method, String url, Object body) {
        StringBuilder curl = new StringBuilder("curl -X " + method + " \"" + url + "\"");
        if (body != null) {
            curl.append(" -H \"Content-Type: application/json\" -d '").append(body).append("'");
        }
        System.out.println("[cURL] " + curl);
    }

    public Response getAllUsers() {
        String endpoint = String.format(getEndpoint("getAllUsers"), 2);
        String url = baseUrl + endpoint;
        printCurl("GET", url, null);
        return RestAssured.given()
                .baseUri(baseUrl)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response getUserById(int id) {
        String endpoint = String.format(getEndpoint("getUserById"), id);
        String url = baseUrl + endpoint;
        printCurl("GET", url, null);
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response createUser(CreateUser createUser) {
        String endpoint = getEndpoint("createUser");
        String url = baseUrl + endpoint;
        String body = getJsonBody(createUser);
        printCurl("POST", url, body);
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response updateUser(int id, UpdateUser updateUser) {
        String endpoint = String.format(getEndpoint("updateUser"), id);
        String url = baseUrl + endpoint;
        String body = getJsonBody(updateUser);
        printCurl("PUT", url, body);
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response deleteUser(int id) {
        String endpoint = String.format(getEndpoint("deleteUser"), id);
        String url = baseUrl + endpoint;
        printCurl("DELETE", url, null);
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .when()
                .delete(endpoint)
                .then()
                .statusCode(SC_NO_CONTENT)
                .extract()
                .response();
    }

    public Response registerUser(RegisterUser registerUser) {
        String endpoint = getEndpoint("registerUser");
        String url = baseUrl + endpoint;
        String body = getJsonBody(registerUser);
        printCurl("POST", url, body);
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
