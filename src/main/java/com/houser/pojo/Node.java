package com.houser.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Node implements Serializable {
    private Student data;
    public Node next;
}
