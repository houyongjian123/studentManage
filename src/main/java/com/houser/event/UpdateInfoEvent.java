package com.houser.event;

import com.houser.Main;
import com.houser.pojo.Student;
import com.houser.service.StudentService;
import com.houser.ui.MainJframe;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.ui.diaog.SuccessDialog;
import com.houser.ui.diaog.UpdateDiaog;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class UpdateInfoEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        String uid= UpdateDiaog.stuNo.getText();
        String age=UpdateDiaog.age.getText();
        int toIntAge;
        if(uid.equals("")||uid==null){
            new ErrorDialog("学号不能为空");
            return;
        }
        if(age.equals("")||age==null){
            new ErrorDialog("年龄不能为空");
            return;
        }
        try {
            toIntAge=Integer.parseInt(age);
        }catch (Exception exception){
            new ErrorDialog("age不合法");
            return;
        }
        StudentService service=new StudentService();
        try {
            service.updateStuInfo(uid,toIntAge);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        UpdateDiaog.dialog.dispose();
        new SuccessDialog("更新成功");
        Main.jframe.dispose();
        try {
            Main.jframe=new MainJframe();
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
