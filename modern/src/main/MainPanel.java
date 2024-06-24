package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements Runnable {
    protected Graphics2D g2;
    private final int screenWidth = 700;
    private final int screenHeight = 400;
    public int screenWidthForMax = screenWidth;
    public int screenHeightForMax = screenHeight;

    private Thread gameThread;
    final int fps = 60;

    public MainPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        Color night = new Color(11, 11, 11);
        this.setBackground(night);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
    }

    @Override
    public void run() {
        double billion = 1000000000;
        double drawInterval = billion/(double)fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                //update();
                //draw();
                delta--;
                drawCount++;
            }

            if (timer >= billion){
                System.out.println("hi " + drawCount + "\n" );
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void setUpGame() {
        BufferedImage bufferedScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D) bufferedScreen.getGraphics();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
}
