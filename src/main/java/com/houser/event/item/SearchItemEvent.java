package com.houser.event.item;

import com.houser.ui.diaog.HintDialog;
import com.houser.ui.diaog.SearchByIdDialog;
import com.houser.util.IoUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchItemEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(IoUtils.root==null){
            new HintDialog("数据为空无法查询");
            return;
        }
        new SearchByIdDialog();
    }
}
