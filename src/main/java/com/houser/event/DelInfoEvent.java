package com.houser.event;

import com.houser.Main;
import com.houser.service.StudentService;
import com.houser.ui.MainJframe;
import com.houser.ui.diaog.DelDialog;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.ui.diaog.SuccessDialog;
import com.houser.util.IoUtils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class DelInfoEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        String uid= DelDialog.jTextField.getText();
        if(uid.equals("")||uid==null){
            new ErrorDialog("学号为空");
            return;
        }
        StudentService service=new StudentService();
        int i;
        try {
            i=service.deleteNodeByStudentId(uid, IoUtils.root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try {
            IoUtils.saveData(IoUtils.root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        new SuccessDialog("删除成功");

        DelDialog.jDialog.dispose();
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
