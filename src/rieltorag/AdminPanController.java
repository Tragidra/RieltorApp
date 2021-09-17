package rieltorag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class AdminPanController implements Initializable {

@FXML
private TableView <Adminka> adminTable;
@FXML
private TableColumn <Adminka, String> log;
@FXML
private TableColumn <Adminka, String> par;
@FXML
private Label loginlable;
@FXML
private Label parolLabel;
public String parol;
public String logini;
List<User> users1 = new ArrayList<>(); 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try (FileReader fr = new FileReader("src\\rieltorag\\accaunti.txt");
         BufferedReader in = new BufferedReader(fr)){
         String str;
         while ((str = in.readLine()) != null) {
                String[] massiv = str.split(" ");
                users1.add(new User(massiv[0],massiv[1] ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    Adminka.adminp.add(new Adminka("Trag", "667"));
    log.setCellValueFactory(new PropertyValueFactory<>("log"));
    par.setCellValueFactory(new PropertyValueFactory<>("par"));
    adminTable.setItems(Adminka.adminp);
    showdetailsob(null);
    adminTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetailsob(newValue));
    for(User u : users1){
    logini = u.getLogin();
    parol = u.getPassword();
    Adminka.adminp.add(new Adminka(logini, parol));
    log.setCellValueFactory(new PropertyValueFactory<>("log"));
    par.setCellValueFactory(new PropertyValueFactory<>("par"));
    adminTable.setItems(Adminka.adminp);
    } 
    
    showdetailsob(null);
    adminTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetailsob(newValue));
}
private void showdetailsob(Adminka adminka){
    if(adminka != null){
        loginlable.setText(adminka.getLog());
        parolLabel.setText(adminka.getPar());
    }
    else{
        loginlable.setText("");
        parolLabel.setText("");
    }
}
@FXML
public void deleteIz(){
System.out.println(String.valueOf(loginlable.getText()));
File iFile = new File("src\\rieltorag\\zayavki\\" + (loginlable.getText()) + ".txt");
iFile.delete();
}

@FXML
public void deleteZa(){
File iFile = new File("src\\rieltorag\\zayavki\\" + (parolLabel.getText()) + ".txt");
iFile.delete();
}

@FXML
public void deleteall() throws IOException{
File iFile = new File("src\\rieltorag\\accaunti.txt");
iFile.delete();
iFile.createNewFile();
}

@FXML
public void smotlog() throws IOException{
File file = new File("src\\rieltorag\\Kontrol.txt");
java.awt.Desktop.getDesktop().edit(file);    
}    

@FXML
public void deletebasaOb() throws IOException{
File iFile = new File("src\\rieltorag\\zayavki\\basaO.txt");
iFile.delete();
iFile.createNewFile();
}

@FXML
public void deleteLog() throws IOException{
File iFile = new File("src\\rieltorag\\Kontrol.txt");
iFile.delete();
iFile.createNewFile();
}
}
