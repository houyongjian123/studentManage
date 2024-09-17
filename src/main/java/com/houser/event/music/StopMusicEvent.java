package com.houser.event.music;

import com.houser.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopMusicEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.music.PauseMusic();
    }
}
