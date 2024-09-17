package com.houser.ui;

import com.houser.event.UpdateEvent;
import com.houser.event.AddEvent;
import com.houser.event.DelEvent;
import com.houser.event.SearchByIdEvent;
import com.houser.event.item.AddItemEvent;
import com.houser.event.item.DelItemEvent;
import com.houser.event.item.ItemUpdateEvent;
import com.houser.event.item.SearchItemEvent;
import com.houser.event.music.OpenMusicEvent;
import com.houser.event.music.StopMusicEvent;
import com.houser.event.music.SwitchMusicEvent;
import com.houser.pojo.Student;
import com.houser.util.IoUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.Style;
import java.awt.*;
import java.lang.reflect.Field;

public class MainJframe extends JFrame{
    public Object[][] objects=null;
    Field[] declaredFields = Student.class.getDeclaredFields();
    //记录所有的数据的属性名字
    String[]names=new String[declaredFields.length];

    //添加所有的菜单选项
    public void addjmenu(){
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenuSys=new JMenu("系统设置");
        JMenu jmenuADSU=new JMenu("增删查改");
        JMenuItem s_i1=new JMenuItem("背景设置");
        JMenuItem s_i2=new JMenuItem("召唤神龙");
        JMenuItem l_a=new JMenuItem("增加");
        JMenuItem l_d=new JMenuItem("删除");
        JMenuItem l_s=new JMenuItem("查找");
        JMenuItem l_u=new JMenuItem("修改");
        JMenu jMusic=new JMenu("音乐设置");
        JMenuItem stopMusic=new JMenuItem("关闭音乐");
        JMenuItem switchMusic=new JMenuItem("切换音乐");
        JMenuItem openMusic=new JMenuItem("打开音乐");

        //菜单事件
        l_a.addActionListener(new AddItemEvent());
        l_d.addActionListener(new DelItemEvent());
        l_s.addActionListener(new SearchItemEvent());
        l_u.addActionListener(new ItemUpdateEvent());
        //菜单事件_音乐菜单
        stopMusic.addActionListener(new StopMusicEvent());
        switchMusic.addActionListener(new SwitchMusicEvent());
        openMusic.addActionListener(new OpenMusicEvent());
        //添加菜单主键
        jMenuSys.add(s_i1);
        jMenuSys.add(s_i2);
        jmenuADSU.add(l_a);
        jmenuADSU.add(l_s);
        jmenuADSU.add(l_d);
        jmenuADSU.add(l_u);
        jMusic.add(switchMusic);
        jMusic.add(stopMusic);
        jMusic.add(openMusic);
        jMenuBar.add(jMusic);
        jMenuBar.add(jMenuSys);
        jMenuBar.add(jmenuADSU);
        this.setJMenuBar(jMenuBar);

    }
    public void setBackground(String src){
        // 创建一个JLabel并设置图像
        ImageIcon imageIcon = new ImageIcon(src);
        JLabel label = new JLabel(imageIcon);
        // 设置label的位置和大小
        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        this.getContentPane().add(label);
    }

    public void showData() throws NoSuchFieldException, IllegalAccessException {
        objects = IoUtils.formatData();
        if(objects==null){
            JLabel jLabel=new JLabel("数据为空");
            jLabel.setBounds(this.getWidth()/2-22,0,55,35);
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.CYAN);
            jLabel.setBorder(null);
            this.getContentPane().add(jLabel);
            setBackground("src/main/resources/img/nodata.png");
        }
        else {
            buttons();
            JTable jTable=new JTable(objects,names);
            TableColumn column = null;
            int colunms = jTable.getColumnCount();
            DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            renderer.setOpaque(false);
            renderer.setBorder(BorderFactory.createEmptyBorder());
            jTable.setBorder(BorderFactory.createEmptyBorder());
            JTableHeader tableHeader = jTable.getTableHeader();
            tableHeader.setDefaultRenderer(renderer);
            tableHeader.setBorder(BorderFactory.createEmptyBorder());
            for(int i = 0; i < colunms; i++)
            {
                column = jTable.getColumnModel().getColumn(i);
                column.setPreferredWidth(113);
                column.setCellRenderer(renderer);
            }
            jTable.setOpaque(false);
            jTable.setFont(new Font(null,Font.ITALIC,14));
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JScrollPane scroll = new JScrollPane(jTable);
            scroll.setBounds(140,220,343,525);
            scroll.getViewport().setOpaque(false);
            scroll.setOpaque(false);
            scroll.setViewportBorder(BorderFactory.createEmptyBorder());
            add(scroll);
            setBackground("src/main/resources/img/havedata.png");
        }
    }
    //设置当前条目数
    public void setCount() throws FontFormatException {
        for (int i = 0; i < declaredFields.length; i++) {
            names[i]=declaredFields[i].getName();
        }
        int count = IoUtils.getCount();
        JLabel jcount=new JLabel("当前"+String.format("%d",count)+"条信息");
        jcount.setBounds(0,0,120,40);
        jcount.setFont(new Font("Serif",Font.BOLD,15 ));
//        jcount.setOpaque(true);
//        jcount.setBackground(Color.CYAN);
        this.getContentPane().add(jcount);
    }
public void buttons(){
    //设置按扭
    ImageIcon icon=new ImageIcon("src/main/resources/img/img.png");
    JLabel jLabel=new JLabel(icon);
    jLabel.setBounds(640,300,304,291);
    JButton addbtn=new JButton();
    JButton delbtn=new JButton();
    JButton selectbtn=new JButton();
    JButton udbtn=new JButton();
    //新增按钮
    addbtn.setBounds(jLabel.getX()+jLabel.getWidth()/2-35,jLabel.getY()+ jLabel.getHeight()/2-addbtn.getHeight()+60,71,40);
    addbtn.setBorderPainted(false);
    addbtn.setContentAreaFilled(false);
    addbtn.setIcon(new ImageIcon("src/main/resources/img/add.png"));
    this.getContentPane().add(addbtn);
    //删除按钮
    delbtn.setBounds(jLabel.getX()+jLabel.getWidth()/2-35,jLabel.getY()+ jLabel.getHeight()/2-addbtn.getHeight()-10+60,71,40);
    delbtn.setBorderPainted(false);
    delbtn.setContentAreaFilled(false);
    delbtn.setIcon(new ImageIcon("src/main/resources/img/del.png"));
    this.getContentPane().add(delbtn);
    //查找按钮
    selectbtn.setBounds(jLabel.getX()+jLabel.getWidth()/2-35,jLabel.getY()+ jLabel.getHeight()/2-addbtn.getHeight()*2-10+60,71,40);
    selectbtn.setBorderPainted(false);
    selectbtn.setContentAreaFilled(false);
    selectbtn.setIcon(new ImageIcon("src/main/resources/img/select.png"));
    this.getContentPane().add(selectbtn);
    //修改按钮
    udbtn.setBounds(jLabel.getX()+jLabel.getWidth()/2-35,jLabel.getY()+ jLabel.getHeight()/2-addbtn.getHeight()*3-10+50,71,40);
    udbtn.setBorderPainted(false);
    udbtn.setContentAreaFilled(false);
    udbtn.setIcon(new ImageIcon("src/main/resources/img/update.png"));
    this.getContentPane().add(udbtn);

    //设置便签
    this.getContentPane().add(jLabel);
    //添加事件
    addbtn.addMouseListener(new AddEvent());
    delbtn.addMouseListener(new DelEvent());
    selectbtn.addMouseListener(new SearchByIdEvent());
    udbtn.addMouseListener(new UpdateEvent());
}




    public MainJframe() throws NoSuchFieldException, IllegalAccessException, FontFormatException {
        IoUtils.root=IoUtils.getAllDatas();
        this.setTitle("系统管理学生");
        this.setSize(1107,1050);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        //禁止放大
        this.setResizable(false);
        setCount();
        showData();
        addjmenu();
        this.setVisible(true);
    }
}
