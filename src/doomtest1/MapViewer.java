
package doomtest1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jose.fortyfive
 */
public class MapViewer extends JPanel {
    
    private BufferedImage texture;
    private int[] textureData;
    
    private BufferedImage offscreen;
    private int[] offscreenData;
    private Graphics2D offscreenG2G;
    
    public static final double MAP_SCALE = 0.15;
    
    private Player player;
    
    public void start() {
        setPreferredSize(new Dimension(800, 600));
        
        try {
            BufferedImage textureTmp = ImageIO.read(MapViewer.class.getResourceAsStream("texture.jpg"));
            texture = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
            texture.getGraphics().drawImage(textureTmp, 0, 0, null);
            textureData = ((DataBufferInt) texture.getRaster().getDataBuffer()).getData();
        } catch (IOException ex) {
            Logger.getLogger(MapViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        offscreen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        offscreenG2G = offscreen.createGraphics();
        offscreenG2G.setBackground(new Color(0, 0, 0, 0));
        offscreenData = ((DataBufferInt) offscreen.getRaster().getDataBuffer()).getData();
        player = new Player(10, 0, 0);
        
        addKeyListener(new Input());
    }
    
    private void update() {
        player.update();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        update();
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(400, 300);
        g2d.scale(1, -1);
        
        player.draw(g2d);
        
        offscreenG2G.clearRect(0, 0, 800, 600);
        drawFloorTest(offscreenG2G);
        
        g2d.drawImage(offscreen, -400, -300, null);
        
        try {
            Thread.sleep(1000 / 120);
        } catch (InterruptedException ex) { }
        
        repaint();
    }
    private static final double TAN_45_DEG = Math.tan(Math.toRadians(45));
    private static final double[] FLOOR_Y_INV = new double[300];
    private static final double CANVAS_HEIGHT_INV = 1.0 / 800.0;
    
    static {
        for (int y = 1; y < 300; y++) {
            FLOOR_Y_INV[y] = 1.0 / y;
        }
    }
    
    private void drawFloorTest(Graphics2D g) {
        double planeDistance = 400;
        Vec2 playerDir = player.getDirection();
        for (int y = 1; y < 300; y++) {
            double z = planeDistance * player.height * FLOOR_Y_INV[y];
            
            double px = playerDir.x * z + player.x;
            double py = playerDir.y * z + player.y;
            
            double lateralLength = TAN_45_DEG * z;
            
            double leftX = -playerDir.y * lateralLength + px;
            double leftY = playerDir.x * lateralLength + py;
            double rightX = playerDir.y * lateralLength + px;
            double rightY = -playerDir.x * lateralLength + py;
            
            double dx = (rightX - leftX) * CANVAS_HEIGHT_INV;
            double dy = (rightY - leftY) * CANVAS_HEIGHT_INV;
            double worldX = leftX;
            double worldY = leftY;
            for (int screenX = 0; screenX < 800; screenX++) {
                int textureX = (int) Math.abs((int) worldX) % 400;
                int textureY = (int) Math.abs((int) worldY) % 400;
                int c = textureData[textureY * 400 + textureX];
                offscreenData[(300 - y) * 800 + screenX] = c;
                worldX += dx;
                worldY += dy;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MapViewer doomFloorCeilingRenderingTest = new MapViewer();
            doomFloorCeilingRenderingTest.start();
            JFrame frame = new JFrame();
            frame.setTitle("DOOM floor and ceiling rendering Test #2");
            frame.getContentPane().add(doomFloorCeilingRenderingTest);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            doomFloorCeilingRenderingTest.requestFocus();
        });
    }
    
}