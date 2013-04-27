package com.herodevelop.hdlibgdx.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Image extends TextureRegion {

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
