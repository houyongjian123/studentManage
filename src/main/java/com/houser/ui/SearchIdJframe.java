package com.houser.ui;

import com.houser.ui.diaog.SearchByIdDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class SearchIdJframe extends JFrame {

    public SearchIdJframe(Object[][]datas,String[]names){
        this.setTitle("根据id所查数据");
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setMaximumSize(null);
        this.setAlwaysOnTop(true);
        JTable jTable=new JTable(datas,names);
        TableColumn column = null;
        int colunms = jTable.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = jTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(200);
        }
        jTable.setOpaque(false);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scroll = new JScrollPane(jTable);
        scroll.setBounds(0,0,600,490);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.setViewportBorder(new EmptyBorder(0,0,0,0));
        add(scroll);
        this.setVisible(true);
    }
}
