package com.houser.event.item;

import com.houser.ui.diaog.HintDialog;
import com.houser.ui.diaog.UpdateDiaog;
import com.houser.util.IoUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemUpdateEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(IoUtils.root==null){
            new HintDialog("当前没有数据");
            return;
        }
        new UpdateDiaog();
    }
}
