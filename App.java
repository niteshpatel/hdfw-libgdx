package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;

public class App {
    String tag;

    public App(String tag) {
        this.tag = tag;
    }

    public final void log(String s) {
        Gdx.app.log(this.tag, s);
    }
}
