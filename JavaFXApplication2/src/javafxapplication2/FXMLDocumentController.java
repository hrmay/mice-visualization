/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Nate
 */
public class FXMLDocumentController implements Initializable {
    
    /* Load button on main app window */
    @FXML
    private Button loadButton;
    private File currentFile;
    
    /* Buttons that are involved with saving */
    @FXML
    private Button saveButton; /* Save button on the main app window */
    @FXML
    private Button save; /* Save button on the SavePopUp Window */
    @FXML
    private Button cancelSave; /* Cancel button on the SavePopUP Window */
    @FXML
    private TextField saveNameField; /* */
    
    /* Stage for the File Explorer window when loading a new file */
    @FXML
    private Window stage;
        
    /* Handles the functionality of buttons on the main app window */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        //System.out.println(event.getSource().toString());
       
        /* If the "Load" button on the main window was pressed */
        if(event.getSource()==loadButton){
            //System.out.println("You are about to load some data BOI!");
            loadData(); /* Method handles load */
        }
        
        /* If the "Save" button on the main window was pressed */
        else if(event.getSource()==saveButton){
            //System.out.println("Saving Stuff");
            saveWindowPopUp(event); /* Method handles save */
        }
        /*
        else if(event.getSource()==generateButton){
            System.out.println("Generating Map!!!!");
            
        }
        else{
            System.out.println("....");
        
        }*/
    //    label.setText("Hello World!");
    }
    
    /* Opens the SavePopUp Window and handles all events that occur in that 
        window */
    @FXML
    private void saveWindowPopUp(ActionEvent event) throws IOException{
        
        /* The SavePopUp window */
        Stage saveStage;
        /* design for the stage */
        Parent root;
        
        /* If the "Save" button was pressed on the main window */
        if(event.getSource()==saveButton){
            
            /* Create a new stage for the SavePopUp */
            saveStage=new Stage();
            
            /* Get the design for the SavePopUp from the SaveWindow.fxml file
                and set it to root */
            root =FXMLLoader.load(getClass().getResource("SaveWindow.fxml"));
            
            /* set the pop up scene to the design from root */
            saveStage.setScene(new Scene(root));
            
            /* initializes pop up functionality */
            saveStage.initModality(Modality.APPLICATION_MODAL);
            
            /* sets the owner of the stage to the main window save button */
            saveStage.initOwner(saveButton.getScene().getWindow());
            
            /* Shows the pop up to the user and waits until they have closed
                it out */
            saveStage.showAndWait();
        }
        
        /* If the "Save" button was pressed in the SavePopUp */
        else if(event.getSource()==save){
            
            /* Set the save stage to the pop up */
            saveStage=(Stage) save.getScene().getWindow();
            
            /**/
            /*try{
                try (BufferedWriter writer = new BufferedWriter (new FileWriter(".\\savedData.txt"))) {
                    String filePath = currentFile.getPath();
                    String fileName = currentFile.getName();
                    
                    saveNameField.setText(fileName);
                    
                    String toWrite = fileName + "; " + filePath;
                    writer.write(toWrite);
                }
                
            }catch(IOException e){
            
            }
                      */  
            /* Close the pop up */
            saveStage.close();
        }
        
        /* If the "Cancel" button was pressed in the SavePopUp */
        else{
            
            /* Set the save stage to the pop up */
            saveStage=(Stage) cancelSave.getScene().getWindow();
            
            /* Close the pop up */
            saveStage.close();
        }
    }
    
    /* Opens the file explorer allowing the user to load their dataset */
    private void loadData() throws FileNotFoundException, IOException{
        //System.out.println("load data method");
        /* Creates a new file chooser object */
        FileChooser fileChooser = new FileChooser();
        
        /* Sets the file chosen in the file chooser to "file" */
        File file = fileChooser.showOpenDialog(stage);
       
        /* stores the file into current file */
        currentFile = file;
        
        /* Gets the file path of the file */
        String dataPath = file.getPath();
        
        //parser.parse(file);
        
        /* Gives the file path to the parser
            Parses the data
            Stores the parsed data into a array of strings */
        String[][] dataArray = parser.parse(dataPath);

        //System.out.println(dataArray[0][1]);
        //if (file.isFile()){
        //    System.out.println(file.getName());
            //System.out.println(file.lastModified());
        //}else{
        //    System.out.println("No file kiddo.");
        //}
        //check to see if a file was loaded properly
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
