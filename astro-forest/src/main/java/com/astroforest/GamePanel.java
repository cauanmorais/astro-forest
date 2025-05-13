package com.astroforest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// import entity.PLayer;
// import tile.TMXTileManager;
// import tile.TMXTileManager;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS 
    final int originalTileSize = 16; // 16x16 tile 
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48 x 48 tile 
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // Frames Per Second
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    // PLayer player = new PLayer(this, keyH);
    // TMXTileManager tileM = new TMXTileManager(this);

    public GamePanel () {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }

    
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null ) {
            
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                // UPDATE: Update Information such as character positions
                update();
                // DRAW: draw the screen with the updated information 
                repaint();
                delta--;
            }

        }

    }

    public void update () {
        // player.update();
    }

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent (g);

        Graphics2D g2 = (Graphics2D)g;

        // tileM.draw(g2);
        // player.draw(g2);

        g2.dispose();

    }
    
}
