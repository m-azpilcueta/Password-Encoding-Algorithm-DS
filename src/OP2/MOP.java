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
public class MOP implements IOperation {

    // Internal:
    // Removes the char at position x and inserts it in the new position y
    // returning the resulting string
    // In case a parameter is not valid, output the resulting exception
    private String doMOP(String passwd, int x, int y) {
        try {
            StringBuilder str = new StringBuilder(passwd).deleteCharAt(x);
            char toMove = passwd.charAt(x);
            str.insert(y, toMove);
            return str.toString();
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            return passwd;
        }
    }

    @Override
    public String encodeOperation(String passwd, Parameter p) {
        return this.doMOP(passwd, Integer.parseInt(p.getFst()), Integer.parseInt(p.getSnd()));
    }

    @Override
    public String decodeOperation(String coded, Parameter p) {
        return this.doMOP(coded, Integer.parseInt(p.getSnd()), Integer.parseInt(p.getFst()));
    }
}
