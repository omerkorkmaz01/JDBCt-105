package dbStepDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.*;
public class StepDefinition {
    List<Object> staffTablosundakiIDler = new ArrayList<>();
    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        createConnection();
    }
    @Given("Staff tablosundaki {string} leri listelenir.")
    public void staff_tablosundaki_leri_listelenir(String id) {
        staffTablosundakiIDler =  getColumnData("SELECT * FROM u480337000_tlb_training.staff",id);
        System.out.println(staffTablosundakiIDler);
    }
    @Given("Verilen {string} dogrulanir.")
    public void verilen_dogrulanir(String id) {
        assertTrue(staffTablosundakiIDler.toString().contains(id));
    }
    @Given("Database baglantisi kapatilir")
    public void database_baglantisi_kapatilir() {
        closeConnection();
    }
}