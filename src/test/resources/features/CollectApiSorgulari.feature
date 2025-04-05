Feature: CollectApi Sorgulari

  Scenario: Nöbetci Eczaneler Sorgusu

    * kullanici sorgu icin "collectApiUrl" adresine gider
       #base url adresi alındı
    * kullanici sorgu icin path parametresi olarak "health/dutyPharmacy" girer
       #baseurl adresine path parametreleri eklendi
    * kullanici sorgu icin query parametrelerine "il" olarak "istanbul" ve "ilce" olarak "üsküdar" girer
       #url adresine query parametreleri eklendi
    * kullanici authorization header degeri olarak "apiKey" girerek Get request yapar ve sonucu kaydeder
       #apikey kullanılarak sorgu yapıldı ve cevap kaydedildi
    * kullanici donen cevabi yazdirir
        #donen cevap yazdırıldı

  Scenario: Doviz Fiyatlari Sorgusu
    * kullanici sorgu icin "collectApiUrl" adresine gider
    * kullanici sorgu icin path parametresi olarak "economy/currencyToAll" girer
    #'https://api.collectapi.com/economy/currencyToAll?int=10&base=USD' \
    * kullanici sorgu icin query parametrelerine "int" olarak "1" ve "base" olarak "TRY" girer
    * kullanici authorization header degeri olarak "apiKey" girerek Get request yapar ve sonucu kaydeder
    * kullanici donen cevabi yazdirir

    Scenario: Hal Fiyatlari Sorgusu
      #https://api.collectapi.com/bazaar/single?city=istanbul
      * kullanici sorgu icin "collectApiUrl" adresine gider
      * kullanici sorgu icin path parametresi olarak "bazaar/single" girer
      * kullanici sorgu icin query parametrelerine "city" olarak "ankara"
      * kullanici authorization header degeri olarak "apiKey" girerek Get request yapar ve sonucu kaydeder
      * kullanici donen cevabi yazdirir

