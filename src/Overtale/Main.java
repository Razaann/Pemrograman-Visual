/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Overtale;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Overtale");
        
        // Add GamePanel Window
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        
        window.pack();
        window.setLocationRelativeTo(null); // Center on screen
        window.setVisible(true);
        
        gamepanel.startGameThread();
    }
}
