/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OP2;

import java.util.List;

/**
 *
 * @author martin
 */
public class Scrambler {

    public String encodePassword(String input, List<String> operations) {
        IOperation op;
        Parameter p;
        Factory f;
        // Check if the operation list or the input are empty
        if (operations.isEmpty() | input.isEmpty()) {
            return input;
        } else {
            p = new Parameter();
            f = new Factory();
            // Traverse the list executing the operations
            for (int i = 0; i < operations.size(); i++) {
                p.extractParameters(operations.get(i)); // Extract the parameters from the operation
                op = f.createOperation(p.getOp()); // Return a new "IOperation" object
                input = op.encodeOperation(input, p); // Call the encode method inside the returned object
            }
            return input;
        }
    }

    public String decodePassword(String input, List<String> operations) {
        IOperation op;
        Parameter p;
        Factory f;
        // Check if the operation list or the input are empty
        if (operations.isEmpty() | input.isEmpty()) {
            return input;
        } else {
            p = new Parameter();
            f = new Factory();
            // Traverse the list executing the operations
            for (int i = operations.size() - 1; i >= 0; i--) {
                p.extractParameters(operations.get(i)); // Extract the parameters from the operation
                op = f.createOperation(p.getOp()); // Return a new "IOperation" object
                input = op.decodeOperation(input, p); // Call the decode method inside the returned object
            }
            return input;
        }
    }
}
