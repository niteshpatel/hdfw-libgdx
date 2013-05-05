package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class App {
    String tag;
    Preferences prefs;

    public App(String tag) {
        this.prefs = Gdx.app.getPreferences(tag);
        this.tag = tag;
    }

    public final void log(String s) {
        Gdx.app.log(this.tag, s);
    }

    public final String getPreference(String key, String defValue) {
        return prefs.getString(key, defValue);
    }

    public final void setPreference(String key, String value) {
        prefs.putString(key, value);
    }

    public final void flushPreferences() {
        prefs.flush();
    }
}
