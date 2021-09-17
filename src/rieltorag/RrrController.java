package rieltorag;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RrrController implements Initializable {
@FXML
private TextField textField1;

@FXML
private TextField textField2;

@FXML
private TextField textField3;

@FXML
private Button button;

private Stage dialogStage;

List<User> users = new ArrayList<>(); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 try (FileReader fr = 
                 new FileReader("src\\rieltorag\\accaunti.txt");
                BufferedReader in = new BufferedReader(fr)){
            String str;
            while ((str = in.readLine()) != null) {
                String[] massiv = str.split(" ");
                users.add(new User(massiv[0],massiv[1] ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO
    }
Integer id = 1;
public static String kluch;
public static String nasfila;
Integer tot = 0;
private boolean pravda(){
if(textField2.getText().equals(textField3.getText())){
System.out.println(textField2.getText());
tot = 1;  
}
String error = "";
if (textField1.getText() == null || textField1.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (textField2.getText() == null || textField2.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (textField3.getText() == null || textField3.getText().length() == 0) {
error += "Нет доступных данных\n"  ;  
}
if (error.length() == 0 || tot == 1){
    return true;
}else{
    if(tot == 0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Некорректное заполнение полей");
        alert.setContentText("Заполните поля анкеты правильно");
 
        alert.showAndWait();
    } else {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.initOwner(dialogStage);
    alert.setTitle("Ошибка");
    alert.setHeaderText("Введённые пароли не совпадают");
    alert.setContentText("Введите оба раза оди и тот же пароль"); 
    
    alert.showAndWait();
    }
    return false;    
}
}

@FXML
    private void handleButtonActionReg(ActionEvent event) throws IOException {
    String sap1 = textField1.getText();
    String sap2 = textField2.getText();
    String sap3 = textField3.getText();
    if (pravda() == true) {
    User user = new User(textField1.getText(), textField2.getText());
    System.out.println(user.validate(users));
        if (User.y == 1){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка:");
        alert.setHeaderText("Данный пользователь уже существует в системе");
        alert.setContentText("Произведён вход в данный аккаунт");
 
        alert.showAndWait();
        Stage stage1 = (Stage) button.getScene().getWindow();
        stage1.close();
        return;
        }
    try {
         File file = new File("src\\rieltorag\\accaunti.txt");

                if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n" + sap1+ " " + sap2 + "\r");
            bw.close();
} 
       catch (IOException e) {
        e.printStackTrace();                
        }
    File file = new File("src\\rieltorag\\zayavki\\" + sap1 + ".txt");
    if (!file.exists()) {
    file.createNewFile();
    }
    File file2 = new File("src\\rieltorag\\zayavki\\" + sap2 + ".txt");
    if (!file2.exists()) {
    file2.createNewFile();
    }
    kluch = sap2;
    id = id + 1;
    nasfila = sap1;
    Stage stage = new Stage();
    stage.setTitle("Вход в аккаунт");
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    Stage stage1 = (Stage) button.getScene().getWindow();
    stage1.close();
    }
    }
    public static String getkluch() {
        if (kluch == null) {
        kluch = "666";
    }
        return kluch;
    }
    }
    

