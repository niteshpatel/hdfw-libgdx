package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Files {

    public final File internal(String s) {
        return new File(Gdx.files.internal(s));
    }

    public static class File {
        public FileHandle fileHandle;

        public File(FileHandle fileHandle) {
            this.fileHandle = fileHandle;
        }
    }
}
