/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alu10772822
 */
public class Util {

    public static void drawSquare(Graphics g, int row, int col, int squareWidth, int squareHeight, SquareType squareType){
        if (squareType == SquareType.FOOD || squareType == SquareType.SPECIALFOOD) {
            
        }
        Color colors[] = {new Color(0, 255, 0),new Color(0, 128, 255), new Color(226,29,29), new Color(239,218,4)};
        int x = col * squareWidth;
        int y = row * squareHeight;
        Color color = colors[squareType.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2,
                squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1,
                x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1,
                y + squareHeight - 1,
                x + squareWidth - 1, y + 1);
    }
    

}
