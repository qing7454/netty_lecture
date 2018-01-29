package com.qing.codec;

/**
 * 对称加密算法测试用例
 *
 * @author Administrator
 */
public class AESCoderTest {

    public static void main(String args[]) {
        try {
            //初始化密钥
            String secretKey = AESCoder.initKeyString();
            System.out.println("密钥为:" + secretKey);
            String s = "我们的大中国";
            //加密数据
            byte[] encryptData = AESCoder.encrypt(s.getBytes(), secretKey);
            //解密数据
            byte[] data = AESCoder.decrypt(encryptData, secretKey);
            //比较
            System.out.println(new String(data).equals(s));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
