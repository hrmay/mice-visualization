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
import javafx.scene.control.Label;
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
    @FXML
    private String currentFileName;
    
    
    /* Buttons that are involved wsith saving */
    @FXML
    private Button saveButton; /* Save button on the main app window */
    @FXML
    private Button save; /* Save button on the SavePopUp Window */
    @FXML
    private Button cancelSave; /* Cancel button on the SavePopUP Window */
    @FXML
    private TextField saveNameField; /*  */
    @FXML
    private Label saveFileName; /*  */
    
      /* The SavePopUp window */
                Stage saveStage;
                /* design for the stage */
                Parent root;

    
    /* Stage for the File Explorer window when loading a new file */
    @FXML
    private Window stage;
    
    
    public void setFile(File currentFile){
        this.currentFile = currentFile;
    }
    
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
            
            if(currentFile != null){
                //System.out.println(currentFile.getName());
             
                //saveWindowPopUp(event); /* Method handles save */ 
                        
              
                //System.out.println("ASDF " + currentFile.getPath());
            
                /* Create a new stage for the SavePopUp */
                saveStage=new Stage();
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaveWindow.fxml"));
                
                /* Get the design for the SavePopUp from the SaveWindow.fxml file
                    and set it to root */
                root =(Parent) fxmlLoader.load();
                
                /* set the pop up scene to the design from root */
                saveStage.setScene(new Scene(root));

                FXMLDocumentController controller = fxmlLoader.getController(); 
                
                controller.setFile(currentFile);
                
                /* initializes pop up functionality */
                saveStage.initModality(Modality.APPLICATION_MODAL);

                /* sets the owner of the stage to the main window save button */
                saveStage.initOwner(saveButton.getScene().getWindow());

                /* Shows the pop up to the user and waits until they have closed
                    it out */
                saveStage.showAndWait();

                //saveNameField = new TextField();
                //saveNameField.setText(currentFile.getName());
                    //System.out.println("Check me out");

        
            }else{
                System.out.println("No File to save");
            }
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

        
        /* If the "Save" button was pressed in the SavePopUp */
        if(event.getSource()==save){
            
            System.out.println("Saving " + saveNameField.getText());
                
                String filePath = currentFile.getPath();
               
        //        System.out.println(filePath);
                String fileName = saveNameField.getText();
                //System.out.println(fileName);
                    
                //String toWrite = fileName + "; " + filePath;
                //System.out.println(fileName + "; " + filePath);    
            /**/
            try {
                
                BufferedWriter writer = new BufferedWriter (new FileWriter(".\\savedData.txt"));
                String toWrite = "Mic check 1 2 1 2";
                writer.write(toWrite);
                writer.close();
                
            } catch(IOException e){
            
            }              
            /* Set the save stage to the pop up */
            saveStage=(Stage) save.getScene().getWindow();            
            /* Close the pop up */
            saveStage.close();
        }
        
        /* If the "Cancel" button was pressed in the SavePopUp */
        else{
            
            System.out.println("Closing save window");
            
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
        //currentFileName = currentFile.getName();
        System.out.println(currentFile.getName());
        System.out.println(currentFile.getPath());
        
        /* Gets the file path of the file */
        //String dataPath = file.getPath();
        
        //parser.parse(file);
        
        /* Gives the file path to the parser
            Parses the data
            Stores the parsed data into a array of strings */
        //String[][] dataArray = parser.parse(dataPath);

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
