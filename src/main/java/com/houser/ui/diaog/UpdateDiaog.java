package com.houser.ui.diaog;

import com.houser.event.AddInfoEvent;
import com.houser.event.UpdateInfoEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class UpdateDiaog {
    public static JDialog dialog;
    public static JTextField  age;
    public static JTextField stuNo;

    public void setfield(){
        JLabel stuNo=new JLabel("要修改的学号:");
        JLabel age=new JLabel("修改为的年龄:");
        stuNo.setFont(new Font("Serif", Font.BOLD, 15));
        age.setFont(new Font("Serif", Font.BOLD, 15));
        stuNo.setBounds(dialog.getWidth()/2-160,dialog.getHeight()/2-70,110,40);
        age.setBounds(dialog.getWidth()/2-160,dialog.getHeight()/2-20,110,40);
        dialog.getContentPane().add(stuNo);
        dialog.getContentPane().add(age);
    }
    public void setInput(){
        stuNo=new JTextField();
        age= new JTextField();
        stuNo.setBounds(dialog.getWidth()/2-50,dialog.getHeight()/2-78,120,50);
        age.setBounds(dialog.getWidth()/2-50,dialog.getHeight()/2-25,120,50);
        dialog.getContentPane().add(stuNo);
        dialog.getContentPane().add(age);
    }
    public void setSureBtn(){
        JButton jButton=new JButton("修改");
        jButton.setBounds(dialog.getWidth()/2-35,200,70,40);
        dialog.add(jButton);
        //按钮添加事件
        jButton.addMouseListener(new UpdateInfoEvent());
    }

    public  UpdateDiaog() {
        dialog=new JDialog();
        dialog.setTitle("修改");
        dialog.setSize(400,300);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setLayout(null);
        setInput();
        setfield();
        setSureBtn();
        dialog.setVisible(true);
    }
}
