package com.game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.security.KeyException;

public class GamePanel extends JPanel implements Runnable {

    public static int WIDTH = 400;
    public static int HEIGHT = 400;
    private Thread thread;
    private boolean running;

    private BufferedImage image;
    private Graphics2D g;
    private int FPS = 30;
    private double averageFPS;


    private Player player;
    private KeyInput keyInput;

    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        keyInput = new KeyInput();
        addKeyListener(keyInput);
        player = new Player(keyInput);

    }

    //

    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }


    }

    @Override
    public void run() {
        running = true;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        player = new Player(keyInput);

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;

        int frameCount = 0;
        int maxFrameCount = 30;

        long targetTime = 1000/ FPS;

        // Game Loop
        while(running){

            startTime = System.nanoTime();

            gameUpdate();
            gameRender();
            gameDraw();

            URDTimeMillis = (System.nanoTime() - startTime) / 1_000_000;
            waitTime = targetTime - URDTimeMillis;

            try{
                Thread.sleep(waitTime);
            } catch (Exception e){
                e.printStackTrace();
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;

            if(frameCount == maxFrameCount){
                averageFPS = 1000.0 / ((totalTime / frameCount) / 1_000_000);
                frameCount = 0;
                totalTime = 0;
            }
        }
    }

    private void gameUpdate(){
        player.update();
    }

    private void gameRender(){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString("FPS: " + averageFPS, 10, 10);
        player.draw(g);
    }

    private void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0 , null);
        g2.dispose();
    }

/**
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            player.setLeft(true);
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            player.setRight(true);
        }

        if(keyCode == KeyEvent.VK_UP){
            player.setUp(true);
        }

        if(keyCode == KeyEvent.VK_DOWN){
            player.setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            player.setLeft(false);
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            player.setRight(false);
        }

        if(keyCode == KeyEvent.VK_UP){
            player.setUp(false);
        }

        if(keyCode == KeyEvent.VK_DOWN){
            player.setDown(false);
        }
    }
    */
}
