/**************************
 * メッセージ暗号化クラス.
 *
 * @author m-takada
 **************************/
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageEncryption {

    /*********************************
     * MD5 暗号化処理.
     *
     * @param Message 暗号対象文字列
     *********************************/
    public String getEncryption(String Message) {
        String MD5Message = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(Message.getBytes());
            MD5Message = String.format("%32x", new BigInteger(1, result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return MD5Message;
    }
}
