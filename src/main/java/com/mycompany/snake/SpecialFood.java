/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;

/**
 *
 * @author alu10772822
 */
public class SpecialFood extends Food {
    
    public SpecialFood(Snake snake){
        super(snake);
        int row = generateRandomRow();
        int col = generateRandomCol();
        while(!snake.canPaintFood(row, col)){
            row = generateRandomRow();
            col = generateRandomCol();
        }
        setRow(row);
        setCol(col);
    }
    @Override
    public void paintFood(Graphics g, Food food, int squareWidth, int squareHeight, Snake snake){
        int row = food.getRow();
        int col = food.getCol();
        
        Util.drawSquare(g, row, col, squareWidth, squareHeight, SquareType.SPECIALFOOD);
    }
    
    @Override
    public int getIncrementer(){
        return 1;
    }
}
