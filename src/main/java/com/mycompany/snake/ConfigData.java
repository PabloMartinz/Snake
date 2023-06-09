/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10772822
 */
public class ConfigData {
    private String level;
    private String name;
    private int delay;
    
    public static ConfigData instance = new ConfigData();
    
    private ConfigData() {
        level = "";
        name = "No Name";
              
    }
    
    public int getDelay() {
       
        switch (level) {
            case "Easy":
                this.delay = 200;
                break;
            case "Normal":
                this.delay = 150;
                break;
            case "Hard":
                this.delay = 100;
                break;
            case "Pro":
                this.delay = 100;
                break;
            case "Secret":
                this.delay = 150;
                break;
            default:
                this.delay = 200;
        }
        return delay;
    
    }
    
    public void setLevel(int level) {
        switch (level) {
            case 0:
                this.level = "Easy";
                break;
            case 1:
                this.level = "Normal";
                break;
            case 2: 
                this.level = "Hard";
                break;
            case 3:
                this.level = "Secret";
                break;
            default:
                this.level = "Easy"; 
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLevel() {
        return level;
    }
    
    public String getName() {
        return name;
    }
}
