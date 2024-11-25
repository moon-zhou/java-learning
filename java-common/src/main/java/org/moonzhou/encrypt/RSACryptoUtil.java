package org.moonzhou.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class RSACryptoUtil {

    private static final String RSA = "RSA";

    public static void main(String[] args) throws Exception {
        // 生成RSA密钥对
        KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 打印公钥和私钥信息
        System.out.println("Public Key: " + publicKey);
        System.out.println("Private Key: " + privateKey);

        // 原始数据
        String data = "Hello, RSA encryption!";
        System.out.println("Original data: " + data);

        // 加密数据
        byte[] encryptedData = encrypt(publicKey, data.getBytes());
        System.out.println();
        System.out.println("Encrypted data: " + new String(encryptedData));
        System.out.println();

        // 解密数据
        byte[] decryptedData = decrypt(privateKey, encryptedData);
        System.out.println("Decrypted data: " + new String(decryptedData));
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA);
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public static byte[] encrypt(PublicKey publicKey, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(PrivateKey privateKey, byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedData);
    }
}
