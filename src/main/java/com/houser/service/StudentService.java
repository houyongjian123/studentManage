package com.houser.service;

import com.houser.pojo.Node;
import com.houser.pojo.Student;
import com.houser.ui.diaog.ErrorDialog;
import com.houser.util.IoUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class StudentService {
    //新增数据
    public int addNode(Node rootNode, Student stu) throws IOException, ClassNotFoundException {

        if (stu == null) {
            ErrorDialog errorDialog = new ErrorDialog("数据为空");
            System.out.println("数据为空");
            return 0;
        }
        if (rootNode == null) {
            rootNode = new Node();
            rootNode.setData(stu);
            IoUtils.count++;
            IoUtils.root = rootNode;
            IoUtils.saveData(rootNode);
            return 1;
        }
        //如果不为null就会循环到null值，然后下一个就是当前student的数据。
        Node tempNode = rootNode;
        while (true) {
            if (tempNode.next == null) {
                Node newNode = new Node();
                newNode.setData(stu);
                tempNode.next = newNode;
                IoUtils.count++;
                break;
            } else {
                tempNode = tempNode.next;
            }
        }
        IoUtils.saveData(rootNode);
        return 1;
    }

    //删除数据
    public int deleteNodeByStudentId(String id, Node rootNode) throws IOException, ClassNotFoundException {
        if (id == null || id.equals("") == true) {
             new ErrorDialog("名字为空");
            return 0;
        }

        Node ptemp = rootNode;
        //将头节点可能是删除元素排除掉
        while (true) {
            if (ptemp == null) {
                IoUtils.root=rootNode;
                return 1;
            }
            if (ptemp.getData().getStudentId().equals(id)) {
                rootNode = ptemp.next;
                ptemp = ptemp.next;
                IoUtils.count--;
            } else {
                break;
            }
        }
        Node ptempNext = ptemp.next;
        while (true) {
            if (ptempNext == null) {
                IoUtils.root=rootNode;
                return 1;
            }
            if (ptempNext.getData().getStudentId().equals(id)) {
                ptempNext = ptempNext.next;
                ptemp.next = ptempNext;
                IoUtils.count--;
            } else {
                ptemp.next = ptempNext;
                ptempNext = ptempNext.next;
            }
            System.out.println(rootNode);
        }


    }
//根据学号查找学生
    public Node searchByStuId(String stuId, Node rootNode) {
        if (stuId == null) {
            return null;
        }
        List<Student> list=new ArrayList<>();
        while (true){
            if(rootNode==null){
                break;
            }
            if(rootNode.getData().getStudentId().equals(stuId)){
                list.add(rootNode.getData());
            }
            rootNode=rootNode.next;
        }
        if(list.size()==0){
            return null;
        }
        Node tempNode=null;
        Node pHead=null;
        for (int i = 0; i < list.size(); i++) {
            if(tempNode==null){
                tempNode=new Node();
                tempNode.setData(list.get(i));
                pHead=tempNode;
            }
            else {
                Node newNode=new Node();
                newNode.setData(list.get(i));
                tempNode.next=newNode;
                tempNode=tempNode.next;
            }
        }
        return pHead;
    }
//修改
    public void updateStuInfo(String id, int age) throws IOException, ClassNotFoundException {
        Node phead=IoUtils.root;
        while (true){
            if(IoUtils.root==null){
                break;
            }
            if(IoUtils.root.getData().getStudentId().equals(id)){
                IoUtils.root.getData().setAge(age);
            }
            IoUtils.root=IoUtils.root.next;
        }

        IoUtils.saveData(phead);
    }
}
