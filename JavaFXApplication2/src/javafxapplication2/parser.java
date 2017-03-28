/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyString;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import java.io.*;


/**
 *
 * @author Evan
 */
public class parser {
    public static String[][] parse(String dataset) throws FileNotFoundException, IOException{
        //Open python interpeter
        PythonInterpreter interp = new PythonInterpreter();
        String[][] data = new String[10][10];
        
        //Send file to be read to the python parser
        interp.set("dataset", new PyString(dataset));
        
        //Execute the python parser
        interp.execfile("./src/javafxapplication2/python/parser.py");
        
        //Grab the parsed data from python
        PyObject pyData = interp.get("data");
        System.out.println(pyData);

        return data;
    }
}
