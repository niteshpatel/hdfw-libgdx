package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.herodevelop.hdlibgdx.Files.File;

public class Graphics {

    private final SpriteBatch spriteBatch;
    private final ShapeRenderer shapeRenderer;

    public Graphics(int width, int height) {
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        // Resolution scaling setup
        Matrix4 matrix4 = GetCamera(width, height).combined;
        this.spriteBatch.setProjectionMatrix(matrix4);
        this.shapeRenderer.setProjectionMatrix(matrix4);
    }

    /* from http://rotatingcanvas.com/game-development-in-android-using-libgdx-part-iii-2/ */
    private static OrthographicCamera GetCamera(float virtualWidth, float virtualHeight) {
        float viewportWidth;
        float viewportHeight;
        float physicalWidth = Gdx.graphics.getWidth();
        float physicalHeight = Gdx.graphics.getHeight();
        float aspect = virtualWidth / virtualHeight;
        //This is to maintain the aspect ratio.
        //If the virtual aspect ration does not match with the aspect ratio
        //of the hardware screen then the viewport would scaled to
        //meet the size of one dimension and other would not cover full dimension
        //If we stretch it to meet the screen aspect ratio then textures will
        //get distorted either become fatter or elongated
        if (physicalWidth / physicalHeight >= aspect) {
            // Letterbox left and right.
            viewportHeight = virtualHeight;
            viewportWidth = viewportHeight * physicalWidth / physicalHeight;
        } else {
            // Letterbox above and below.
            viewportWidth = virtualWidth;
            viewportHeight = viewportWidth * physicalHeight / physicalWidth;
        }

        OrthographicCamera camera = new OrthographicCamera(viewportWidth, viewportHeight);
        camera.position.set(virtualWidth / 2, virtualHeight / 2, 0);
        camera.update();
        return camera;
    }

    public final int getWidth() {
        return Gdx.graphics.getWidth();
    }

    public final int getHeight() {
        return Gdx.graphics.getHeight();
    }

    public final void drawRect(
            float x,
            float y,
            float width,
            float height,
            float red,
            float green,
            float blue,
            float alpha) {
        // Draw an shape at x, y with given width, height, and tint
        Gdx.gl.glEnable(GL10.GL_BLEND);
        shapeRenderer.setProjectionMatrix(GetCamera(width, height).combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.FilledRectangle);
        shapeRenderer.setColor(red, blue, green, alpha);
        shapeRenderer.filledRect(x, y, width, height);
        shapeRenderer.end();
    }

    public final void drawImage(
            Image image,
            float x,
            float y,
            float scale,
            float rotation,
            float red,
            float green,
            float blue,
            float alpha) {
        // Draw an image at x, y with given scale, rotation, and tint
        spriteBatch.begin();
        Sprite sprite = new Sprite(image);
        sprite.setPosition(x, y);
        sprite.setScale(scale);
        sprite.setRotation(rotation);
        sprite.setColor(red, green, blue, alpha);
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    public final void drawImage(
            Image image,
            float x,
            float y,
            float scale,
            float rotation) {
        // Draw an image at x, y with given scale and rotation
        this.drawImage(image, x, y, scale, rotation, 1, 1, 1, 1);
    }

    public final void drawImage(
            Image image,
            float x,
            float y) {
        // Draw an image at x, y
        this.drawImage(image, x, y, 1, 0, 1, 1, 1, 1);
    }

    public final void drawFont(String string, Font font, float x, float y) {
        spriteBatch.begin();
        font.draw(spriteBatch, string, x, y);
        spriteBatch.end();
    }

    public final void clear() {
        GLCommon gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    public static class Image extends TextureRegion {
        public Image(Texture texture) {
            super(texture);
        }

        public Image(File f) {
            this(new Texture(f));
        }

        public Image(String s) {
            this(new Texture(Gdx.files.internal(s)));
        }
    }

    public static class Font extends BitmapFont {
        public Font(FileHandle f, boolean b) {
            super(f, b);
        }

        public Font(String s, boolean b) {
            this(Gdx.files.internal(s), b);
        }
    }
}
