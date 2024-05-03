package button;

import com.raylib.java.Raylib;
import com.raylib.java.raymath.Point;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;
import com.raylib.java.textures.rTextures;
import mouse.Mouse;

public class Button1 {
    Mouse mouse = new Mouse();
    public Image image = rTextures.LoadImage("/ponchito/assets/btn1.png");
    public Texture2D textureBtn = rTextures.LoadTextureFromImage(image);
//    public Vector2 position = new Vector2(0, 0);
//    public Rectangle rectangleBtn = new Rectangle(position.x, position.y, textureBtn.width, textureBtn.height);
//    public boolean btnAction = false;

    public void unloadImageBtns() {
        rTextures.UnloadImage(image);
    }



}
