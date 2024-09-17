package com.houser.event.loginEvent;

import com.houser.Main;
import com.houser.service.UserService;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.ui.diaog.HasAccessDialog;
import com.houser.ui.MainJframe;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class RegisterEvent implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        UserService userService;
        userService=new UserService();

        String username= Main.loginJframe.uIpt.getText();
        String password=Main.loginJframe.pIpt.getText();
        if(username==null||username.equals("")==true||password==null||password.equals("")==true){
            new ErrorDialog("用户名密码为空");
            return;
        }
        try {
            if (userService.insertNewUser(username,password)==0){
                new HasAccessDialog();
            }
            else {
                Main.loginJframe.dispose();
                Main.jframe=new MainJframe();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (FontFormatException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
