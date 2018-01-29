package com.qing.codec;

import java.io.InputStream;

import org.apache.commons.codec.binary.Hex;

/**
 * 数字证书测试用例
 *
 * @author qing
 */
public class CertificateCoderTest {
    //生成证书时的密码
    private static String password = "123456";
    //别名
    private static String alias = "www.dominic.com";
    //证书路径
    private static String certificatePath = "D:\\Program Files\\OpenSSL-Win32\\ca\\certs\\dominic.cer";
    //密钥库路径
    private static String keyStorePath = "D:\\Program Files\\OpenSSL-Win32\\ca\\certs\\domini.keystore";

    /**
     * 公钥加密私钥解密
     */
    public static void test1() throws Exception {
        String inputStr = "数字证书";
        byte[] data = inputStr.getBytes();
        //公钥加密
        byte[] encrypt = CertificateCoder.encryptByPublicKey(data, certificatePath);
        //私钥解密
        byte[] decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
        System.out.println(new String(decrypt).equals(inputStr));
    }

    /**
     * 私加密公钥解密
     */
    public static void test2() throws Exception {
        String inputStr = "数字证书";
        byte[] data = inputStr.getBytes();
        //私钥加密
        byte[] encrypt = CertificateCoder.encryptByPrivateKey(data, keyStorePath, alias, password);
        //公钥解密
        byte[] decrypt = CertificateCoder.decryptByPublicKey(encrypt, certificatePath);
        System.out.println(new String(decrypt).equals(inputStr));
    }

    /**
     * 签名验证
     */
    public static void test3() throws Exception {
        String inputStr = "数字签名";
        byte[] data = inputStr.getBytes();
        //私钥签名
        byte[] sign = CertificateCoder.sign(data, keyStorePath, alias, password);
        System.out.println("签名:" + Hex.encodeHexString(sign));
        //公钥验证
        System.out.println(CertificateCoder.verify(data, sign, certificatePath));
    }

    public static void main(String[] args) throws Exception {
        CertificateCoderTest.test1();
        CertificateCoderTest.test2();
        CertificateCoderTest.test3();
    }
}
	