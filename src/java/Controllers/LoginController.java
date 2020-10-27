/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataBaseConnector.Connector;
import Models.User;
import java.sql.ResultSet;

/**
 *
 * @author Roshan Withanage
 */
public class LoginController {

    Connector con = Connector.getInstance();
    User user = new User();

    private LoginController() {
    }

    private static final LoginController obj = new LoginController();

    public static LoginController getInstance() {
        return obj;
    }

    public User Login(String username, String password) throws Exception {
        int count = 0;
        con.getConnection();
        ResultSet rs = con.srh("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
        if (rs.next()) {
            user.setUser_id(rs.getInt(1));
            user.setFull_name(rs.getString(2));
            user.setUser_type(rs.getString(3));
            user.setUsername(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setDate_time(rs.getString(6));
            count++;
        }
        if (count == 0) {
            ResultSet rss = con.srh("SELECT * FROM patient WHERE username = '" + username + "' AND password = '" + password + "'");
            if (rss.next()) {
                user.setUser_id(rss.getInt(1));
                user.setFull_name(rss.getString(2));
                user.setUser_type("Patient");
                user.setUsername(rss.getString(8));
                user.setPassword(rss.getString(9));
                user.setDate_time(rss.getString(10));
            }
        }

        return user;
    }
}
