package dbStepDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.*;
public class StepDefinition {
    List<Object> staffIdList = new ArrayList<>();
    List<Object> userPhoneList = new ArrayList<>();

    List<Object> userEmailList = new ArrayList<>();

    List<Object> adresList = new ArrayList<>();
    List<Object> usersIdList = new ArrayList<>();


    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        createConnection();
    }
    @Given("Staff tablosundaki {string} leri listelenir.")
    public void staff_tablosundaki_leri_listelenir(String id) {
        staffIdList =  getColumnData("SELECT * FROM u480337000_tlb_training.staff",id);
        System.out.println(staffIdList);
    }
    @Given("Verilen {string} dogrulanir.")
    public void verilen_dogrulanir(String arananId) {
        System.out.println(arananId);
        assertTrue(staffIdList.toString().contains(arananId));
    }
    @Given("Database baglantisi kapatilir")
    public void database_baglantisi_kapatilir() {
        closeConnection();
    }

    @Given("Users tablosundaki {string} numaralari listelenir.")
    public void users_tablosundaki_numaralari_listelenir(String phone) {
        userPhoneList =getColumnData("SELECT * FROM u480337000_tlb_training.users", phone);

    }
    @Given("Verilen {string} numarasi dogrulanir.")
    public void verilen_numarasi_dogrulanir(String arananPhone) {

        System.out.println(arananPhone);
        assertTrue(userPhoneList.toString().contains(arananPhone));
    }

    @Given("Users tablosundaki {string} 'ler listelenir.")
    public void users_tablosundaki_ler_listelenir(String email) {
        userEmailList = getColumnData( "SELECT * FROM u480337000_tlb_training.users", email);

    }
    @Given("Verilen {string} in listede oldugu dogrulanir.")
    public void verilen_in_listede_oldugu_dogrulanir(String arananEmail) {
        System.out.println(arananEmail);
        assertTrue(userEmailList.toString().contains(arananEmail));
    }

    @Given("{string} numarasi verilen customerin {string} güncellenir.")
    public void numarasi_verilen_customerin_güncellenir(String adresi, String id) throws SQLException {

        update("UPDATE u480337000_tlb_training.customer_addresses SET address= '"+adresi+"' WHERE id="+id);
    }

    @Given("customer {string} tablosundaki adsress bilgileri listelenir.")
    public void customer_tablosundaki_adsress_bilgileri_listelenir(String adres) {

        adresList =getColumnData("SELECT * FROM u480337000_tlb_training.customer_addresses",adres);
        System.out.println(adresList);
    }

    @Given("{string} guncellendigi dogrulanir.")
    public void guncellendigi_dogrulanir(String adres){

        assertTrue(adresList.toString().contains(adres));
    }

    @Given("{string}, {string}, {string}, {string}, {string}, {string},{string} girilerek user kaydi olusturulur")
    public void girilerek_user_kaydi_olusturulur(String first_name, String last_name, String user_name, String email, String id, String role_id, String password) throws SQLException {

        String query="INSERT INTO u480337000_tlb_training.users(first_name, last_name, username, email, id, role_id, password) values ('"+first_name+"', '"+last_name+"', '"+user_name+"', '"+email+"', "+id+" ,"+role_id+", '"+password+"');";
        update(query);

    }
    @Given("Olusturulan User'in {string} sinin listede oldugu dogrulanir")
    public void olusturulan_user_in_sinin_listede_oldugu_dogrulanir(String id) {
        assertTrue(usersIdList.toString().contains(id));
    }
    @Given("user tablosundaki {string} ler listte listelenir")
    public void user_tablosundaki_ler_listte_listelenir(String id) {
        usersIdList= getColumnData("SELECT * FROM u480337000_tlb_training.users",id);
        System.out.println(usersIdList);
    }



}