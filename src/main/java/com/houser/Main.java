package com.houser;

import com.houser.music.OpenMusic;
import com.houser.pojo.Node;
import com.houser.pojo.Student;
import com.houser.service.UserService;
import com.houser.ui.ConsoleBanner;
import com.houser.ui.MainJframe;
import com.houser.ui.loginJframe;
import com.houser.util.IoUtils;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static MainJframe jframe;
    public static loginJframe loginJframe;
    public static OpenMusic music;
    /**
     * @param args
     * @throws IOException
     * @auth *侯ser*
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, SQLException, UnsupportedAudioFileException {
        ConsoleBanner.pointBanner();
        music = new OpenMusic();
        UserService userService = new UserService();
        loginJframe=new loginJframe();

    }

}