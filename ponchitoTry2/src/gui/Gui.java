package gui;

import javax.swing.*;

public class Gui  {
    protected int scene;
    public Gui(int whatScene) {
        scene = whatScene;
        switch (scene) {
        case 0:
            Window window0 = new Window("Ponchito me la pela", 500, 500);
            new LoginPage(window0, this);
            break;
        case 1:
            Window window1 = new Window("Ponchito me la pela", 500, 500);
            new Home(window1, this);
            break;
        default:
            System.out.println("no scene for this");
            System.exit(1);
        }
    }
}
