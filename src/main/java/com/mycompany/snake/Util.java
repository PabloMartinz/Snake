/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import static com.mycompany.snake.SquareType.FOOD;
import static com.mycompany.snake.SquareType.SPECIALFOOD;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alu10772822
 */
public class Util {

    public static void drawSquare(Graphics g, int row, int col, int squareWidth, int squareHeight, SquareType squareType, String level) {
        if (level.equals("Secret")) {
            switch (squareType) {
                case FOOD:
                    drawImage(g, row, col, squareWidth, squareHeight, "/images/champinon.png");
                    break;
                case SPECIALFOOD:
                    drawImage(g, row, col, squareWidth, squareHeight, "/images/estrella.png");
                    break;
                default:
                    Color colors[] = {new Color(255, 0, 0), new Color(0, 0, 204), new Color(153, 76, 0)};
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
                    break;
            }
        }else {
            Color colors[] = {new Color(10,131,39), new Color(11,165,0),new Color(11,165,0),new Color(231,26,20),
            new Color(165,24,222)};
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

    private static void drawImage(Graphics g, int row, int col, int squareWidth, int squareHeight, String imagePath) {
        try {
            BufferedImage image = ImageIO.read(Util.class.getResource(imagePath));
            int x = col * squareWidth;
            int y = row * squareHeight;
            g.drawImage(image, x, y, squareWidth, squareHeight, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
