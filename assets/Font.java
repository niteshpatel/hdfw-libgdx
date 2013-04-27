package com.herodevelop.hdlibgdx.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Font extends BitmapFont {

    public Font(FileHandle f, boolean b) {
        super(f, b);
    }

    public Font(String s, boolean b) {
        this(Gdx.files.internal(s), b);
    }
}
