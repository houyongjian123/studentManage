package com.houser.ui.diaog;

import javax.swing.*;

public class ErrorDialog {
    public ErrorDialog(String info){
        JDialog jDialog=new JDialog();
        jDialog.setTitle("错误");
        jDialog.setSize(300,300);
        jDialog.setLocationRelativeTo(null);
        jDialog.setAlwaysOnTop(true);

        jDialog.setLayout(null);
        jDialog.setModal(true);
        JLabel jLabel=new JLabel(info);
        jLabel.setBounds(jDialog.getWidth()/2-50,jDialog.getHeight()/2-20,100,40);
        jDialog.getContentPane().add(jLabel);
        jLabel.setVisible(true);
        jDialog.setVisible(true);
    }
}
