package rieltorag;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class ZayavdobController implements Initializable {
RrrController rrrcontroller;
String loggin = RrrController.nasfila;
@FXML
private TextField zGorodField;
@FXML
private TextField zKomnatField;
@FXML
private TextField zRajonField;
@FXML
private TextField zPloshadField;
@FXML
private TextField zArendaField;
private Integer pip;
@FXML
private Label Label1;
@FXML
private Label Label2;
@FXML
private Label Label3;
@FXML
private Label Label4;
@FXML
private Label Label5;
private Stage dialogStage;
private Button button1;
private boolean okClicked = false; // Не трогай, сломается
private KatalogZa variant3;
public void setDialogStage(Stage dialogStage) {
this.dialogStage = dialogStage;
}
public void setKatalogZa(KatalogZa variant3){
this.variant3 = variant3;

zGorodField.setText(variant3.getZGorod());
zKomnatField.setText(variant3.getZKomnat().toString());
zRajonField.setText(variant3.getZRajon());
zPloshadField.setText(variant3.getZPloshad().toString()); 
zArendaField.setText(variant3.getZArenda().toString());
}
public boolean okis(){
return okClicked;    
}
private boolean pravda(){
String error = "";
if (zGorodField.getText() == null || zGorodField.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (zKomnatField.getText() == null || zKomnatField.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (zRajonField.getText() == null || zRajonField.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (zPloshadField.getText() == null || zPloshadField.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (zArendaField.getText() == null || zArendaField.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (error.length() == 0){
    return true;
}else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Некорректное заполнение полей");
        alert.setContentText("Заполните поля анкеты правильно");
 
        alert.showAndWait();
        return false;    
}
}
@FXML
private void dobav(ActionEvent event) throws IOException{
try {
            File file = new File("src\\rieltorag\\zayavki\\" 
                    + User.kluchIz2 + ".txt");
            if (file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("File already exists");
        }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(zGorodField.getText() + System.lineSeparator() + zKomnatField.getText() + 
            System.lineSeparator()  + zRajonField.getText() + System.lineSeparator() + 
            zPloshadField.getText() + System.lineSeparator() + zArendaField.getText() + System.lineSeparator());
            bw.close();
}
        catch (Exception e) {
            System.err.println(e);
        }
if(variant3 == null){
variant3 = new KatalogZa();
}
if (pravda()) {
variant3.setZGorod(zGorodField.getText());
variant3.setZKomnat(Integer.parseInt(zKomnatField.getText()));
variant3.setZRajon(zRajonField.getText());
variant3.setZPloshad(Integer.parseInt(zPloshadField.getText()));  
variant3.setzArenda(Integer.parseInt(zArendaField.getText()));  

KatalogZa.variant3.add(variant3); 
okClicked = true;
((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
}
}
@FXML
    private void chistka(ActionEvent event){
    zGorodField.clear();
    zKomnatField.clear();
    zRajonField.clear();
    zPloshadField.clear();
    zArendaField.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }    
    
}
