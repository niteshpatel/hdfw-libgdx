package com.herodevelop.hdlib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.herodevelop.hdlib.Files.File;

public class Graphics {

    private final SpriteBatch spriteBatch;

    public Graphics() {
        this.spriteBatch = new SpriteBatch();
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
        ShapeRenderer shapeRenderer = new ShapeRenderer();
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
