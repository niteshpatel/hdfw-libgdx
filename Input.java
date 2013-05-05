package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;

public class Input {

    public final boolean isTouched() {
        return Gdx.input.isTouched();
    }

    public final boolean justTouched() {
        return Gdx.input.justTouched();
    }

    public final int getX() {
        return (int) (Gdx.input.getX() / (Gdx.graphics.getWidth() / 360f));
    }

    public final int getY() {
        return (int) (640f - (Gdx.input.getY() / (Gdx.graphics.getHeight() / 640f)));
    }
}
