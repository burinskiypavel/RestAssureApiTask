import io.restassured.http.ContentType;
import models.Player;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;

public class PlayersTests extends DataForTests {

    @Test(dataProvider = "dataForPlayerPost")
    public void testPlayerCreation(Player player){
        JSONObject request = new JSONObject();
        request.put("id", player.getId());
        request.put("firstName", player.getFirstName());
        request.put("lastName", player.getLastName());
        request.put("age", player.getAge());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("http://localhost:8081/players/")
                .then()
                .statusCode(201)
                .body("firstName", equalTo(player.getFirstName()))
                .body("lastName", equalTo(player.getLastName()))
                .body("age", equalTo(player.getAge()))
                .log().all();
    }

    @Test
    public void testGetAllPlayers() {
        given()
                .get("http://localhost:8081/players/")
                .then()
                .statusCode(200)
                .body("firstName", hasItems("Tom", "Sam", "Jordan"))
                .body("lastName", hasItems("Cruz", "Jonson", "TTT"))
                .log().all();
    }

    @Test(dataProvider = "dataForGetPlayerById")
    public void testGetPlayerById(int playerId, String firstName, String lastName) {
        given()
                .get("http://localhost:8081/players/" + playerId)
                .then()
                .statusCode(200)
                .body("id", equalTo(playerId))
                .body("firstName", equalTo(firstName))
                .body("lastName", equalTo(lastName))
                .log().all();
    }

    @Test(dataProvider = "dataForDelete")
    public void testPlayerDeletion(int playerId) {
        baseURI = "http://localhost:8081/";
        when()
                .delete("/players/" + playerId)
                .then()
                .statusCode(204)
                .log().all();

        //check that player is absent
        given().baseUri(baseURI)
                .log().everything()
                .get("/players/")
                .then()
                .statusCode(200)
                .body("id", not(hasItem(playerId)))
        ;



    }
}
