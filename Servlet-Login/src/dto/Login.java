/********************
 * ログインDTO.
 *
 * @author m-takada
 ********************/
package dto;

public class Login {
    private String userid;
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String name) {
        this.userid = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}