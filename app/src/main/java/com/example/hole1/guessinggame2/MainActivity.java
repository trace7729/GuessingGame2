package com.example.hole1.guessinggame2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * This app is based on the Basic Activity template and provides an
 * options menu with the Settings option. The user clicks Settings
 * to show the Settings activity and to change the setting.
 * The app shows a Toast message showing the value of the setting.
 */

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
   public static Boolean switchPref;

    /**
     * Creates the view with a Toolbar and a Floating Action Button.
     * Also sets default values for preference settings
     * and reads those settings.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Sets default values only once, first time this is called.
        // The third argument is a boolean that indicates whether the default values
        // should be set more than once. When false, the system sets the default values
        // only if this method has never been called in the past.
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        // Read settings
        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                (SettingsActivity.KEY_SOUND_SWITCH, false);
        Toast.makeText(this, "Sound Setting: "+switchPref.toString(), Toast.LENGTH_SHORT).show();
        playSoundMain(switchPref);
    }

    /**
     * Inflates the options menu and adds items to the menu.
     *
     * @param menu Options menu
     * @return True if menu is inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles option menu selections and automatically handles clicks
     * on the Up button in the app bar.
     *
     * @param item Item in options menu
     * @return True if Settings is selected in the options menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void playSoundMain(final boolean n){
        final MediaPlayer mp01 =MediaPlayer.create(this,R.raw.black);
        final Handler handler=new Handler();
        btnPlay=(Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(n==true){
                    mp01.start();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Intent b;
                            b = new Intent(getApplicationContext(), GameActivity.class);
                            startActivity(b);
                        }
                    },5000);
                }else{
                    Intent b;
                    b=new Intent(getApplicationContext(), GameActivity.class);
                    startActivity(b);
                }
            }
        });
    }
}