package com.houser.event.item;

import com.houser.ui.diaog.DelDialog;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.ui.diaog.HintDialog;
import com.houser.util.IoUtils;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//@Data
public class DelItemEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(IoUtils.root==null){
            new HintDialog("信息为空");
            return;
        }
        new DelDialog();
    }
}
