import button.Button1;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.rCore;
import com.raylib.java.raymath.Vector2;
import mouse.Mouse;
import static com.raylib.java.core.input.Mouse.MouseButton.*;
import com.raylib.java.textures.*;

public class GUI {
    //public Raylib rlj;
//    Button1 btn = new Button1();
    public GUI() {
//        rlj = new Raylib();
//        rlj.core.InitWindow(GuiWidth, GuiHeight, "Raylib-J Example");
//        rlj.core.SetTargetFPS(60);
//
//        while (!rlj.core.WindowShouldClose()) {
//            //update();
//            draw();
//        }
//        //des-initialization
//        unload();

        int screenWidth = 800;
        int screenHeight = 450;

        Raylib rlj = new Raylib(screenWidth, screenHeight, "raylib-j [textures] example - image loading");

        // NOTE: Textures MUST be loaded after Window initialization (OpenGL context is required)

        Image image = rTextures.LoadImage("assets/b.png"); // Loaded in CPU memory (RAM)
        Texture2D texture = rTextures.LoadTextureFromImage(image); // Image converted to texture, GPU memory (VRAM)

        rTextures.UnloadImage(image);   // Once image has been converted to texture and uploaded to VRAM, it can be
        // unloaded from RAM
        //---------------------------------------------------------------------------------------

        // Main game loop
        while (!rlj.core.WindowShouldClose()) {   // Detect window close button or ESC key
            // Update
            //----------------------------------------------------------------------------------
            // TODO.txt: Update your variables here
            //----------------------------------------------------------------------------------

            // Draw
            //----------------------------------------------------------------------------------
            rlj.core.BeginDrawing();

            rlj.core.ClearBackground(Color.RAYWHITE);

            rlj.textures.DrawTexture(texture, screenWidth/2 - texture.width/2, screenHeight/2 - texture.height/2,
                    Color.WHITE);

            rlj.text.DrawText("this IS a texture loaded from an image!", 300, 370, 10, Color.GRAY);

            rlj.core.EndDrawing();
            //----------------------------------------------------------------------------------
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        rlj.textures.UnloadTexture(texture);       // Texture unloading
    }

    }

//    void update() {
//        mouse.mousePoint = rlj.core.GetMouseDelta();
//        btn.btnAction = false;
//        if (rlj.shapes.CheckCollisionPointRec(mouse.mousePoint, btn.rectangleBtn)) {
//            if (rCore.IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
//                //btn state = 2
//            }
//            else {
//                //btn state = 1
//            }
//            if (rlj.core.IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) btn.btnAction = true;
//        } else {
//            //btn state = 0
//        }
//
//        if (btn.btnAction) {
//            System.out.println("hi nigga\n");
//        }
//    }

//    void draw() {
//        rlj.core.BeginDrawing();
//        rlj.core.ClearBackground(Color.RAYWHITE);
//        rlj.textures.DrawTexture(btn.textureBtn,GuiWidth/2 - btn.textureBtn.width/2, GuiHeight/2 - btn.textureBtn.height/2, Color.GREEN);
//        rlj.core.EndDrawing();
//    }

//    void unload() {
//        btn.unloadImageBtns();
//        rlj.textures.UnloadTexture(btn.textureBtn);
//        rlj.core.CloseWindow();
//    }


