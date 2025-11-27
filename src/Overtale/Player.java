/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Overtale;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class Player {
    
    GamePanel gp;
    KeyHandler keyH;
    
    // World Coordinates
    public int x, y;
    public int speed;
    
    // Sprite Variables
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    
    // Animation State
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Player (GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        x = 304;
        y = 224;
        speed = 3;
        direction = "down";
    }
    
    public void getPlayerImage() {
        try {
            BufferedImage spriteSheet = ImageIO.read(getClass().getResourceAsStream("/Overtale/Assets/Walk.png"));
            
            // THE SCISSORS (getSubimage)
            // getSubimage(x, y, width, height)
            
            // Down
            down1 = spriteSheet.getSubimage(0, 0, 16, 32);
            down2 = spriteSheet.getSubimage(16, 0, 16, 32);
            
            // Up
            up1 = spriteSheet.getSubimage(0, 32, 16, 32);
            up2 = spriteSheet.getSubimage(16, 32, 16, 32);
            
            // Left
            left1 = spriteSheet.getSubimage(0, 96, 16, 32);
            left2 = spriteSheet.getSubimage(16, 96, 16, 32);

            // Right
            right1 = spriteSheet.getSubimage(0, 64, 16, 32);
            right2 = spriteSheet.getSubimage(16, 64, 16, 32);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if (keyH.ButtonUp || keyH.ButtonDown || keyH.ButtonRight || keyH.ButtonLeft) {
            
            // Determine Direction
            if (keyH.ButtonUp) {
                direction = "up";
                y -= speed;
            }
            else if (keyH.ButtonDown) {
                direction = "down";
                y += speed;
            }
            else if (keyH.ButtonLeft) {
                direction = "left";
                x -= speed;
            }
            else if (keyH.ButtonRight) {
                direction = "right";
                x += speed;
            }
            
            // Animation Counter
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        
        switch (direction) {
            case "up":
                if (spriteNum == 1) image = up1;
                if (spriteNum == 2) image = up2;
                break;
            case "down":
                if (spriteNum == 1) image = down1;
                if (spriteNum == 2) image = down2;
                break;
            case "left":
                if (spriteNum == 1) image = left1;
                if (spriteNum == 2) image = left2;
                break;
            case "right":
                if (spriteNum == 1) image = right1;
                if (spriteNum == 2) image = right2;
                break;
        }
        
        g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
}
