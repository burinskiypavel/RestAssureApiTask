import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class ProfileTests {

    @Test
    public void testProfileTeams(){
        given()
                .get("http://localhost:8081/profile/teams")
                .then()
                .statusCode(200)
                .body("alps.descriptor.name", hasItems("teams", "team"))
                .body("alps.descriptor.type", hasItems("IDEMPOTENT", "UNSAFE"))
                .log().all();
    }

    @Test
    public void testProfileЗlayers(){
        given()
                .get("http://localhost:8081/profile/players")
                .then()
                .statusCode(200)
                .body("alps.descriptor.name", hasItems("players", "player"))
                .body("alps.descriptor.type", hasItems("SAFE", "UNSAFE"))
                .log().all();
    }
    }
