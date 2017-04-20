package javafxapplication2;

import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.simple.*;


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
        PyObject pyData = interp.get("newData");
        PyList pyMice = new PyList(interp.get("mice"));
        
        // String[][] data = (String[][]) new PyList(interp.get("data")).toArray(new String[0][0]);
        mice =  new PyList(interp.get("mice"));
       
        return pyData;
    }
    
    public PyObject filter(PyObject data, String[] mice) {
        //Open python interpeter
        PythonInterpreter interp = new PythonInterpreter();
        //Set variables needed by the filter
        interp.set("data", data);
        interp.set("mice", new PyList(Arrays.asList(mice)));
        
        //Execute the python filter
        interp.execfile("./src/javafxapplication2/python/filter.py");
        
        PyObject pyData = interp.get("heatmapData");
        /*
        PyObject[] heatData = (PyObject[]) pyData.__tojava__(PyObject[].class);
        int[] heatmapData = new int[4];
        System.out.println(heatData);
        
        for (PyObject item : heatData) {
            System.out.println(item);
            //int[] values = (int[]) item.__tojava__(int[].class);
            
        }
        */
        
        return pyData;
    }
    
    public String[] getMice() {
        //String[] miceArray = (String[]) mice.toArray(new String[0]);
        String[] miceArray = (String[]) mice.__tojava__(String[].class);
        return miceArray;
    }
}
