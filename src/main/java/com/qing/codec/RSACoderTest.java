package com.qing.codec;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA算法测试用例
 *
 * @author qing
 */
public class RSACoderTest {
    //公钥
    private static byte[] publicKey;
    //私钥
    private static byte[] privateKey;

    /**
     * 初始化密钥
     *
     * @throws Exception
     */
    public static void initKey() throws Exception {
        //初始化密钥
        Map<String, Object> keyMap = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.out.println("公钥:" + Base64.encodeBase64String(publicKey));
        System.out.println("私钥:" + Base64.encodeBase64String(privateKey));
    }

    public static void test() throws Exception {
        String inputStr = "RSA加密算法,私钥加密,公钥解密";
        byte[] data = inputStr.getBytes();
        //私钥加密
        byte[] enCodeData = RSACoder.encryptByPrivateKey(data, privateKey);
        System.out.println("加密字符串:" + Base64.encodeBase64String(enCodeData));
        //公钥解密
        byte[] deCodeData = RSACoder.decryptByPublicKey(enCodeData, publicKey);
        System.out.println(new String(deCodeData).equals(inputStr));
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        initKey();
        RSACoderTest.test();
    }

}
    