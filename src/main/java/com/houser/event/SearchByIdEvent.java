package com.houser.event;

import com.houser.ui.diaog.SearchByIdDialog;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchByIdEvent implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        new SearchByIdDialog();
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
