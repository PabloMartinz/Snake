/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10772822
 */
public class Scoreboard extends javax.swing.JPanel implements Incrementer, GetScorer{
    private int score;

    /**
     * Creates new form Scoreboard
     */
    public Scoreboard() {
        initComponents();
        myInit();
    }
    public void myInit() {
        resetScore();
    }
    
    public void resetScore() {
        score = 0;
        labelScore.setText("Score: 0");
        labelName.setText(" Name: Pablo");
    }
    
    public void incrementScore(int increment) {
        score += increment;
        labelScore.setText("" + score);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 255));

        labelName.setText("name");
        add(labelName);

        labelScore.setText("Score");
        add(labelScore);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getScore() {
    return score;
    }
}
