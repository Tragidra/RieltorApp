package rieltorag;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Adminka {
String log,par;    

public static final ObservableList <Adminka> adminp = FXCollections.observableArrayList();

 public Adminka(String log, String par){
   this.log = log;
   this.par = par;
 }
 public Adminka(){
 }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }
 
}