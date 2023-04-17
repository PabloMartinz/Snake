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

    public Direction getDirection() {
        return direction;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
    
    public boolean canMove(Snake snake){
        Node checkNode = snake.getNodes().get(0);
        
        if(checkNode.getRow() >= Board.NUM_ROWS || checkNode.getRow() < 0){
            return false;
        }
        if(checkNode.getCol() >= Board.NUM_COLS || checkNode.getCol() < 0){
            return false;
        }
        if(colidesWithSnake(snake)){
            return false;
        }
        return true;
    }
    
    public void moveSnake(Snake snake){
        Node head = snake.getNodes().get(0);
        Node beforeHead = snake.getNodes().get(1);
        
        switch (snake.getDirection()) {
            case RIGHT:
                if (beforeHead.getCol() != head.getCol()+1) {
                    
                    Node newNode = new Node(0, 0);
                    
                    newNode.setRow(snake.getNodes().get(0).getRow());
                    newNode.setCol(snake.getNodes().get(0).getCol() + 1);
                    
                    snake.getNodes().remove(snake.getNodes().size() - 1);
                    snake.getNodes().add(0, newNode);
                }

                break;
            case LEFT:
                if (beforeHead.getCol() != head.getCol()-1) {
                    
                    Node newNode = new Node(0,0);
                    
                    newNode.setRow(snake.getNodes().get(0).getRow());
                    newNode.setCol(snake.getNodes().get(0).getCol() - 1);
                    
                    snake.getNodes().remove(snake.getNodes().size() - 1);
                    snake.getNodes().add(0, newNode);
                }
                break;
            case UP:
                if (beforeHead.getRow() != head.getRow()-1) {
                    
                    Node newNode = new Node(0,0);
                    
                    newNode.setRow(snake.getNodes().get(0).getRow() - 1);
                    newNode.setCol(snake.getNodes().get(0).getCol());
                    
                    snake.getNodes().remove(snake.getNodes().size() - 1);
                    snake.getNodes().add(0, newNode);
                }
                break;
            case DOWN:
                if (beforeHead.getRow() != head.getRow()+1) {
                    
                    Node newNode = new Node(0,0);
                    
                    newNode.setRow(snake.getNodes().get(0).getRow() + 1);
                    newNode.setCol(snake.getNodes().get(0).getCol());
                    
                    snake.getNodes().remove(snake.getNodes().size() - 1);
                    snake.getNodes().add(0, newNode);
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    private boolean colidesWithSnake(Snake snake) {
        Node head = snake.getNodes().get(0);

        for(int i = 1; i < snake.getNodes().size();i++){
            Node currentNode = snake.getNodes().get(i);
            if(currentNode.getRow() == head.getRow() && currentNode.getCol() == head.getCol()){
                return true;
            }
        }
        return false;
        
    }
    
    public boolean canPaintFood(int foodRow, int foodCol){
        for(Node node: nodes){
            if(foodRow == node.getRow() && foodCol == node.getCol()){
                return false;
            }
        }
        return true;
    }
    
    public boolean hasEaten(Food food){
        if(food.getRow() == nodes.get(0).getRow() && food.getCol() == nodes.get(0).getCol()){
            return true;
        }
        return false;
    }
    
    public void incrementSnake(Snake snake, int incrementer) {
        Node lastNode = snake.getNodes().get(snake.getNodes().size() - 1);
        Node newNode = new Node(lastNode.getRow(), lastNode.getCol());
        
        for (int i = 0; i < incrementer; i++) {
            snake.nodes.add(newNode);
        }
    }
    
}
