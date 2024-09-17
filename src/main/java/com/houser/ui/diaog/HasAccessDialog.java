package com.houser.ui.diaog;

import javax.swing.*;

public class HasAccessDialog {
    public HasAccessDialog(){
        JDialog jDialog=new JDialog();
        jDialog.setTitle("错误");
        jDialog.setSize(100,100);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(null);
        jDialog.setModal(true);
        JLabel jLabel=new JLabel("数据为空");
        jLabel.setBounds(jDialog.getWidth()/2-25,jDialog.getHeight()/2-20,50,40);
        jDialog.add(jLabel);
        jDialog.getContentPane().add(jLabel);
        jDialog.setVisible(true);
    }
}
