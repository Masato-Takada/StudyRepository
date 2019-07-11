/********************
 * DAOクラス.
 *
 * @author m-takada
 ********************/
package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Login;
import util.DBConnecter;

public class LoginDAO {
    public Login select(String name, String password) throws SQLException {
        Login dto = new Login();
        DBConnecter db = new DBConnecter();
        Connection con = db.getConnection();
        String sql = "select * from usermaster where UserID=? and PassWord=?";

        try {
            // 暗号化
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(password.getBytes());
            String md5 = String.format("%32x", new BigInteger(1, result));

            // 問い合わせ
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, md5);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto.setUserid(rs.getString("UserID"));
                dto.setPassword(rs.getString("PassWord"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return dto;
    }
}
