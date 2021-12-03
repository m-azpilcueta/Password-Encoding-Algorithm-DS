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
public class REP implements IOperation {

    // Extract the part of the password that needs to be reversed, given by the parameters
    // Reverse it and concatenate the string again
    // In case a parameter is not valid, output the resulting exception
    @Override
    public String encodeOperation(String passwd, Parameter p) {
        try {
            String prefix = passwd.substring(0, Integer.parseInt(p.getFst()));
            StringBuilder str = new StringBuilder(passwd.substring(Integer.parseInt(p.getFst()), Integer.parseInt(p.getSnd()) + 1));
            String suffix = passwd.substring(Integer.parseInt(p.getSnd()) + 1, passwd.length());
            return prefix + str.reverse() + suffix;
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            return passwd;
        }
    }
}
