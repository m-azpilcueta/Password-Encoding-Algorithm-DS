/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OP2;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martin
 */
public class ScramblerTest {

    public static List<String> operations = Arrays.asList("SWP 4 0", "SWL d b", "REP 0 4", "ROL 1", "MOP 1 4", "ROR 3");
    public static List<String> operations2 = Arrays.asList("MOP 2 5", "SWL z a", "SWP 7 1", "ROL 7", "ROR 2", "REP 0 8");

    @Test
    public void encodePassword() {
        Scrambler scrambler = new Scrambler();
        assertEquals("eacbd", scrambler.encodePassword("abcde", operations));
    }

    @Test
    public void decodePassword() {
        Scrambler scrambler = new Scrambler();
        assertEquals("abcde", scrambler.decodePassword("eacbd", operations));
    }

    @Test
    public void encodePassword2() {
        Scrambler scrambler = new Scrambler();
        assertEquals("relpzepop", scrambler.encodePassword("applerope", operations2));
    }

    @Test
    public void decodePassword2() {
        Scrambler scrambler = new Scrambler();
        assertEquals("applerope", scrambler.decodePassword("relpzepop", operations2));
    }

    @Test
    public void encodeSWP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("eivrr", scrambler.encodePassword("river", Arrays.asList("SWP 0 3")));
    }

    @Test
    public void decodeSWP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("river", scrambler.decodePassword("eivrr", Arrays.asList("SWP 0 3")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void encode2SWP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("river", scrambler.encodePassword("river", Arrays.asList("SWP 0 7")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void decode2SWP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("river", scrambler.decodePassword("river", Arrays.asList("SWP 0 7")));
    }

    @Test
    public void encodeSWL() {
        Scrambler scrambler = new Scrambler();
        assertEquals("wvateher", scrambler.encodePassword("whatever", Arrays.asList("SWL h v")));
    }

    @Test
    public void decodeSWL() {
        Scrambler scrambler = new Scrambler();
        assertEquals("whatever", scrambler.decodePassword("wvateher", Arrays.asList("SWL h v")));
    }

    @Test
    public void encodeROL() {
        Scrambler scrambler = new Scrambler();
        assertEquals("shingfi", scrambler.encodePassword("fishing", Arrays.asList("ROL 9")));
    }

    @Test
    public void decodeROL() {
        Scrambler scrambler = new Scrambler();
        assertEquals("fishing", scrambler.decodePassword("shingfi", Arrays.asList("ROL 9")));
    }

    @Test
    public void encodeROR() {
        Scrambler scrambler = new Scrambler();
        assertEquals("npokemo", scrambler.encodePassword("pokemon", Arrays.asList("ROR 8")));
    }

    @Test
    public void decodeROR() {
        Scrambler scrambler = new Scrambler();
        assertEquals("pokemon", scrambler.decodePassword("npokemo", Arrays.asList("ROR 8")));
    }

    @Test
    public void encodeREP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("pulpre", scrambler.encodePassword("purple", Arrays.asList("REP 2 4")));
    }

    @Test
    public void decodeREP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("purple", scrambler.decodePassword("pulpre", Arrays.asList("REP 2 4")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void encode2REP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("purple", scrambler.encodePassword("purple", Arrays.asList("REP 2 7")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void decode2REP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("purple", scrambler.decodePassword("purple", Arrays.asList("REP 2 7")));
    }

    @Test
    public void encodeMOP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("qwrtye", scrambler.encodePassword("qwerty", Arrays.asList("MOP 2 5")));
    }

    @Test
    public void decodeMOP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("qwerty", scrambler.decodePassword("qwrtye", Arrays.asList("MOP 2 5")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void encode2MOP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("qwerty", scrambler.encodePassword("qwerty", Arrays.asList("MOP 2 7")));
    }

    // IndexOutOfBounds. Do not perform 
    @Test
    public void decode2MOP() {
        Scrambler scrambler = new Scrambler();
        assertEquals("qwerty", scrambler.decodePassword("qwerty", Arrays.asList("MOP 2 7")));
    }

    // Other exceptions
    // Try to enconde an operation that has not been defined yet
    @Test(expected = NullPointerException.class)
    public void nonExistingOperation() {
        Scrambler scrambler = new Scrambler();
        scrambler.encodePassword("abcde", Arrays.asList("STT 4 5"));
    }

    // Empty operations
    @Test
    public void emptyOperations() {
        Scrambler scrambler = new Scrambler();
        assertEquals("abcde", scrambler.encodePassword("abcde", Arrays.asList()));
        assertEquals("abcde", scrambler.decodePassword("abcde", Arrays.asList()));
    }
    
    // Empty password
    @Test
    public void emptyPassword() {
        Scrambler scrambler = new Scrambler();
        assertEquals("", scrambler.encodePassword("", Arrays.asList("MOP 1 4")));
        assertEquals("", scrambler.decodePassword("", Arrays.asList("MOP 1 4")));
    }
}
