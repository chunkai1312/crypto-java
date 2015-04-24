package edu.ntust.cs.idsl.test.symmetric;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import edu.ntust.cs.idsl.main.symmetric.AES;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class AESTest {

    private byte[] key;
    
    @Before
    public void generateKey() throws Exception {
        key = AES.generateKey();
        System.err.println("Key: " + Base64.encodeBase64String(key));        
    }
    
    @Test
    public void test() throws Exception {
        String inputString = "AES";
        byte[] inputData = inputString.getBytes();
        System.err.println("Plaintext: " + inputString);

        // encrypt
        inputData = AES.encrypt(inputData, key);
        System.err.println("After encryption: " + Base64.encodeBase64String(inputData));

        // decrypt
        byte[] outputData = AES.decrypt(inputData, key);
        String outputString = new String(outputData);
        System.err.println("After decryption: " + outputString);

        // test result
        assertEquals(inputString, outputString);
    }
    
}
