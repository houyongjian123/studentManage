package com.houser.event.item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemEvent implements ActionListener {
    private static JDialog dialog;
    public static JTextField name;
    public static JTextField  age;
    public static JTextField stuNo;

    public void setfield(){
        JLabel name=new JLabel("姓名:");
        JLabel stuNo=new JLabel("学号:");
        JLabel age=new JLabel("年龄:");
        name.setFont(new Font("Serif", Font.BOLD, 24));
        stuNo.setFont(new Font("Serif", Font.BOLD, 24));
        age.setFont(new Font("Serif", Font.BOLD, 24));
        name.setBounds(dialog.getWidth()/2-150,dialog.getHeight()/2-100,80,40);
        stuNo.setBounds(dialog.getWidth()/2-150,dialog.getHeight()/2-50,80,40);
        age.setBounds(dialog.getWidth()/2-150,dialog.getHeight()/2,80,40);
        dialog.getContentPane().add(name);
        dialog.getContentPane().add(stuNo);
        dialog.getContentPane().add(age);
    }
    public void setInput(){
        name=new JTextField();
        stuNo=new JTextField();
        age= new JTextField();
        name.setBounds(dialog.getWidth()/2-50,dialog.getHeight()/2-105,120,50);
        stuNo.setBounds(dialog.getWidth()/2-50,dialog.getHeight()/2-55,120,50);
        age.setBounds(dialog.getWidth()/2-50,dialog.getHeight()/2-5,120,50);
        dialog.getContentPane().add(name);
        dialog.getContentPane().add(stuNo);
        dialog.getContentPane().add(age);
    }
    public void setSureBtn(){
        JButton jButton=new JButton("确定");
        jButton.setBounds(dialog.getWidth()/2-35,260,70,40);
        dialog.add(jButton);
        ItemAddInfoEvent addInfoEvent=new ItemAddInfoEvent();
        jButton.addMouseListener(addInfoEvent);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dialog=new JDialog();
        dialog.setTitle("新增学生信息");
        dialog.setSize(400,400);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setLayout(null);
        setInput();
        setfield();
        setSureBtn();
        dialog.setVisible(true);

    }
    public static void setclose(){
        dialog.dispose();
    }
}
