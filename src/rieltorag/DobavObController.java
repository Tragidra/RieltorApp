package rieltorag;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DobavObController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    } 
RrrController rrrcontroller;
String loggin = RrrController.nasfila;
private Integer pip;
private boolean okClicked = false;
private Stage dialogStage;
private Katalog variant;
@FXML
private Label LabelO1;
@FXML
private Label LabelO2;
@FXML
private Label LabelO3;
@FXML
private Label LabelO4;
@FXML
private Label LabelO5;
@FXML
private TextField TextFieldO1;
@FXML
private TextField TextFieldO2;
@FXML
private TextField TextFieldO3;
@FXML
private TextField TextFieldO4;
@FXML
private TextField TextFieldO5;
@FXML
private Button buttonO1;
@FXML
public void setDialogStage(Stage dialogStage) {
this.dialogStage = dialogStage;
}
public void setKatalog(Katalog variant){
this.variant = variant;

TextFieldO1.setText(variant.getVariantikomnat().toString());
TextFieldO2.setText(variant.getVariantiID().toString());
TextFieldO3.setText(variant.getVariantistoim().toString());
TextFieldO4.setText(variant.getAdres()); 
TextFieldO5.setText(variant.getInfa()); 
}
public boolean okis(){
return okClicked;    
}
private boolean pravda(){
String error = "";
if (TextFieldO1.getText() == null || TextFieldO1.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (TextFieldO2.getText() == null || TextFieldO2.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (TextFieldO3.getText() == null || TextFieldO3.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (TextFieldO4.getText() == null || TextFieldO4.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (TextFieldO5.getText() == null || TextFieldO5.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (error.length() == 0){
    return true;
}else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Некорректное заполнение полей");
        alert.setContentText("Иди и заполни поля нормально!");
 
        alert.showAndWait();
        return false;    
}
}
@FXML
private void dobavO(ActionEvent event){
if(variant == null){
variant = new Katalog();
}
if (pravda()) {
variant.setVariantiID(Integer.parseInt(TextFieldO1.getText()));
variant.setVariantikomnat(Integer.parseInt(TextFieldO2.getText()));
variant.setVariantistoim(Integer.parseInt(TextFieldO3.getText()));
variant.setAdres(TextFieldO4.getText());
variant.setInfa(TextFieldO5.getText());  

try {
            File file = new File("src\\rieltorag\\zayavki\\basaO.txt");
            if (file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("File already exists");
        }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(TextFieldO1.getText() + System.lineSeparator() + TextFieldO2.getText() + 
                    System.lineSeparator()  + TextFieldO3.getText() + System.lineSeparator() + 
                    TextFieldO4.getText() + System.lineSeparator() + TextFieldO5.getText() + System.lineSeparator());
            bw.close();
            Stage stage1 = (Stage) buttonO1.getScene().getWindow();
            stage1.close();
}
        catch (Exception e) {
            System.err.println(e);
        }
Katalog.variant.add(variant); 
okClicked = true;
((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
}
}
@FXML
    private void chistka(ActionEvent event){
    TextFieldO1.clear();
    TextFieldO2.clear();
    TextFieldO3.clear();
    TextFieldO4.clear();
    TextFieldO5.clear();
    }    
}
