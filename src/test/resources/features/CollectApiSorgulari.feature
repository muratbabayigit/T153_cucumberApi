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
