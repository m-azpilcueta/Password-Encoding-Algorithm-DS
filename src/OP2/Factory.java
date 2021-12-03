/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OP2;

/**
 *
 * @author martin
 */
public class Factory {

    // Instantiate the objects corresponding to the operation passed as parameter
    // to the method. Return the instantiated object (Factory pattern)
    // In case of error, output the resulting exception and return null
    public IOperation createOperation(String operation) {
        IOperation op = null;
        try {
            op = (IOperation) Class.forName("OP2." + operation).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println("Exception: " + e);
        }
        return op;
    }
}
