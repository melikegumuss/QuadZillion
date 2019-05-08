package com.quadzillion.core;

public class Settings {
    public class SettingContainer {
        public int WINDOW_WIDTH = 720;
        public int WINDOW_HEIGHT = 1280;
        public double WINDOW_RFPS = 60.0;
        public String WINDOW_THEME_NAME = "default";
        public String FILE_MUSIC_PATH = "./res/sounds/herbal.mp3";
    }

    private SettingContainer settings;

    public interface SettingsInitListener {
        void onInitialize(SettingContainer sc);
    }

    public Settings(SettingsInitListener listener) {
        settings = new SettingContainer();
        listener.onInitialize(settings);
    }

    public int getWindowHeight() {
        return settings.WINDOW_HEIGHT;
    }

    public int getWindowWidth() {
        return settings.WINDOW_WIDTH;
    }

    public double getWindowRFPS() {
        return settings.WINDOW_RFPS;
    }

    public String getWindowThemeName() {
        return settings.WINDOW_THEME_NAME;
    }

    public String getWindowThemeCSSPath() {
        return "/" + settings.WINDOW_THEME_NAME + "/theme.css";
    }

    public void setWindowThemeName(String name) {
        settings.WINDOW_THEME_NAME = name;
    }

    public String getFileMusicPath() {
        return settings.FILE_MUSIC_PATH;
    }
}
