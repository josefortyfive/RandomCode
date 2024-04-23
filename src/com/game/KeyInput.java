package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    public KeyInput(){
        left = false;
        right = false;
        up = false;
        down = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            setLeft(true);
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            setRight(true);
        }

        if(keyCode == KeyEvent.VK_UP){
            setUp(true);
        }

        if(keyCode == KeyEvent.VK_DOWN){setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            setLeft(false);
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            setRight(false);
        }

        if(keyCode == KeyEvent.VK_UP){
            setUp(false);
        }

        if(keyCode == KeyEvent.VK_DOWN){
            setDown(false);
        }
    }



    public void setLeft(boolean b){left = b;}
    public void setRight(boolean b){right = b;}
    public void setUp(boolean b){up = b;}
    public void setDown(boolean b){down = b;}

}
