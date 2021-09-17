package rieltorag;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class User {
    private String login;
    private String password;
    public static String kluchIz;
    public static String kluchIz2;
    static Integer vhod = 0;
   String adminlogin = "Trag";
   String adminpass = "1917";
   public static Integer id = 1;
    
    
 public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
public static Integer y = 0; 
    
    public User() {
        
    }
    
    public boolean validate(List<User> users) throws IOException {
    File file1 = new File("src\\rieltorag\\Kontrol.txt");
    FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(), true);
    BufferedWriter bw1 = new BufferedWriter(fw1);
    bw1.write("///" + "\r" + "id:" + id + ";" + "login:" + this.login + "\r");
    bw1.write("\n" + "///" + "\n");
    bw1.close();
        y = 0;
    for(User u : users){
    File file = new File("src\\rieltorag\\zayavki\\" + u.getLogin() + ".txt");
    if (!file.exists()) {
    file.createNewFile();
    }
    File file2 = new File("src\\rieltorag\\zayavki\\" + u.getPassword() + ".txt");
    if (!file2.exists()) {
    file2.createNewFile();
    }
        }
        for(User u : users){
            if (u.getLogin().equals (this.login) && u.getPassword().equals (this.password)){
         kluchIz = this.login;
         kluchIz2 = this.password;
         Stage stage = new Stage();
         stage.setTitle("Приложение");
         Parent root = FXMLLoader.load(getClass().getResource("Zajavki.fxml"));
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
         y = 1;
         return true;
            }
         if ((this.login).equals(adminlogin) && (this.password).equals(adminpass) && y == 0){
         Stage stage = new Stage();
         stage.setTitle("Панель администратора");
         Parent root = FXMLLoader.load(getClass().getResource("AdminPan.fxml"));
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
         y = 1;
         return true;
            }
        

        }
        if (y == 0 || vhod == 1){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Проверка...Успешно!");
        alert.setHeaderText("Такого пользователя не существует.");
        alert.setContentText("В базе данных такого пользователя не найдено.");
 
        alert.showAndWait();
        }
        return false; 
    }
     
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }
}

