package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;
import com.herodevelop.hdlibgdx.assets.File;

public class Files {

    public final File internal(String s) {
        return (File) Gdx.files.internal(s);
    }
}
