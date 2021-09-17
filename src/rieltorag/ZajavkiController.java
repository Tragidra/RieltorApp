package rieltorag;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ZajavkiController implements Initializable {
@FXML
private TableView <Katalog> catalogeTable;
@FXML
private TableColumn <Katalog, String> variantiID;
@FXML
private TableColumn <Katalog, String> variantikomnat;
@FXML
private TableColumn <Katalog, String> variantistoim;
@FXML
private TableColumn <Katalog, String> adres;
@FXML
private TableColumn <Katalog, String> infa;
@FXML
private Label variantikomnatLabel;
@FXML
private Label variantiIDLabel;
@FXML
private Label variantistoimLabel;
@FXML
private Label adresLabel;
@FXML
private Label infaLabel;
@FXML
private Tab catalogtab;
Integer s1 = 0;
Integer s2 = 1;
Integer s3 = 2;
Integer s4 = 3;
Integer s5 = 4;
private KatalogIz variant2;
public static Integer vID;
public static Integer vKom;
public static Integer vStoim;
public static String vAdres;
public static String vInfa;
public static Integer vID2;
public static Integer vKom2;
public static Integer vStoim2;
public static String vAdres2;
public static String vInfa2;
public static String Gorod;
public static String Rajon;
public static Integer Komnat;
public static Integer Ploshad;
public static Integer Arenda;
private Label Label1;
@FXML
private Label Label2;
@FXML
private Label Label3;
@FXML
private Label Label4;
@FXML
private Label Label5;
@FXML
private Button buttonIz;  
@FXML
private TableView <KatalogIz> catalogeTable2;
@FXML
private TableColumn <KatalogIz, String> variantiID2;
@FXML
private TableColumn <KatalogIz, String> variantikomnat2;
@FXML
private TableColumn <KatalogIz, String> variantistoim2;
@FXML
private TableColumn <KatalogIz, String> adres2;
@FXML
private TableColumn <KatalogIz, String> infa2;
@FXML
private Label variantikomnatLabel2;
@FXML
private Label variantiIDLabel2;
@FXML
private Label variantistoimLabel2;
@FXML
private Label adresLabel2;
@FXML
private Label infaLabel2;
@FXML
private TableView <KatalogZa> catalogeTable3;
@FXML
private TableColumn <KatalogZa, String> zGorod;
@FXML
private TableColumn <KatalogZa, String> zKomnat;
@FXML
private TableColumn <KatalogZa, String> zRajon;
@FXML
private TableColumn <KatalogZa, String> zPloshad;
@FXML
private TableColumn <KatalogZa, String> zArenda;
@FXML
private Label zGorodLabel;
@FXML
private Label zKomnatLabel;
@FXML
private Label zRajonLabel;
@FXML
private Label zPloshadLabel;
@FXML
private Label zArendaLabel;
@FXML
private Tab catalogtab2;
@FXML
private Parent smena;
Integer k1 = 0;
Integer k2 = 1;
Integer k3 = 2;
Integer k4 = 3;
Integer k5 = 4;
Integer z1 = 0;
Integer z2 = 1;
Integer z3 = 2;
Integer z4 = 3;
Integer z5 = 4;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            FileInputStream fis = null;
            try {
                File file = new File("src\\rieltorag\\zayavki\\basaO.txt");
                fis = new FileInputStream(file);
                byte[] byteArray = new byte[(int)file.length()];
                fis.read(byteArray);
                String data = new String(byteArray);
                String[] stringArray = data.split("\r\n");
                int otvet = (stringArray.length) / 5;
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                List<String> words = reader.lines().flatMap(line -> Stream.of(line.split("\\s+"))).collect(Collectors.toList());
                for (int i = 0; i < otvet; i++){
                    vID = Integer.parseInt (words.get(s1));
                    vKom = Integer.parseInt (words.get(s2));
                    vStoim = Integer.parseInt (words.get(s3));
                    vAdres = words.get(s4);
                    vInfa = words.get(s5);
                    s1 += 5;
                    s2 += 5;
                    s3 += 5;
                    s4 += 5;
                    s5 += 5;
                    Katalog.variant.add(new Katalog(vID, vKom, vStoim, vAdres, vInfa));
                    variantiID.setCellValueFactory(new PropertyValueFactory<>("variantiID"));
                    variantikomnat.setCellValueFactory(new PropertyValueFactory<>("variantikomnat"));
                    variantistoim.setCellValueFactory(new PropertyValueFactory<>("variantistoim"));
                    adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
                    infa.setCellValueFactory(new PropertyValueFactory<>("infa"));
                    catalogeTable.setItems(Katalog.variant);
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            showdetails(null);
            catalogeTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetails(newValue));
            FileInputStream fis2 = null;
            try {
                File file2 = new File("src\\rieltorag\\zayavki\\" + User.kluchIz + ".txt");
                fis2 = new FileInputStream(file2);
                byte[] byteArray2 = new byte[(int)file2.length()];
                fis2.read(byteArray2);
                String data = new String(byteArray2);
                String[] stringArray = data.split("\r\n");
                int dlina = (stringArray.length) / 5;
                FileReader fr = new FileReader(file2);
                BufferedReader reader = new BufferedReader(fr);
                List<String> words = reader.lines().flatMap(line -> Stream.of(line.split("\\s+"))).collect(Collectors.toList());
                for (int i = 0; i < dlina; i++){
                    vID2 = Integer.parseInt (words.get(k1));
                    vKom2 = Integer.parseInt (words.get(k2));
                    vStoim2 = Integer.parseInt (words.get(k3));
                    vAdres2 = words.get(k4);
                    vInfa2 = words.get(k5);
                    k1 += 5;
                    k2 += 5;
                    k3 += 5;
                    k4 += 5;
                    k5 += 5;
                    KatalogIz.variant2.add(new KatalogIz(vID2, vKom2, vStoim2, vAdres2, vInfa2));
                    variantiID2.setCellValueFactory(new PropertyValueFactory<>("variantiID2"));
                    variantikomnat2.setCellValueFactory(new PropertyValueFactory<>("variantikomnat2"));
                    variantistoim2.setCellValueFactory(new PropertyValueFactory<>("variantistoim2"));
                    adres2.setCellValueFactory(new PropertyValueFactory<>("adres2"));
                    infa2.setCellValueFactory(new PropertyValueFactory<>("infa2"));
                    catalogeTable2.setItems(KatalogIz.variant2);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis2.close();
                } catch (IOException ex) {
                    Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            showdetails2(null);
            catalogeTable2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetails2(newValue));
            FileInputStream fis3 = null;
            File file3 = new File("src\\rieltorag\\zayavki\\" + User.kluchIz2 + ".txt");
            fis3 = new FileInputStream(file3);
            byte[] byteArray = new byte[(int)file3.length()];
            fis3.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\r\n");
            int dlina3 = (stringArray.length) / 5;
            FileReader fr3 = new FileReader(file3);
            BufferedReader reader3 = new BufferedReader(fr3);
            List<String> words = reader3.lines().flatMap(line -> Stream.of(line.split("\\s+"))).collect(Collectors.toList());
            for (int i = 0; i < dlina3; i++){
                Gorod = words.get(z1);
                Komnat = Integer.parseInt (words.get(z2));
                Rajon =  words.get(z3);
                Ploshad =Integer.parseInt (words.get(z4));
                Arenda = Integer.parseInt (words.get(z5));
                z1 += 5;
                z2 += 5;
                z3 += 5;
                z4 += 5;
                z5 += 5;
                KatalogZa.variant3.add(new KatalogZa(Gorod, Komnat, Rajon, Ploshad, Arenda)); 
                zGorod.setCellValueFactory(new PropertyValueFactory<KatalogZa, String>("zGorod"));
                zKomnat.setCellValueFactory(new PropertyValueFactory<KatalogZa, String>("zKomnat"));
                zRajon.setCellValueFactory(new PropertyValueFactory<KatalogZa, String>("zRajon"));
                zPloshad.setCellValueFactory(new PropertyValueFactory<KatalogZa, String>("zPloshad"));
                zArenda.setCellValueFactory(new PropertyValueFactory<KatalogZa, String>("zArenda")); 
                catalogeTable3.setItems(KatalogZa.variant3);
                showdetails3(null);
                catalogeTable3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetails3(newValue));
                try {
                    fis3.close();
                } catch (IOException ex) {
                    Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ZajavkiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        showdetails3(null);
        catalogeTable3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showdetails3(newValue));
    } 
private void showdetails(Katalog katalog){
    if(katalog != null){
        variantiIDLabel.setText(katalog.getVariantiID().toString());
        variantikomnatLabel.setText(katalog.getVariantikomnat().toString());
        variantistoimLabel.setText(katalog.getVariantistoim().toString());
        adresLabel.setText(katalog.getAdres()); 
        infaLabel.setText(katalog.getInfa());
    }
    else{
        variantiIDLabel.setText("");
        variantikomnatLabel.setText("");
        variantistoimLabel.setText("");
        adresLabel.setText("");
        infaLabel.setText("");
    }
}
private void showdetails2(KatalogIz katalogiz){
    if(katalogiz != null){
        variantiIDLabel2.setText(katalogiz.getVariantikomnat2().toString());
        variantikomnatLabel2.setText(katalogiz.getVariantiID2().toString());
        variantistoimLabel2.setText(katalogiz.getVariantistoim2().toString());
        adresLabel2.setText(katalogiz.getAdres2()); 
        infaLabel2.setText(katalogiz.getInfa2());
    }
    else{
        variantiIDLabel2.setText("");
        variantikomnatLabel2.setText("");
        variantistoimLabel2.setText("");
        adresLabel2.setText("");
        infaLabel2.setText("");
    }
}
private void showdetails3(KatalogZa katalogza){
    if(katalogza != null){
        zGorodLabel.setText(katalogza.getZGorod());
        zKomnatLabel.setText(katalogza.getZKomnat().toString());
        zRajonLabel.setText(katalogza.getZRajon());
        zPloshadLabel.setText(katalogza.getZPloshad().toString()); 
        zArendaLabel.setText(katalogza.getZArenda().toString());
    }
    else{
        zGorodLabel.setText("");
        zKomnatLabel.setText("");
        zRajonLabel.setText("");
        zPloshadLabel.setText("");
        zArendaLabel.setText("");
    }
}
@FXML
private void vIz(ActionEvent event) throws IOException{
    int selectedIndex = catalogeTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0){
    File musor = new File("src\\rieltorag\\zayavki\\musor.txt");    
    File fileIz = new File("src\\rieltorag\\zayavki\\" + 
            User.kluchIz + ".txt");
    BufferedOutputStream bufOut = new BufferedOutputStream(new FileOutputStream(fileIz, true));
    BufferedInputStream bufRead = new BufferedInputStream(new FileInputStream(musor));
    int n; 
    FileWriter writerIz = new FileWriter (musor);
    writerIz.write(variantiIDLabel.getText());
    writerIz.write(System.lineSeparator() + variantikomnatLabel.getText() + System.lineSeparator());
    writerIz.write(variantistoimLabel.getText() + System.lineSeparator());
    writerIz.write(adresLabel.getText() + System.lineSeparator());
    writerIz.write(infaLabel.getText() + System.lineSeparator());
    writerIz.close();
    while((n = bufRead.read()) != -1) {
    bufOut.write(n);
    }
    bufOut.flush();
    bufOut.close();
    bufRead.close();
    Katalog katalog = catalogeTable.getSelectionModel().getSelectedItem();
    KatalogIz.variant2.add(new KatalogIz(katalog.getVariantiID(),katalog.getVariantikomnat(),
            katalog.getVariantistoim(),katalog.getAdres(),katalog.getInfa()));
    catalogeTable2.setItems(KatalogIz.variant2);
    System.out.println(KatalogIz.variant2.get(KatalogIz.variant2.size()-1).adres2);
    }else{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Не выбрано объявление");
        alert.setContentText("Выберите объявление в каталоге.");
 
        alert.showAndWait();
    }    
}
@FXML
private void addZa(ActionEvent event) throws IOException{
Stage stage = new Stage();
Parent root = FXMLLoader.load(getClass().getResource("Zayavdob.fxml"));
Scene scene = new Scene(root);
stage.setScene(scene);
stage.setResizable(false);
stage.showAndWait();
}
@FXML
private void addOb(ActionEvent event) throws IOException{
Stage stage = new Stage();
Parent root = FXMLLoader.load(getClass().getResource("DobavOb.fxml"));
Scene scene = new Scene(root);
stage.setScene(scene);
stage.setResizable(false);
stage.showAndWait();
}
@FXML
private void statistikuposmotrerAction() throws FileNotFoundException, IOException{
      File fileIz = new File("src\\rieltorag\\zayavki\\" + User.kluchIz + ".txt");
      FileInputStream fis = new FileInputStream(fileIz);
      byte[] byteArray = new byte[(int)fileIz.length()];
      fis.read(byteArray);
      String data = new String(byteArray);
      String[] stringArray = data.split("\r\n");
      int otvet = (stringArray.length)/5;
      String otvett = String.valueOf(otvet);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Статистика:");
        alert.setHeaderText("Количество объявлений в избранном у пользователя:");
        alert.setContentText(otvett);
 
        alert.showAndWait();  
}
@FXML
private void statistikazajavok() throws FileNotFoundException, IOException{
      File fileIz = new File("src\\rieltorag\\zayavki\\basaO.txt");
      FileInputStream fis = new FileInputStream(fileIz);
      byte[] byteArray = new byte[(int)fileIz.length()];
      fis.read(byteArray);
      String data = new String(byteArray);
      String[] stringArray = data.split("\r\n");
      int otvet = (stringArray.length)/5;
      String otvett = String.valueOf(otvet);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Статистика:");
        alert.setHeaderText("Количество объявлений в системе:");
        alert.setContentText(otvett);
 
        alert.showAndWait();  
}
@FXML
private void deleteob() throws IOException{
  int selectedIndex = catalogeTable.getSelectionModel().getSelectedIndex();
     if (selectedIndex >= 0){
        catalogeTable.getItems().remove(selectedIndex);
    }else{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Не выбрано объявление");
        alert.setContentText("Выберите объявление в каталоге.");
 
        alert.showAndWait();
    }
    
 catalogeTable.getItems().remove(selectedIndex);
}
@FXML
private void poiskgoroda(){
KatalogZa katalogza = catalogeTable3.getSelectionModel().getSelectedItem();
System.out.println(katalogza.getZGorod());
double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    BufferedReader br;
    String inputSearch = katalogza.getZGorod();
    String line = "";

    try {
        br = new BufferedReader(new FileReader("src\\rieltorag\\zayavki\\basaO.txt"));
        try {
            while((line = br.readLine()) != null)
            {
                countLine = countLine + 1;

                  if (line.equals(inputSearch)) {
                    count = count + 1;
                    countBuffer = countBuffer + 1;
                  }
                

                if(countBuffer > 0)
                {
                    lineNumber += Math.round((countLine+1)/5) + ";";
                    countBuffer = 0;
                }

            }    
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    if (lineNumber.equalsIgnoreCase("")){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("К сожалению, интересующих вас заявок не найдено");
        alert.setContentText("Попробуйте поискать в каталоге объявлений");
        alert.showAndWait();    
    } else {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("Обратите внимание на объявление/объявления:");
        alert.setContentText(lineNumber);
        alert.showAndWait();
    }
}
@FXML
private void poiskobjekta(){
KatalogZa katalogza = catalogeTable3.getSelectionModel().getSelectedItem();
System.out.println(katalogza.getZRajon());
double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    BufferedReader br;
    String inputSearch = katalogza.getZRajon();
    String line = "";

    try {
        br = new BufferedReader(new FileReader("src\\rieltorag\\zayavki\\basaO.txt"));
        try {
            while((line = br.readLine()) != null)
            {
                countLine = countLine + 1;

                  if (line.equals(inputSearch)) {
                    count = count + 1;
                    countBuffer = countBuffer + 1;
                  }
                

                if(countBuffer > 0)
                {
                    lineNumber += Math.round(countLine/5) + ";";
                    countBuffer = 0;
                }

            }    
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {

        e.printStackTrace();
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("Не выбрана заявка");
        alert.setContentText("Выберите заявку из списка ваших заявок.");
        alert.showAndWait(); 
    }
    if (lineNumber.equalsIgnoreCase("")){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("К сожалению, интересующих вас заявок не найдено");
        alert.setContentText("Попробуйте поискать в каталоге объявлений");
        alert.showAndWait();    
    } else {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("Обратите внимание на объявление/объявления:");
        alert.setContentText(lineNumber);
        alert.showAndWait();
    }
}
@FXML
private void poiskPloshadi(){
KatalogZa katalogza = catalogeTable3.getSelectionModel().getSelectedItem();
System.out.println(katalogza.getZPloshad());
double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    BufferedReader br;
    String inputSearch = String.valueOf(katalogza.getZPloshad());
    String line = "";

    try {
        br = new BufferedReader(new FileReader("src\\rieltorag\\zayavki\\basaO.txt"));
        try {
            while((line = br.readLine()) != null)
            {
                countLine = countLine + 1;

                  if (line.equals(inputSearch)) {
                    count = count + 1;
                    countBuffer = countBuffer + 1;
                  }
                

                if(countBuffer > 0)
                {
                    lineNumber += Math.round((countLine+3)/5) + ";";
                    countBuffer = 0;
                }

            }    
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    if (lineNumber.equalsIgnoreCase("")){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("К сожалению, интересующих вас заявок не найдено");
        alert.setContentText("Попробуйте поискать в каталоге объявлений");
        alert.showAndWait();    
    } else {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("Обратите внимание на объявление/объявления:");
        alert.setContentText(lineNumber);
        alert.showAndWait();
    }
}
@FXML
private void poiskstoimosti(){
KatalogZa katalogza = catalogeTable3.getSelectionModel().getSelectedItem();
System.out.println(katalogza.getZPloshad());
double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    BufferedReader br;
    String inputSearch = String.valueOf(katalogza.getZArenda());
    String line = "";

    try {
        br = new BufferedReader(new FileReader("src\\rieltorag\\zayavki\\basaO.txt"));
        try {
            while((line = br.readLine()) != null)
            {
                countLine = countLine + 1;

                  if (line.equals(inputSearch)) {
                    count = count + 1;
                    countBuffer = countBuffer + 1;
                  }
                

                if(countBuffer > 0)
                {
                    lineNumber += Math.round(countLine/5) + ";";
                    countBuffer = 0;
                }

            }    
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    if (lineNumber.equalsIgnoreCase("")){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("К сожалению, интересующих вас заявок не найдено");
        alert.setContentText("Попробуйте поискать в каталоге объявлений");
        alert.showAndWait();    
    } else {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат обработки заявки");
        alert.setHeaderText("Обратите внимание на объявление/объявления:");
        alert.setContentText(lineNumber);
        alert.showAndWait();
    }
}
@FXML
private void pomoch() throws IOException{
File file = new File("src\\rieltorag\\pom.txt");
java.awt.Desktop.getDesktop().edit(file);    
}

@FXML
private void smenaP() throws IOException{
 User.id = User.id + 1;
 Stage stage = new Stage();
    stage.setTitle("Вход в аккаунт");
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    Stage stage1 = (Stage) smena.getScene().getWindow();
    stage1.close();    
}

@FXML
private void opril(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О приложении");
        alert.setHeaderText("Приложение RieltorAg 1.0.0");
        alert.setContentText("Система “Риэлторское агентство” – это информационная система, которая будет разработана с учётом всех современнейших технологий и актуальных тенденций. Система должна перенести весь функционал классического, “чистого” риэлторского агентства в цифровое пространство, не забывая о всех нюансах и особенностях дистанционного оказания услуг. В основу системы ляжет образец самых первых российских дореволюционных риэлторских агентств – компаний, которые оказывали исключительно посреднические услуги с недвижимостью – подыскивали удовлетворяющие требования квартиросъёмщиков варианты помещений и помогали найти клиентов арендодателям.");
        alert.showAndWait();
}

}