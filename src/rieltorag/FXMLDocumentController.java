package rieltorag;
import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label label1;
    
    @FXML
    private Hyperlink button1;
        
    @FXML
    private Button button2;
     
            List<User> users = new ArrayList<>(); 

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        User user = new User(textField1.getText(), textField2.getText());
        User.vhod = 1;
        System.out.println(user.validate(users));
        if (User.y == 1){
        Stage stage1 = (Stage) button2.getScene().getWindow();
        stage1.close();
        button2.setStyle("-fx-background-color: #A9A9A9; ");
        }
        
    }
    
    @FXML
     private void Registr(ActionEvent event) throws IOException {
         Stage stage = new Stage();
         stage.setTitle("Окно регистрации");
         Parent root = FXMLLoader.load(getClass().getResource("rrr.fxml"));
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
         Stage stage1 = (Stage) button1.getScene().getWindow();
         stage1.close();
         stage.setResizable(false);
        
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try (FileReader fr = new FileReader("src\\rieltorag\\accaunti.txt");
         BufferedReader in = new BufferedReader(fr)){
         String str;
            while ((str = in.readLine()) != null) {
                String[] massiv = str.split(" ");
                users.add(new User(massiv[0],massiv[1] ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   }  
    @FXML
    private void handleButtonActionChist(ActionEvent event){
    textField1.clear();
    textField2.clear();
}
    
}
