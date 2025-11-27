/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Overtale;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author User
 */
public class KeyHandler implements KeyListener {
    
    public boolean ButtonUp, ButtonDown, ButtonLeft, ButtonRight;
    
    @Override
    public void keyTyped(KeyEvent e) {
        // pass
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_UP) {
            ButtonUp = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            ButtonDown = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            ButtonLeft = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            ButtonRight = true;
        }
    }
    
    @Override
    public void keyReleased (KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_UP) {
            ButtonUp = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            ButtonDown = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            ButtonLeft = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            ButtonRight = false;
        }   
    }
}
