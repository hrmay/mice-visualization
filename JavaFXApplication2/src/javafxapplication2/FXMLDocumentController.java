/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Nate
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button saveButton;
    @FXML
    private Button save;
    @FXML
    private Button cancelSave;
            
    @FXML
    private Window stage;
        
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
           
        System.out.println(event.getSource().toString());//.contains("loadButton"));
        if(event.getSource()==loadButton){
            System.out.println("You are about to load some data BOI!");
            loadData();
        
        }
        else if(event.getSource()==saveButton){
            
            System.out.println("Saving Stuff");
            saveWindowPopUp(event);
        }
        else if(event.getSource().toString().contains("generateButton")){
            System.out.println("Generating Map!!!!");
            
        }
        else{
            System.out.println("....");
        
        }
    //    label.setText("Hello World!");
    }
    
    @FXML
    private void saveWindowPopUp(ActionEvent event) throws IOException{
        System.out.println("This is where the pop up is suppose to go");
        
        Stage testStage;
        Parent root;
        
        if(event.getSource()==saveButton){
            testStage=new Stage();
            //stage=(Stage) btn1.getScene().getWindow();
            root =FXMLLoader.load(getClass().getResource("SaveWindow.fxml"));
            testStage.setScene(new Scene(root));
            testStage.initModality(Modality.APPLICATION_MODAL);
            testStage.initOwner(saveButton.getScene().getWindow());
            testStage.showAndWait();
        }
        else if(event.getSource()==save){
            testStage=(Stage) save.getScene().getWindow();
            testStage.close();
        }
        else{
            testStage=(Stage) cancelSave.getScene().getWindow();
            testStage.close();
        }
    }
    
    private void loadData() throws FileNotFoundException, IOException{
        System.out.println("load data method");
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        String dataPath = file.getPath();
        
        //parser.parse(file);
        String[][] dataArray = parser.parse(dataPath);

        System.out.println(dataArray[0][1]);
        if (file.isFile()){
            System.out.println(file.getName());
            //System.out.println(file.lastModified());
        }else{
            System.out.println("No file kiddo.");
        }
        //check to see if a file was loaded properly
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
