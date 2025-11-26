/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Overtale;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    final int OgTileSize = 16; // 16 px tile
    final int Scale = 2; // To scale the tile
    final int TileSize = OgTileSize * Scale;
    final int ScreenColumn = 20;
    final int ScreenRow = 15;
    final int ScreenWidth = TileSize * ScreenColumn;
    final int ScreenHeight = TileSize * ScreenRow;
    
    // System
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // The Game Clock
    
    // Player Settings
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    BufferedImage playerImage;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        
        // Input Listener
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
        loadPlayerImage();
    }
    
    public void loadPlayerImage() {
        try {
            playerImage = ImageIO.read(getClass().getResourceAsStream("/Overtale/Assets/player.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image not found");
        }
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        // The Game Loop
        double drawInterval = 1000000000 / 60;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while (gameThread != null) {
            // Update Function
            update();
            
            // Draw Function
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void update() {
        if (keyH.ButtonUp == true) {
            playerY -= playerSpeed;
        }
        if (keyH.ButtonDown == true) {
            playerY += playerSpeed;
        }
        if (keyH.ButtonRight == true) {
            playerX += playerSpeed;
        }
        if (keyH.ButtonLeft == true) {
            playerX -= playerSpeed;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        if (playerImage != null) {
            g2.drawImage(playerImage, playerX, playerY, TileSize, TileSize, null);
        }
        else {
            // White Box if fail to load image
            g2.setColor(Color.white);
            g2.fillRect(playerX, playerY, TileSize, TileSize);
        }
        
        g2.dispose();
    }
}
