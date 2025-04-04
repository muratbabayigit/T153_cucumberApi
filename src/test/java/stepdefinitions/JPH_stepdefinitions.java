package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;
import static org.junit.jupiter.api.Assertions.*;

public class JPH_stepdefinitions {
   String url="";
   Response response;
   JsonPath resJP;
   JSONObject reqBodyJson=new JSONObject();
    JSONObject expBody=new JSONObject();


    @Given("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String configBaseUrl) {
        url+= ConfigReader.getProperty(configBaseUrl);
        
    }

    @Then("kullanici path parametreleri olarak {string} girer")
    public void kullaniciPathParametreleriOlarakGirer(String pathParams) {
        url=url+"/"+pathParams;
        //https://jsonplaceholder.typicode.com/posts/44
    }

    @Then("kullanici donen response degerini kaydeder")
    public void kullaniciDonenResponseDegeriniKaydeder() {
        response= RestAssured.given().when().get(url);
        
    }

    @And("kullanici donen response status kodunun {int} oldugunu kontrol eder")
    public void kullaniciDonenResponseStatusKodununOldugunuKontrolEder(int expStatusCode) {
        assertEquals(expStatusCode,response.getStatusCode());
        
    }

    @And("kullanici donen response content type degerinin {string} oldugunu kontrol eder")
    public void kullaniciDonenResponseContentTypeDegerininOldugunuKontrolEder(String expContType) {
        assertEquals(expContType,response.getContentType());
    }

    @Then("kullanici icerik kontrolu icin donen response degerini jsonpath olarak kaydeder")
    public void kullaniciIcerikKontroluIcinDonenResponseDegeriniJsonpathOlarakKaydeder() {

        resJP=response.jsonPath();
    }

    @Then("kullanici response icerigindeki {string} degerinin {string} oldugunu kontrol eder")
    public void kullaniciResponseIcerigindekiDegerininOldugunuKontrolEder(String expKey, String expValue) {
        assertEquals(expValue,resJP.getString(expKey));

    }

    @Then("kullanici POST request icin reqBody hazirlar")
    public void kullaniciPOSTRequestIcinReqBodyHazirlar() {
        reqBodyJson.put("title","Ahmet");
        reqBodyJson.put("body","Merhaba");
        reqBodyJson.put("userId",7);
        reqBodyJson.put("id",70);


    }

    @Then("kullanici donen response icin bekledigi expBody hazirlar")
    public void kullaniciDonenResponseIcinBekledigiExpBodyHazirlar() {
        expBody=reqBodyJson;

    }

    @Then("kullanici POST request ile donen response degerini kaydeder")
    public void kullaniciPOSTRequestIleDonenResponseDegeriniKaydeder() {
        response=RestAssured.given().contentType(ContentType.JSON).when().body(reqBodyJson.toString()).put(url);

    }

    @Then("kullanici donen response {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullaniciDonenResponseIsimliHeaderDegerininOldugunuKontrolEder(String expHeaderKey, String expHeaderValue) {
        assertEquals(expHeaderValue,response.getHeader(expHeaderKey));
    }

    @Then("kullanici responseBody ile expBody degerlerini assert eder")
    public void kullaniciResponseBodyIleExpBodyDegerleriniAssertEder() {
        assertEquals(expBody.get("title"),resJP.getString("title"));
        assertEquals(expBody.get("body"),resJP.getString("body"));
        assertEquals(expBody.get("userId"),resJP.getInt("userId"));
        assertEquals(expBody.get("id"),resJP.getInt("id"));
    }
}
