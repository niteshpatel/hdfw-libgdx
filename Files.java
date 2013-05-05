package com.herodevelop.hdlib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Files {

    public final File internal(String s) {
        return (File) Gdx.files.internal(s);
    }

    public static class File extends FileHandle {
    }
}
