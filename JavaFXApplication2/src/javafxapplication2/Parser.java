package javafxapplication2;

import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Evan
 */
public class Parser {
    
    private PyList mice;
    
    public void Parser() {
    }
    
    public PyObject parse(String dataset) throws FileNotFoundException, IOException{
        //Open python interpeter
        PythonInterpreter interp = new PythonInterpreter();
        
        //Send file to be read to the python parser
        interp.set("dataset", new PyString(dataset));
        
        //Execute the python parser
        interp.execfile("./src/javafxapplication2/python/parser.py");
        
        //Grab the parsed data from python
        PyObject pyData = interp.get("data");
        PyList pyMice = new PyList(interp.get("mice"));
        
       // String[][] data = (String[][]) new PyList(interp.get("data")).toArray(new String[0][0]);
        mice =  new PyList(interp.get("mice"));
        
        
        //System.out.println(data);
        System.out.println(mice);

        return pyData;
    }
    
    public String[] getMice() {
        String[] miceArray = (String[]) mice.toArray(new String[0]);
        return miceArray;
    }
}
