package edu.ntust.cs.idsl.test.asymmetric;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import edu.ntust.cs.idsl.main.asymmetric.DSA;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class DSATest {
    
    private byte[] publicKey;
    private byte[] privateKey;

    @Before
    public void initKey() throws Exception {
        Map<String, Object> keyMap = DSA.generateKeyPair();
        publicKey = DSA.getPublicKey(keyMap);
        privateKey = DSA.getPrivateKey(keyMap);
        System.err.println("Public key: \n" + Base64.encodeBase64String(publicKey));
        System.err.println("Private key： \n" + Base64.encodeBase64String(privateKey));
    }

    @Test
    public void test() throws Exception {

        String message = "DSA";
        byte[] data = message.getBytes();

        // sign
        byte[] sign = DSA.sign(data, privateKey);
        System.err.println("\nSignature: " + Hex.encodeHexString(sign));

        // verify
        boolean status = DSA.verify(data, publicKey, sign);
        System.err.println("Status: " + status);
        assertTrue(status);
    }

}
