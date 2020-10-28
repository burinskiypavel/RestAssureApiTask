import io.restassured.http.ContentType;
import models.Team;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;

public class TeamsTests extends DataForTests {

    @Test(dataProvider = "dataForTeamsPost")
    public void testTeamsCreation(Team team){
        JSONObject request = new JSONObject();
        request.put("id", team.getId());
        request.put("name", team.getName());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("http://localhost:8081/teams/")
                .then()
                .statusCode(201)
                .body("id", equalTo(team.getId()))
                .body("name", equalTo(team.getName()))
                .log().all();
    }

    @Test
    public void testGetAllTeams() {
        given()
                .get("http://localhost:8081/teams/")
                .then()
                .statusCode(200)
                .body("id", hasItems(1, 2, 3))
                .body("name", hasItems("Eagles", "Bulls", "Wolves"))
                .log().all();
    }

    @Test(dataProvider = "dataForGetTeamById")
    public void testGetTeamById(int teamId, String name) {
        baseURI = "http://localhost:8081/";
        given()
                .get("/teams/" + teamId)
                .then()
                .statusCode(200)
                .body("id", equalTo(teamId))
                .body("name", equalTo(name))
                .log().all();
    }
}
