/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alu10772822
 */
public class Snake {
    private Direction direction;
    private List<Node> nodes;
    private final int INITIAL_NODES = 3;
    
    public Snake(Direction direction){
        this.direction = Direction.RIGHT;
        this.nodes = new ArrayList<Node>();
        
        for(int i =0; i <= INITIAL_NODES; i++){
            Node node = new Node(Board.NUM_ROWS/2,Board.NUM_COLS/4-i);
            this.nodes.add(node);
        }
    }
    
    public void paintSnake(Graphics g,int squareWidth, int squareHeight){
        for(int i =0;i < nodes.size() ;i++){
            Node currentNode = nodes.get(i);
            if(i == 0){
                Util.drawSquare(g, currentNode.getRow(), currentNode.getCol(), squareWidth, squareHeight, SquareType.HEAD);

            } else{
                Util.drawSquare(g, currentNode.getRow(), currentNode.getCol(), squareWidth, squareHeight, SquareType.BODY);
            }
        }
    }
    
}
