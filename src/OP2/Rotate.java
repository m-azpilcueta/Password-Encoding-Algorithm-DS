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
public abstract class Rotate {

    // Common method for string rotation. Extract from the string the chars
    // needed for rotation and add them at the end of the string from where
    // they were extracted
    private String doOP(String passwd, int pos) {
        final String rotation = passwd.substring(pos) + passwd.substring(0, pos);
        return rotation;
    }

    // Calculate the number of rotations and call the doOp method
    protected final String rotLeft(String passwd, int pos) {
        pos = pos % passwd.length();
        return this.doOP(passwd, pos);
    }

    // Calculate the number of rotations and call the doOp method
    protected final String rotRight(String passwd, int pos) {
        final int mod = pos % passwd.length();
        pos = Math.abs(passwd.length() - mod) % passwd.length();
        return this.doOP(passwd, pos);
    }
}
