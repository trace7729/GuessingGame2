package com.example.hole1.guessinggame2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This Activity is based on the Empty Activity template.
 * It displays the fragment for the setting.
 */
public class SettingsActivity extends AppCompatActivity {
    public static final String KEY_SOUND_SWITCH = "sound_switch";

    /**
     * Replaces the content with the fragment to display it.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}