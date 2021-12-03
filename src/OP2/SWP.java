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
public class SWP implements IOperation {

    // Convert the string password into an array of chars. Use a var temp to make the swap
    // Convert again into string to return the result
    // In case a parameter is not valid, output the resulting exception
    @Override
    public String encodeOperation(String passwd, Parameter p) {
        try {
            char swapper[] = passwd.toCharArray();
            char temp = swapper[Integer.parseInt(p.getFst())];
            swapper[Integer.parseInt(p.getFst())] = swapper[Integer.parseInt(p.getSnd())];
            swapper[Integer.parseInt(p.getSnd())] = temp;
            return String.valueOf(swapper);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            return passwd;
        }
    }
}
