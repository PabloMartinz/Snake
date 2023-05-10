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
    
    public static ConfigData instance = new ConfigData();
    
    private ConfigData() {
        level = "Easy";
        name = "No Name";
              
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
