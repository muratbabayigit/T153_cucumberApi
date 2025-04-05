package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqRes_stepdefinitions {
    String url="";
    Response response;
    JsonPath resJP;


    @When("kullanici request icin {string} adresine gider")
    public void kullaniciRequestIcinAdresineGider(String configBaseUrl) {
        url+= ConfigReader.getProperty(configBaseUrl);
    }

    @When("kullanici request icin path parametresi olarak {string} dgerini girer")
    public void kullaniciRequestIcinPathParametresiOlarakDgeriniGirer(String pathParams) {
        url=url+"/"+pathParams;
    }

    @When("kullanici GET request yapar ve response kaydeder")
    public void kullaniciGETRequestYaparVeResponseKaydeder() {
        response= RestAssured.given().when().get(url);
    }

    @When("kullanici {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullaniciIsimliHeaderDegerininOldugunuKontrolEder(String expHeaderKey, String expHeaderValue) {
        assertEquals(expHeaderValue,response.getHeader(expHeaderKey));
    }

    @When("kullanici {string} response icindeki {string} degerinin {string} oldugunu kontrol eder")
    public void kullaniciResponseIcindekiDegerininOldugunuKontrolEder(String obj, String key, String value) {
        assertEquals(value,resJP.getString(obj+"."+key));
                                              //data.first_name

    }

    @When("kullanici request icin donen response status kodunun {int} oldugunu kontrol eder")
    public void kullaniciRequestIcinDonenResponseStatusKodununOldugunuKontrolEder(int expStatusCode) {
        assertEquals(expStatusCode,response.getStatusCode());
    }

    @When("kullanici request kontrolu icin donen response degerini jsonpath olarak kaydeder")
    public void kullaniciRequestKontroluIcinDonenResponseDegeriniJsonpathOlarakKaydeder() {
        resJP=response.jsonPath();
    }
}
