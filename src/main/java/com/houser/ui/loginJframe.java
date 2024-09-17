package com.houser.ui;

import com.houser.event.loginEvent.LoginEvent;
import com.houser.event.loginEvent.RegisterEvent;

import javax.swing.*;

public class loginJframe extends JFrame {
    public static JTextField uIpt;
    public static JTextField pIpt;
    //设置文字与输入框按钮
    public void setFontAndInput(){
        JLabel username=new JLabel("用户名");
        JLabel password=new JLabel("密码");
        password.setBounds(this.getWidth()/2-100,this.getHeight()/2-100,60,40);
        username.setBounds(this.getWidth()/2-100,this.getHeight()/2-150,60,40);
         uIpt=new JTextField();
         pIpt=new JTextField();
        uIpt.setBounds(this.getWidth()/2-40,this.getHeight()/2-150,150,40);
        pIpt.setBounds(this.getWidth()/2-40,this.getHeight()/2-100,150,40);
        JButton loginBtn=new JButton("登录");
        JButton regBtn=new JButton("注册");
        loginBtn.setBounds(this.getWidth()/2-70,this.getHeight()/2-20,80,60);
        regBtn.setBounds(this.getWidth()/2+20,this.getHeight()/2-20,80,60);
        this.getContentPane().add(loginBtn);
        this.getContentPane().add(regBtn);
        this.getContentPane().add(uIpt);
        this.getContentPane().add(pIpt);
        this.getContentPane().add(username);
        this.getContentPane().add(password);
        regBtn.addMouseListener(new RegisterEvent());
        loginBtn.addMouseListener(new LoginEvent());
    }
    public loginJframe(){
        this.setTitle("登录账号");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(500,500);
        setFontAndInput();
        this.setVisible(true);
    }
}
