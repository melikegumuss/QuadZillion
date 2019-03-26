package com.quadzillion.core;

public class Settings
{
    public class SettingContainer
    {
        public int WINDOW_WIDTH;
        public int WINDOW_HEIGHT;
        public double WINDOW_RFPS;
    }

    private SettingContainer settings;

    public interface SettingsInitListener
    {
        void onInitialize(SettingContainer sc);
    }

    public Settings(SettingsInitListener listener)
    {
        settings = new SettingContainer();
        listener.onInitialize(settings);
    }

    public int getWindowHeight()
    {
        return settings.WINDOW_HEIGHT;
    }

    public int getWindowWidth()
    {
        return settings.WINDOW_WIDTH;
    }

    public double getWindowRFPS()
    {
        return settings.WINDOW_RFPS;
    }
}
