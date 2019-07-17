package cn.pawn.ratel.shiroconfig;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestMD5Encoder
 * @Description TODO
 * @author zengyejun
 * @date 2019-07-17 10:47:47
 **/
public class TestMD5Encoder {
    private static Map<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(Md5Encoder.getEncryptedPwd("12345"));
//        String userName = "zyg";
//        String password = "123";
//        registerUser(userName, password);
//
//        userName = "changong";
//        password = "456";
//        registerUser(userName, password);
//
//        String loginUserId = "changong";
//        String pwd = "456";
//        try {
//            if (loginValid(loginUserId, pwd)) {
//                System.out.println("欢迎登陆！！！");
//            } else {
//                System.out.println("口令错误，请重新输入！！！");
//            }
//        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    /**
     * 注册用户
     *
     * @param userName
     * @param password
     */
    public static void registerUser(String userName, String password) {
        String encryptedPwd;
        try {
            encryptedPwd = Md5Encoder.getEncryptedPwd(password);
System.out.println(encryptedPwd);
            users.put(userName, encryptedPwd);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 验证登陆
     *
     * @param userName
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean loginValid(String userName, String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String pwdInDb = users.get(userName);
        if (null != pwdInDb) { // 该用户存在
            return Md5Encoder.validPassword(password, pwdInDb);
        } else {
            System.out.println("不存在该用户！！！");
            return false;
        }
    }
}
