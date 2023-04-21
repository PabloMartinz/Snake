/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10772822
 */
public class FoodFactory {
    public Food getFood(Snake snake){
        double rand = Math.random();
        if(rand < 0.1){
            return new SpecialFood(snake);
        } else{
            return new Food(snake);
        }
    }
}
