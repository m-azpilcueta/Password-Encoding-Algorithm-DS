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
public interface IOperation {

    String encodeOperation(String password, Parameter parameters);

    // For some operations, the encode and decode process is the same. 
    // In these cases, the method will use the default implementation, which 
    // essentially calls the encode method again.
    default String decodeOperation(String password, Parameter parameters) {
        return encodeOperation(password, parameters);
    }
}
