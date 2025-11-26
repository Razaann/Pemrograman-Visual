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
        
        if (code == KeyEvent.VK_W) {
            ButtonUp = true;
        }
        if (code == KeyEvent.VK_S) {
            ButtonDown = true;
        }
        if (code == KeyEvent.VK_A) {
            ButtonLeft = true;
        }
        if (code == KeyEvent.VK_D) {
            ButtonRight = true;
        }
    }
    
    @Override
    public void keyReleased (KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_W) {
            ButtonUp = false;
        }
        if (code == KeyEvent.VK_S) {
            ButtonDown = false;
        }
        if (code == KeyEvent.VK_A) {
            ButtonLeft = false;
        }
        if (code == KeyEvent.VK_D) {
            ButtonRight = false;
        }   
    }
}
