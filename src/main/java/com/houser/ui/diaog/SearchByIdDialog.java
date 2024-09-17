package com.houser.ui.diaog;

import com.houser.event.DelInfoEvent;
import com.houser.event.SearchInfoByIdEvent;

import javax.swing.*;

public class SearchByIdDialog {
    public static JTextField jTextField;
    public static JDialog jDialog;
    public SearchByIdDialog(){
        jDialog=new JDialog();
        jDialog.setTitle("根据学生id查找信息");
        jDialog.setSize(400,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(null);
        jDialog.setModal(true);
        JLabel jLabel=new JLabel("学生id:");
        jTextField=new JTextField();
        jTextField.setBounds(jDialog.getWidth()/2-60,jDialog.getHeight()/2-80,120,40);
        jLabel.setBounds(jDialog.getWidth()/2-130,jDialog.getHeight()/2-80,50,40);
        JButton jButton=new JButton("查找");
        jButton.setBounds(jDialog.getWidth()/2-20,jDialog.getHeight()/2-10,70,40);
        jDialog.add(jLabel);
        jDialog.add(jTextField);
        jDialog.add(jButton);
        jDialog.getContentPane().add(jLabel);
//        添加事件
        jButton.addMouseListener(new SearchInfoByIdEvent());
        jDialog.setVisible(true);
    }
}
