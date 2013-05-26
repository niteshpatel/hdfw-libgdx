package com.herodevelop.hdlibgdx;

import com.badlogic.gdx.Gdx;

public class Audio {

    public static class Sound {

        final com.badlogic.gdx.audio.Sound sound;

        public Sound(String s) {
            this.sound = Gdx.audio.newSound(Gdx.files.internal(s));
        }

        public void play(float volume) {
            sound.play(volume);
        }

        public void dispose() {
            sound.dispose();
        }
    }
}
