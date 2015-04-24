package edu.ntust.cs.idsl.test.asymmetric;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import edu.ntust.cs.idsl.main.asymmetric.RSA;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class RSATest {

    private byte[] publicKey;
    private byte[] privateKey;

    @Before
    public void generateKeyPair() throws Exception {
        Map<String, Object> keyMap = RSA.generateKeyPair();
        publicKey = RSA.getPublicKey(keyMap);
        privateKey = RSA.getPrivateKey(keyMap);
        System.err.println("Public key: \n" + Base64.encodeBase64String(publicKey));
        System.err.println("Private key： \n" + Base64.encodeBase64String(privateKey));
    }

    @Test
    public void test() throws Exception {
        System.err.println("\n--- Using public key to encrypt and private key to decrypt ---");
        String inputString2 = "RSA";
        byte[] data2 = inputString2.getBytes();
        System.err.println("Plaintext: " + inputString2);

        // encrypt
        byte[] encodedData2 = RSA.encryptByPublicKey(data2, publicKey);
        System.err.println("After encryption: " + Base64.encodeBase64String(encodedData2));

        // decrypt
        byte[] decodedData2 = RSA.decryptByPrivateKey(encodedData2, privateKey);
        String outputStr2 = new String(decodedData2);
        System.err.println("After decryption: " + outputStr2);

        // test result
        assertEquals(inputString2, outputStr2);
        
        
        System.err.println("\n--- Using private key to encrypt and public key to decrypt ---");
        String inputString1 = "RSA";
        byte[] inputData1 = inputString1.getBytes();
        System.err.println("Plaintext: " + inputString1);

        // encrypt
        inputData1 = RSA.encryptByPrivateKey(inputData1, privateKey);
        System.err.println("After encryption: " + Base64.encodeBase64String(inputData1));

        // decrypt
        byte[] outputData1 = RSA.decryptByPublicKey(inputData1, publicKey);
        String outputString1 = new String(outputData1);
        System.err.println("After decryption: " + outputString1);

        // test result
        assertEquals(inputString1, outputString1);
    }
    
}
