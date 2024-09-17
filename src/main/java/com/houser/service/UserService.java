package com.houser.service;

import com.houser.util.SqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private Connection con;

 public UserService() {
     try {
         con=SqlUtil.getConnection();
     } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    public boolean selectUserByUnamePwd(String username,String password) throws SQLException, NoSuchFieldException, IllegalAccessException {
        PreparedStatement statement = con.prepareStatement("select * from user where username=? and `password`=?;");
        statement.setObject(1,username);
        statement.setObject(2,password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
           return true;
        }
        return false;
    }
    public int insertNewUser(String username,String password) throws SQLException, NoSuchFieldException, IllegalAccessException {
        if(selectUserByUnamePwd(username,password)==true){
            return 0;
        }
        PreparedStatement statement = con.prepareStatement("insert into user (username,`password`) values(?,?);");
        statement.setObject(1,username);
        statement.setObject(2,password);
        int i = statement.executeUpdate();
        return i;
    }
}
