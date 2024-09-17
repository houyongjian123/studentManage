package com.houser.ui.diaog;

import com.houser.event.DelEvent;
import com.houser.event.DelInfoEvent;

import javax.swing.*;

public class DelDialog {
    public static JTextField jTextField;
    public static JDialog jDialog;
    public DelDialog(){
        jDialog=new JDialog();
        jDialog.setTitle("根据学生id删除");
        jDialog.setSize(400,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(null);
        jDialog.setModal(true);
        JLabel jLabel=new JLabel("学生id:");
        jTextField=new JTextField();
        jTextField.setBounds(jDialog.getWidth()/2-60,jDialog.getHeight()/2-80,120,40);
        jLabel.setBounds(jDialog.getWidth()/2-130,jDialog.getHeight()/2-80,50,40);
        JButton jButton=new JButton("删除");
        jButton.setBounds(jDialog.getWidth()/2-20,jDialog.getHeight()/2-10,70,40);
        jDialog.add(jLabel);
        jDialog.add(jTextField);
        jDialog.add(jButton);
        jDialog.getContentPane().add(jLabel);
        jButton.addMouseListener(new DelInfoEvent());
        jDialog.setVisible(true);
    }
}
