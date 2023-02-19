Feature: DB_sorgulama

  #Database baglantisi kurarak staff tablosundaki Id'lerin icinde "5" id numarasin
  #SELECT * FROM u480337000_tlb_training.staff;
@deneme
  Scenario Outline: Staff tablosundan "ID" sorgulama

    * Database baglantisi kurulur.
    * Staff tablosundaki "id" leri listelenir.
    * Verilen "<id>" dogrulanir.
    * Database baglantisi kapatilir

    Examples:
    |id|
    |5 |