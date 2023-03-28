/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.util.List;

/**
 *
 * @author alu10772822
 */
public class Snake {
    private Direction direction;
    private List<Node> list;
    
    public Snake(Direction direction, List<Node> list){
        this.direction = direction;
        this.list = list;
    }
}
