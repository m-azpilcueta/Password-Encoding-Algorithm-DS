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
public class SWL implements IOperation {

    // Swaps letters in a string. Uses the * char as a temporary placeholder to make the swap
    // Since the only valid chars for the password is the english alphabet,
    // it won't cause any trouble
    @Override
    public String encodeOperation(String passwd, Parameter p) {
        return passwd.replace(p.getFst().charAt(0), '*').replace(p.getSnd().charAt(0), p.getFst().charAt(0))
                .replace('*', p.getSnd().charAt(0));
    }
}
