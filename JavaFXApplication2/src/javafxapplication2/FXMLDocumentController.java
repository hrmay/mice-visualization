/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.stage.Window;

/**
 *
 * @author Nate
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button loadButton;
    private Window stage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        System.out.println(event.getSource().toString());//.contains("loadButton"));
        if (event.getSource().toString().contains("loadButton")){
            System.out.println("You are about to load some data BOI!");
            loadData();
        }else if(event.getSource().toString().contains("generateButton")){
            System.out.println("Generating Map!!!!");
        }else{
            System.out.println("....");
        }
    //    label.setText("Hello World!");
    }
    
    private void loadData(){
        System.out.println("load data method");
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        
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
