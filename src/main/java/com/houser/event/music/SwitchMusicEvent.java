package com.houser.event.music;

import com.houser.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchMusicEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Main.music.switchMusic();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
