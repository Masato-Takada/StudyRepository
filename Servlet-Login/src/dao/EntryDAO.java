/********************
 * 登録DAOクラス.
 *
 * @author m-takada
 ********************/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnecter;
import util.MessageEncryption;

public class EntryDAO {
    /******************************
     * 登録処理.
     *
     * @param name ユーザーID
     * @param password パスワード
     ******************************/
    public int Insert(String name, String password) throws SQLException {
        int result = -1;
        DBConnecter db = new DBConnecter();
        Connection con = db.getConnection();
        String sql = "insert into usermaster values (?, ?)";
        try {
            // 暗号化
            MessageEncryption mesencryption = new MessageEncryption();
            String md5 = mesencryption.getEncryption(password);

            // 問い合わせ
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, md5);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }

        return result;
    }

}
