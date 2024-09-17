package com.houser.util;

import com.houser.pojo.Node;
import com.houser.pojo.Student;

import java.io.*;
import java.lang.reflect.Field;

public class IoUtils {
    public static int count=0;
    public static Node root=null;
    public static Node getAllDatas() {
        File file= null ;
        file = new File("src/main/resources/data/data.txt");
//        System.out.println(file.canRead());
//        try {
//            objectInput = new ObjectInputStream(file);
//        } catch (IOException e) {
//            System.out.println("111"+e);
//        }
        Node o =null;
//        try {
//            o=(Node) objectInput.readObject();
//        } catch (Exception e) {
//            try {
//                objectInput.close();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            System.out.println(e);
//        }
        if(file.length()==0){
            return null;
        }
        try {
            ObjectInput objectInput=new ObjectInputStream(new FileInputStream(file));
            o=(Node) objectInput.readObject();
            root=o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println(o);
        return o;
    }
    public static int getCount(){
        int i=0;
       Node node=getAllDatas();
       while (true){
           if(node==null){
               count=i;
               return i;
           }
           if(node!=null){
               i++;
               node=node.next;
           }
       }
    }
    public static void outcount(){
        try {
            FileOutputStream fileWriter=new FileOutputStream("src/main/resources/data/count.txt");
            fileWriter.write(String.valueOf(count).getBytes());
            fileWriter.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static Object[][] formatData() throws NoSuchFieldException, IllegalAccessException {
        Node root = getAllDatas();
        Field[] fields = Student.class.getDeclaredFields();
        int fieldlen = fields.length;
        if(root==null){
            return null;
        }
        Node tempNode=root;
        Object datas[][]=new Object[count][fieldlen];
        for (int i=0;i<count;i++){
            if(tempNode==null){
                break;
            }
            for (int j=0;j<fieldlen;j++){
                fields[j].setAccessible(true);
                Object o = fields[j].get(tempNode.getData());
                System.out.print(fields[j].getName()+":");
                System.out.println(o);
                datas[i][j]=o;

            }
            tempNode=tempNode.next;
        }

        return datas;
    }
    public static void saveData(Node root) throws IOException, ClassNotFoundException {
        if(root==null){
            System.out.println("对不起您的数据为空，不能保存");
        }
        ObjectOutputStream objectInput=new ObjectOutputStream(new FileOutputStream("src/main/resources/data/data.txt"));
        objectInput.writeObject(root);
        objectInput.close();
        outcount();
    }
    public static Object[][] formatDataByArgs(Node node) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = Student.class.getDeclaredFields();
        int fieldlen = fields.length;
        if(node==null){
            return null;
        }
        Node temp=node;
        int n=0;
        while (true){
            if(temp==null)break;
            n+=1;
            temp=temp.next;
        }
        Node tempNode=node;
        Object datas[][]=new Object[n][fieldlen];
        for (int i=0;i<n;i++){
            if(tempNode==null){
                break;
            }
            for (int j=0;j<fieldlen;j++){
                fields[j].setAccessible(true);
                Object o = fields[j].get(tempNode.getData());
                System.out.print(fields[j].getName()+":");
                System.out.println(o);
                datas[i][j]=o;

            }
            tempNode=tempNode.next;
        }

        return datas;
    }

}
