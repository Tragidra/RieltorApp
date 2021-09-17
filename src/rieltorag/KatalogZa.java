package rieltorag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class KatalogZa {
    String zGorod,zRajon;
    Integer zKomnat,zPloshad,zArenda;
    
 public static final ObservableList <KatalogZa> variant3 = FXCollections.observableArrayList();
        
    
    public KatalogZa(String zGorod, Integer zKomnat, String zRajon, Integer  zPloshad, Integer zArenda){
        this.zGorod=zGorod;
        this.zKomnat=zKomnat;
        this.zRajon=zRajon;
        this.zPloshad=zPloshad;
        this.zArenda=zArenda;
}

    public KatalogZa(){
    }

    public String getZGorod() {
        return zGorod;
    }

    public void setZGorod(String zGorod) {
        this.zGorod = zGorod;
    }

    public String getZRajon() {
        return zRajon;
    }

    public void setZRajon(String zRajon) {
        this.zRajon = zRajon;
    }

    public Integer getZKomnat() {
        return zKomnat;
    }

    public void setZKomnat(Integer zKomnat) {
        this.zKomnat = zKomnat;
    }

    public Integer getZPloshad() {
        return zPloshad;
    }

    public void setZPloshad(Integer zPloshad) {
        this.zPloshad = zPloshad;
    }

    public Integer getZArenda() {
        return zArenda;
    }

    public void setzArenda(Integer zArenda) {
        this.zArenda = zArenda;
    }


}  