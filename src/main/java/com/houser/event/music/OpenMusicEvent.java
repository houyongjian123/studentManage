package com.houser.event.music;

import com.houser.Main;

import javax.sound.sampled.LineUnavailableException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenMusicEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Main.music.openMusic();
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
    }
}
