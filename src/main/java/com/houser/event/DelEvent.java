package com.houser.event;

import com.houser.ui.diaog.DelDialog;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DelEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        new DelDialog();
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
