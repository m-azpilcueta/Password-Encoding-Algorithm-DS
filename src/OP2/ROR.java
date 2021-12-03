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
public class ROR extends Rotate implements IOperation {

    // Call the rotRight operation
    @Override
    public String encodeOperation(String passwd, Parameter p) {
        return this.rotRight(passwd, Integer.parseInt(p.getFst()));
    }

    // Call the rotLeft operation, which is the inverse of rotRight
    @Override
    public String decodeOperation(String coded, Parameter p) {
        return this.rotLeft(coded, Integer.parseInt(p.getFst()));
    }
}
