package rieltorag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Katalog {
    String adres,infa;
    Integer variantiID,variantistoim,variantikomnat;
    
 public static final ObservableList <Katalog> variant = FXCollections.observableArrayList();
        
    
    public Katalog(Integer variantiID, Integer variantikomnat, Integer variantistoim, String  adres, String infa){
        this.variantikomnat=variantikomnat;
        this.adres=adres;
        this.variantiID=variantiID;
        this.variantistoim=variantistoim;
        this.infa=infa;
}

    public Katalog(){
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Integer getVariantiID() {
        return variantiID;
    }

    public void setVariantiID(Integer variantiID) {
        this.variantiID = variantiID;
    }

    public Integer getVariantistoim() {
        return variantistoim;
    }

    public void setVariantistoim(Integer variantistoim) {
        this.variantistoim = variantistoim;
    }

    public Integer getVariantikomnat() {
        return variantikomnat;
    }

    public void setVariantikomnat(Integer variantikomnat) {
        this.variantikomnat = variantikomnat;
    }
     public String getInfa() {
        return infa;
    }

    public void setInfa(String infa) {
        this.infa = infa;
    }
}

