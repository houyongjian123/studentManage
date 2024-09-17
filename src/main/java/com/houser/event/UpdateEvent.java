package com.houser.event;

import com.houser.ui.diaog.UpdateDiaog;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpdateEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        new UpdateDiaog();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
