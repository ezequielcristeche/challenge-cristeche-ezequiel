package challenge;

import challenge.controller.ListingController;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.math.BigDecimal;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Test de aceptacion de {@link ListingController}
 *
 * @author Ezequiel Cristeche
 * @since 11/9/2020
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql({"/sql/users.sql", "/sql/listings.sql", "/sql/special_prices.sql"})
class ListingControllerTest {

    @LocalServerPort
    private int port;
    private static final String url = "http://localhost";

    @BeforeEach
    void init() {
        RestAssured.baseURI = url;
        RestAssured.port = port;
    }


    @Test
    void deberia_crear_un_listado() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/crear_listado_valido.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/listings")
                .then().statusCode(201)
                .body("name", equalTo("Black Raven"))
                .body("adults", equalTo(3))
                .body("children", equalTo(2));
    }

    @Test
    void deberia_devolver_todos_los_listados(){
        get(url + "/api/listings")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(1));
    }


    @Test
    void deberia_devolver_un__listado() {
        get(url + "/api/listings/d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Listado creado"));
    }

    @Test
    void deberia_no_encontrar_un_listado() {
        get(url + "/api/listings/bafebd1e-f2ff-4a19-97c4-0def37965c68")
                .then()
                .assertThat()
                .statusCode(404)
                .body("errors[0].message", is("No existe un listado con id bafebd1e-f2ff-4a19-97c4-0def37965c68"));
    }

    @Test
    void deberia_actualizar_un_listado() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/actualizar_listado_valido.json"))
                .header("Authorization", "???")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .when()
                .put(url + "/api/listings/{uuid}")
                .then().statusCode(200)
                .body("name", equalTo("Listado Actualizado"));
    }


    @Test
    void deberia_eliminar_un_listado() {
        given()
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .when()
                .delete(url + "/api/listings/{uuid}")
                .then().statusCode(200);

    }


    @Test
    void deberia_calcular_costo_reserva_de_un_listado() {
        given().queryParam("dateSelected", "2020-09-11")
                .queryParam("checkin", "2020-09-11")
                .queryParam("checkout", "2020-09-12")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .get(url + "/api/listings/{uuid}/checkout")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void fecha_seleccionada_fuera_de_la_fecha_reservadas() {
        given().queryParam("dateSelected", "2020-09-10")
                .queryParam("checkin", "2020-09-11")
                .queryParam("checkout", "2020-09-12")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .get(url + "/api/listings/{uuid}/checkout")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("La fecha 2020-09-10 no se encuentra dentro de las fechas de reserva"));
    }

    @Test
    void fecha_checkin_mayor_a_fecha_checkout() {
        given().queryParam("dateSelected", "2020-09-10")
                .queryParam("checkin", "2020-09-11")
                .queryParam("checkout", "2020-09-10")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .get(url + "/api/listings/{uuid}/checkout")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("La fecha checkin 2020-09-11 es mayor a la fecha checkout 2020-09-10"));
    }


    @Test
    void reserva_mayor_a_28_dias() {
        given().queryParam("dateSelected", "2020-09-10")
                .queryParam("checkin", "2020-09-10")
                .queryParam("checkout", "2020-12-10")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .get(url + "/api/listings/{uuid}/checkout")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("No se puede reservar un listado por más de 28 dias"));
    }



    @Test
    void deberia_crear_un_precio_especial(){
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/crear_precio_especial_valido.json"))
                .header("Authorization", "???")
                .pathParam("uuid", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .when()
                .post(url + "/api/listings/{uuid}/special-prices")
                .then().statusCode(201)
                .body("date", equalTo("2020-12-06"));
    }


    @Test
    void deberia_eliminar_un_precio_special() {
        given()
                .pathParam("idListing", "d8fc6289-d2de-4331-bec2-d1ae86286a94")
                .pathParam("idSpecialPrice", "da7032aa-9c69-49bf-887f-c72c1131de35")
                .when()
                .delete(url + "/api/listings/{idListing}/special-prices/{idSpecialPrice}")
                .then().statusCode(200);

    }


}
