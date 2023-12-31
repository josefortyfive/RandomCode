package doomtest1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import doomtest1.Input;
import doomtest1.Vec2;

public class Player {

    public double x;
    public double y;
    public double angle;
    public double height = 64;
    private final Vec2 directionVec2;

    public Player(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        directionVec2 = new Vec2();
    }
    
    public void update() {
        final double angSpeed = 0.1;
        final double speed = 2.0;

        if (Input.isKeyPressed(KeyEvent.VK_LEFT)) {
            angle += angSpeed;
        }
        else if(Input.isKeyPressed(KeyEvent.VK_A)) {
        	angle +=angSpeed;
        }
        else if (Input.isKeyPressed(KeyEvent.VK_RIGHT)) {
            angle -= angSpeed;
        }
        else if (Input.isKeyPressed(KeyEvent.VK_D)) {
        	angle -= angSpeed;
        }
        if (Input.isKeyPressed(KeyEvent.VK_UP)) {
            movePlayer(speed, 0);
        }
        else if(Input.isKeyPressed(KeyEvent.VK_W)) {
        	movePlayer(speed, 0);
        }
        
        else if (Input.isKeyPressed(KeyEvent.VK_DOWN)) {
            movePlayer(-speed, 0);
        }
        else if(Input.isKeyPressed(KeyEvent.VK_S)) {
        	movePlayer(-speed, 0);
        }

        if (Input.isKeyPressed(KeyEvent.VK_ADD)) {
            height += 8;
        }
        else if (Input.isKeyPressed(KeyEvent.VK_SUBTRACT)) {
            height -= 8;
        }
    }
    

    private void movePlayer(double speed, double strafe) {
        double vx = speed * Math.cos(angle + strafe);
        double vy = speed * Math.sin(angle + strafe);
        x += vx;
        y += vy;
    }
    
    public void draw(Graphics2D g) {
        g.setColor(new Color((int) (Integer.MAX_VALUE * Math.random())));
        
        int px = (int) (1 * x);
        int py = (int) (1 * y);
        g.fillOval(px - 2, py - 2, 4, 4);
        
        int dx = (int) (10 * Math.cos(angle));
        int dy = (int) (10 * Math.sin(angle));
        g.drawLine(px, py, px + dx, py + dy);
    }

    public Vec2 getDirection() {
        double dx = Math.cos(angle);
        double dy = Math.sin(angle);
        directionVec2.set(dx, dy);
        return directionVec2;
    }
    
}