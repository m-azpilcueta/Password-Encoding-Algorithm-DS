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
public class Parameter {

    private String op, fst, snd;

    public String getOp() {
        return op;
    }

    public String getFst() {
        return fst;
    }

    public String getSnd() {
        return snd;
    }

    // Extract the set of parameters stored in a given operation
    // If the operation does not have second parameter, assign it to null
    public void extractParameters(String operation) {
        this.op = operation.substring(0, 3);
        this.fst = operation.substring(4, 5);
        try {
            this.snd = operation.substring(6, 7);
        } catch (IndexOutOfBoundsException e) {
            this.snd = null;
        }
    }
}
