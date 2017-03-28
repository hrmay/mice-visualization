/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication2;

import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import java.io.DataInputStream;

/**
 *
 * @author Evan
 */
public class test {
    public static void test() {
        // Create an instance of the PythonInterpreter
            PythonInterpreter interp = new PythonInterpreter();
            
            interp.exec("x = 1 + 3");
            PyObject x = interp.get("x");
            
            System.out.println("x = " + x);
    }
}