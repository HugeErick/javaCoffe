package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {
    private BufferedImage bufferedScreen;
    protected Graphics2D g2;
    public boolean fullScreenOn;

    private final int screenWidth = 700;
    private final int screenHeight = 400;
    public int screenWidthForMax = screenWidth;
    public int screenHeightForMax = screenHeight;

    private Thread gameThread;
    final int fps = 60;
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //CHANGE COLOR!!
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(StartGame.window);

        screenWidthForMax = StartGame.window.getWidth();
        screenHeightForMax = StartGame.window.getHeight();
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
                draw();
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
        bufferedScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)bufferedScreen.getGraphics();

        if (fullScreenOn)
            setFullScreen();
    }
    public void draw() {
        //drawMisc();
        drawToScreen();
    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(bufferedScreen, 0, 0, screenWidthForMax, screenHeightForMax, null);
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
}
