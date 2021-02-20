package com.andy.codeCollector;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2020/5/10 </p>
 */
public class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALUZbcVfk7QShVXK2bFzRFlRQ4M2YAc3LxeNqscwlA8M3Zv5QUjPBqw2kRYUiP7LKSr5tW8w5eJc1YYvs0sS5fI8vqj+dG8erMryou8chIyX3HcKnRnfPfbG4OL3VNw/45/Jjdb2HaUNisl8yCGcSO6P8KK7z+FUEw8j2uR/K2cnAgMBAAECgYEAo0ouZAztzSv19YlWCF56fl57lU/t/hOP7pjaJ4hxt7BOEVkJuHCS/6yj3VjevX7Ju+oz4fIhFZ3HGZrg+wwrMF0/vG3CrK/7KgvFruf+VdglPoG0Bq3NlCIgsdBIqrWcI6M/5AQ8LO3i1PB55aeiP67j/JTFR2Vd+lcDyGNsriECQQDw5fJNvs8/mz1xyWW2AVlBt97x79+yMFD2YkFsqr1EgZeq/xlqa4m3qvLMZc4WYXrpFJzy1lxObgtX7haqeuNFAkEAwHPM1IPPg60xNtJitw1JYqz6fpgnVN/Amy/1QN4GhWDHVEd8s0qdDP1xBfWT/0+Vis4t2KHIWcmvH4uOiCAxewJALcNhLofLE0hIee9KlTLYY/WsMsXg9xbaqpOr3hrpbbQ4vdFMYL0hInUlPtMwPWwzT0gNMMysKHIbUY73W1eRCQJAdbbe9KXjCfGnhpbM1paD6p1PYpuCg0GRN9rvskubxX1arsxDFA9xXH6w4SpC6gktuQc/t5/NQk5AlZTxC4ZVfQJAGH4EJZ82nMvZ4T+4K3iE+Djuf3H9ngloVqXWeR0U7UhkLfLI9/v4ZSA0JJqQy5j/enxovTvckL2qdjue2H2dwQ==";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1GW3FX5O0EoVVytmxc0RZUUODNmAHNy8XjarHMJQPDN2b+UFIzwasNpEWFIj+yykq+bVvMOXiXNWGL7NLEuXyPL6o/nRvHqzK8qLvHISMl9x3Cp0Z3z32xuDi91TcP+OfyY3W9h2lDYrJfMghnEjuj/Ciu8/hVBMPI9rkfytnJwIDAQAB";


        String test = "真的吗";

        String bbb = null;
        try {
//            String aaaaa= encryptByPublicKey(test, publicKey);
            String aaaaa = "ZG7YMOTuHiSw2ftVOhqnQrC38tfAShQqU36K4XUEP5WE6wnWO6zyf1jTaTwlMovMtjp4Kl9hRfvzdg8yW7aOtqL/BRHU6aoShFRxeDHHLYgr/GXv4M1OLPlvxvxKRMcgEGus+0nAiCOPCwTkY12F/sC3yviu3H0UvDcBd0StydM=";


            System.out.println("加密信息为: " + aaaaa);
            bbb = decryptByPrivateKey(aaaaa, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("解密：   " + bbb);


//        System.out.println("解密信息为: "+ Base64.encodeBase64String(bytes));


    }


    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 密钥
     * @return byte[] 加密数据
     */
    public static String encryptByPublicKey(String data, String publicKey) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * 私钥解密
     *
     * @param data        待解密数据
     * @param privateKeys 密钥
     * @return byte[] 解密数据
     */
    public static String decryptByPrivateKey(String data, String privateKeys) throws Exception {
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeys));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

}
