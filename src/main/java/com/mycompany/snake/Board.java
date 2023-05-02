/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 *
 * @author alu10772822
 */
public class Board extends javax.swing.JPanel {
    
    public static final int NUM_ROWS = 16;
    public static final int NUM_COLS = 16;
    private Timer timer;
    private Snake snake;
    private Food food;
    private FoodFactory foodFactory;
    private MyKeyAdapter myKeyAdapter;
    private Incrementer incrementer;
    private GetScorer getScorer;
    
    public void setIncrementer(Incrementer incrementer) {
        this.incrementer = incrementer;
        incrementer.resetScore();
    }
    
    public void setGetScorer(GetScorer getScorer) {
        this.getScorer = getScorer;
    }
    /**
     * Creates new form Board
     */
    public Board() {
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myInit(){
        snake = new Snake(Direction.RIGHT); 
        foodFactory = new FoodFactory();
        food = foodFactory.getFood(snake);
        myKeyAdapter = new MyKeyAdapter();
        addKeyListener(myKeyAdapter);
        setFocusable(true);
        
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tick();
            }
        });
        
    }
    
    public void initGame(){
        timer.start();
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        snake.paintSnake(g, squareWidth(), squareHeight());      
        food.paintFood(g, food, squareWidth(), squareHeight(), snake);
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void tick(){
        if (snake.canMove(snake)) {
            snake.moveSnake(snake);
            repaint();
        } else{
            timer.stop();
        }
        
        if (snake.hasEaten(food)) {
            snake.incrementSnake(snake, food.getIncrementer());
            incrementer.incrementScore(food.getPoints());
            food = foodFactory.getFood(snake);
        }
    }

    
    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT) {
                        snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != Direction.RIGHT) {
                        snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN) {
                        snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP) {
                        snake.setDirection(Direction.DOWN);
                    }
                    break;
                default:
                    break;
            }
            repaint();
        }
    }
    
    public int squareWidth() {
        return getWidth() / Board.NUM_COLS;
    }
    
    public int squareHeight() {
        return getHeight() / Board.NUM_ROWS;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
