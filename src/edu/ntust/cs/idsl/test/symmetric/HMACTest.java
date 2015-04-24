package edu.ntust.cs.idsl.test.symmetric;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import edu.ntust.cs.idsl.main.symmetric.HMAC;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class HMACTest {

    @Test
    public final void testEncodeHmacMD5() throws Exception {
        String str = "HmacMD5";
        byte[] key = HMAC.generateHmacMD5Key();
        byte[] data1 = HMAC.encodeHmacMD5(str.getBytes(), key);
        byte[] data2 = HMAC.encodeHmacMD5(str.getBytes(), key);
        assertArrayEquals(data1, data2);
    }

    @Test
    public final void testEncodeHmacSHA1() throws Exception {
        String str = "HmacSHA1";
        byte[] key = HMAC.generateHmacSHA1Key();
        byte[] data1 = HMAC.encodeHmacSHA1(str.getBytes(), key);
        byte[] data2 = HMAC.encodeHmacSHA1(str.getBytes(), key);
        assertArrayEquals(data1, data2);
    }

    @Test
    public final void testEncodeHmacSHA256() throws Exception {
        String str = "HmacSHA256";
        byte[] key = HMAC.generateHmacSHA256Key();
        byte[] data1 = HMAC.encodeHmacSHA256(str.getBytes(), key);
        byte[] data2 = HMAC.encodeHmacSHA256(str.getBytes(), key);
        assertArrayEquals(data1, data2);
    }

    @Test
    public final void testEncodeHmacSHA384() throws Exception {
        String str = "HmacSHA384";
        byte[] key = HMAC.generateHmacSHA384Key();
        byte[] data1 = HMAC.encodeHmacSHA384(str.getBytes(), key);
        byte[] data2 = HMAC.encodeHmacSHA384(str.getBytes(), key);      
        assertArrayEquals(data1, data2);
    }

    @Test
    public final void testEncodeHmacSHA512() throws Exception {
        String str = "HmacSHA512";
        byte[] key = HMAC.generateHmacSHA512Key();
        byte[] data1 = HMAC.encodeHmacSHA512(str.getBytes(), key);
        byte[] data2 = HMAC.encodeHmacSHA512(str.getBytes(), key);
        assertArrayEquals(data1, data2);
    }
    
}
