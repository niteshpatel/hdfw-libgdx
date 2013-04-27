package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.herodevelop.hdlibgdx.assets.Font;
import com.herodevelop.hdlibgdx.assets.Image;

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
}
