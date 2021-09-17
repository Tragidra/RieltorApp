package rieltorag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class KatalogIz {
    String adres2,infa2;
    Integer variantiID2,variantistoim2,variantikomnat2;
    
 public static final ObservableList <KatalogIz> variant2 = FXCollections.observableArrayList();
        
    
    public KatalogIz(Integer variantiID2, Integer variantikomnat2, Integer variantistoim2, String  adres2, String infa2){
        this.variantikomnat2=variantikomnat2;
        this.adres2=adres2;
        this.variantiID2=variantiID2;
        this.variantistoim2=variantistoim2;
        this.infa2=infa2;
}

    public KatalogIz(){
    }

    public String getAdres2() {
        return adres2;
    }

    public void setAdres2(String adres2) {
        this.adres2 = adres2;
    }

    public String getInfa2() {
        return infa2;
    }

    public void setInfa2(String infa2) {
        this.infa2 = infa2;
    }

    public Integer getVariantiID2() {
        return variantiID2;
    }

    public void setVariantiID2(Integer variantiID2) {
        this.variantiID2 = variantiID2;
    }

    public Integer getVariantistoim2() {
        return variantistoim2;
    }

    public void setVariantistoim2(Integer variantistoim2) {
        this.variantistoim2 = variantistoim2;
    }

    public Integer getVariantikomnat2() {
        return variantikomnat2;
    }

    public void setVariantikomnat2(Integer variantikomnat2) {
        this.variantikomnat2 = variantikomnat2;
    }


}
