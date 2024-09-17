package com.houser.event;

import com.houser.pojo.Node;
import com.houser.pojo.Student;
import com.houser.service.StudentService;
import com.houser.ui.SearchIdJframe;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.ui.diaog.HintDialog;
import com.houser.ui.diaog.SearchByIdDialog;
import com.houser.util.IoUtils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchInfoByIdEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        String stuid= SearchByIdDialog.jTextField.getText();
        if(stuid.equals("")==true||stuid==null){
            new HintDialog("您的输入为空");
            return;
        }
        StudentService service=new StudentService();
        Node nodes = service.searchByStuId(stuid, IoUtils.root);
        Object[][] objects=null;
        try {
            objects = IoUtils.formatDataByArgs(nodes);
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        if(objects==null){
            new HintDialog("查询数据为空");
        }
        else {
            String names[]=new String[Student.class.getDeclaredFields().length];
            for (int i = 0; i < Student.class.getDeclaredFields().length; i++) {
                names[i]=Student.class.getDeclaredFields()[i].getName();
            }
            SearchByIdDialog.jDialog.dispose();
            new SearchIdJframe(objects,names);
        }
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
