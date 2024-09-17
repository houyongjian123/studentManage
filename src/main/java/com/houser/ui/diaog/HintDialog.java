package com.houser.ui.diaog;

import javax.swing.*;

public class HintDialog {
    public HintDialog(String info){
        JDialog jDialog=new JDialog();
        jDialog.setTitle("提示");
        jDialog.setSize(200,200);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(null);
        jDialog.setModal(true);
        JLabel jLabel=new JLabel(info);
        jLabel.setBounds(jDialog.getWidth()/2-60,jDialog.getHeight()/2-40,120,40);
        jDialog.add(jLabel);
        jDialog.add(jLabel);
        jDialog.setVisible(true);
    }
}
