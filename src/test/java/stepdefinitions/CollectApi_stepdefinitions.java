package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;

public class CollectApi_stepdefinitions {
    String url="";
    Response response;

    @Given("kullanici sorgu icin {string} adresine gider")
    public void kullaniciSorguIcinAdresineGider(String configBaseUrl) {
        url+= ConfigReader.getProperty(configBaseUrl);
    }

    @Then("kullanici sorgu icin path parametresi olarak {string} girer")
    public void kullaniciSorguIcinPathParametresiOlarakGirer(String pathParams) {
        url=url+"/"+pathParams;
    }

    @Then("kullanici sorgu icin query parametrelerine {string} olarak {string} ve {string} olarak {string} girer")
    public void kullaniciSorguIcinQueryParametrelerineOlarakVeOlarakGirer(String qp1Key, String qp1Value, String qp2key, String qp2Value) {
        url=url+"?"+qp1Key+"="+qp1Value+"&"+qp2key+"="+qp2Value;
    }


    @Then("kullanici authorization header degeri olarak {string} girerek Get request yapar ve sonucu kaydeder")
    public void kullaniciAuthorizationHeaderDegeriOlarakGirerekGetRequestYaparVeSonucuKaydeder(String apiKey) {
        response= RestAssured.given().when().header("authorization","apikey "+ConfigReader.getProperty(apiKey)).get(url);
    }

    @Then("kullanici donen cevabi yazdirir")
    public void kullaniciDonenCevabiYazdirir() {
        response.prettyPrint();
    }
}
