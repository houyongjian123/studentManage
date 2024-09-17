package com.houser.event;

import com.houser.Main;
import com.houser.pojo.Student;
import com.houser.service.StudentService;
import com.houser.ui.MainJframe;
import com.houser.util.IoUtils;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.channels.UnresolvedAddressException;

@Data
public class AddInfoEvent implements MouseListener {
    private Student stuInfo;

    @Override
    public void mouseClicked(MouseEvent e) {
        StudentService service = new StudentService();
        String stuNo= AddEvent.stuNo.getText();
        String name=AddEvent.name.getText();
        int age=0;
        try {
            int i=Integer.parseInt(AddEvent.age.getText());
            age=i;
        }catch (Exception exception){
            System.out.println(exception);
        }
        System.out.println(stuNo+":"+name+":"+age);
        if(stuNo.equals("")==true||stuNo==null||name.equals("")==true||name==null){
            System.out.println("其中一项为null");
            stuInfo=null;
        }
        else {
            stuInfo=new Student(name,stuNo,age);
        }
        try {
            System.out.println(stuInfo);
            service.addNode(IoUtils.root,stuInfo);
            AddEvent.setclose();
            Main.jframe.dispose();
            Main.jframe=new MainJframe();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
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
