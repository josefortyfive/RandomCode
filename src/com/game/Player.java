package com.game;


import java.awt.*;
import java.awt.font.GlyphMetrics;
import java.security.Key;

public class Player {



    private int x;
    private int y;
    private int r;

    private int dx;
    private int dy;
    private int speed;
    public KeyInput keyInput;



    private int lives;
    private Color color1;
    private Color color2;


    public Player(KeyInput keyInput){
        x = GamePanel.WIDTH  / 2;
        y = GamePanel.HEIGHT / 2;
        r = 5;

        dx = 0;
        dy = 0;
        speed = 5;
        lives = 3;
        color1 = Color.WHITE;
        color2 = Color.RED;

        this.keyInput = keyInput;
    }

    public void update(){
        if(keyInput.left){
            dx = -speed;
        }
        if(keyInput.right){
            dx = speed;
        }
        if(keyInput.up){
            dy = -speed;
        }
        if(keyInput.down){
            dy = speed;
        }

        x += dx;
        y += dy;

        if( x < r) {
            x = r;
        }

        if(y < r) {
            y = r;
        }

        if(x > GamePanel.WIDTH - r) x = GamePanel.WIDTH - r;
        if(y > GamePanel.HEIGHT - r) y = GamePanel.HEIGHT - r;

        dx = 0;
        dy = 0;
    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval(x - r, y - r, 2  * r, 2 * r);

        g.setStroke(new BasicStroke(3));
        g.setColor(color1.darker());
        g.drawOval(x - r, y - r, 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));
    }

}
