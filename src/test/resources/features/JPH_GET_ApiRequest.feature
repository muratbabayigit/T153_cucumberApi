Feature: JPH GET Request
  # https://jsonplaceholder.typicode.com/posts/44 endpointine
  # bir GET request gonderdigimizde donen response’un
  # status code’unun 200 olduğunu,
  # content type degerinin "application/json; charset=utf-8 " ve
  # “title” degerinin “optio dolor molestias sit” oldugunu test edin

  Scenario: JPH sitesine GET request yaparak response elde etme

    Given kullanici "JPHUrl" adresine gider
    Then kullanici path parametreleri olarak "posts/44" girer
    Then kullanici donen response degerini kaydeder
    And kullanici donen response status kodunun 200 oldugunu kontrol eder
    And kullanici donen response content type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    Then kullanici icerik kontrolu icin donen response degerini jsonpath olarak kaydeder
    Then kullanici response icerigindeki "title" degerinin "optio dolor molestias sit" oldugunu kontrol eder


#    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
#    PUT request yolladigimizda donen response’in
#    status kodunun 200, content type’inin “application/json; charset=utf-8”,
#    Connection header degerinin “keep-alive”
#    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

#   Request Body                      Expected Data :
#   {                                     {
#    "title": "Ahmet",                      "title": "Ahmet",
#    "body": "Merhaba",                     "body": "Merhaba",
#    "userId": 10,                          "userId": 10,
#    "id": 70                               "id": 70
#   }                                     }

  Scenario: JPH POST request ile yeni booking olusturmak

    Given kullanici "JPHUrl" adresine gider
    Then kullanici path parametreleri olarak "posts/70" girer
    Then kullanici POST request icin reqBody hazirlar
    Then kullanici donen response icin bekledigi expBody hazirlar
    Then kullanici POST request ile donen response degerini kaydeder
    Then kullanici donen response status kodunun 200 oldugunu kontrol eder
    Then kullanici donen response content type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    Then kullanici donen response "Connection" isimli header degerinin "keep-alive" oldugunu kontrol eder
    Then kullanici icerik kontrolu icin donen response degerini jsonpath olarak kaydeder
    Then kullanici responseBody ile expBody degerlerini assert eder



