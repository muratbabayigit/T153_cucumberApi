  # https://reqres.in/api/users/1 adresine bir GET request gönderip
   # status code'unun 200 olduğunu
   # "Server" isimli header değerinin "cloudflare" olduğunu
   # "data" altındaki "first_name" değerinin "George" olduğunu
   # "data" altindaki "last_name" degerinin "Bluth" oldugunu
   # "data" altindaki "email" degerinin "george.bluth@reqres.in" olduğunu
   # "data" altindaki "avatar" degerinin "https://reqres.in/img/faces/1-image.jpg" olduğunu
   # "support" altindaki "url" degerinin "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral" olduğunu
   # "support" altindaki "text" degerinin "Tired of writing endless social media content? Let Content Caddy generate it for you." oldugunu
  # test eder.
    Feature: ReqRes GET Request

      Scenario: reqRes Get Request and assertion

        * kullanici request icin "reqresUrl" adresine gider
        * kullanici request icin path parametresi olarak "api/users/1" dgerini girer
        * kullanici GET request yapar ve response kaydeder
        * kullanici request icin donen response status kodunun 200 oldugunu kontrol eder
        * kullanici "Server" isimli header degerinin "cloudflare" oldugunu kontrol eder
        * kullanici request kontrolu icin donen response degerini jsonpath olarak kaydeder
        * kullanici "data" response icindeki "first_name" degerinin "George" oldugunu kontrol eder
        * kullanici "data" response icindeki "last_name" degerinin "Bluth" oldugunu kontrol eder
        * kullanici "data" response icindeki "email" degerinin "george.bluth@reqres.in" oldugunu kontrol eder
        * kullanici "data" response icindeki "avatar" degerinin "https://reqres.in/img/faces/1-image.jpg" oldugunu kontrol eder
        * kullanici "support" response icindeki "url" degerinin "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral" oldugunu kontrol eder
        * kullanici "support" response icindeki "text" degerinin "Tired of writing endless social media content? Let Content Caddy generate it for you." oldugunu kontrol eder