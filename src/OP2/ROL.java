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
public class ROL extends Rotate implements IOperation {

    // Call the rotLeft operation
    @Override
    public String encodeOperation(String passwd, Parameter p) {
        return this.rotLeft(passwd, Integer.parseInt(p.getFst()));
    }

    // Call the rotRight operation, which is the inverse of rotLeft
    @Override
    public String decodeOperation(String coded, Parameter p) {
        return this.rotRight(coded, Integer.parseInt(p.getFst()));
    }
}
