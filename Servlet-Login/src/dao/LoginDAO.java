/********************
 * ログインDAOクラス.
 *
 * @author m-takada
 ********************/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import util.DBConnecter;
import util.MessageEncryption;

public class LoginDAO {
    /******************************
     * ログイン認証処理.
     *
     * @param name ユーザーID
     * @param password パスワード
     ******************************/
    public User select(String name, String password) throws SQLException {
        User dto = new User();
        DBConnecter db = new DBConnecter();
        Connection con = db.getConnection();
        String sql = "select * from usermaster where UserID=? and PassWord=?";

        try {
            // 暗号化
            MessageEncryption mesencryption = new MessageEncryption();
            String md5 = mesencryption.getEncryption(password);

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
        } finally {
            con.close();
        }
        return dto;
    }
}
