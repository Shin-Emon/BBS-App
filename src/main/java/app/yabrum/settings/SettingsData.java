package app.yabrum.settings;

import java.io.Serializable;

public class SettingsData implements Serializable {
    public static final long serialVersionUID = 1L;

    private boolean isThemeMusicEnabled;

    public SettingsData(boolean isThemeMusicEnabled) {
        this.isThemeMusicEnabled = isThemeMusicEnabled;

    }
}
