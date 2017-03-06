package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class StoryTeller extends Activity {

    public ImageView b;
    public TextView t;
    public Button bForward;
    public Handler handlerForDialog;
    public String textForDialog;
    public int l;
    public int i;
    public String rollingText;
    public MediaPlayer mp;
    public int musicpiece;
    public eventSaver esH;
    public String intentBlocker;
    public JukeBox areasong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_story_first);

        esH = new eventSaver(this);
        intentBlocker = "off";
        t = (TextView) findViewById(R.id.textStory);
        b = (ImageView) findViewById(R.id.backImageStory);
        b.setScaleType(ImageView.ScaleType.FIT_XY);
        bForward = (Button) findViewById(R.id.bStory);
        mp = new MediaPlayer();
        setStartingText();
        setAreaSong();
        //setMusic();
    }

    protected abstract void setMusic();
    public abstract void setAreaSong();

    public abstract void setStartingText();

    public void dialogCreator(String text, int imageID, String color) {

        b.setImageResource(imageID);
        t.setTextColor(Color.parseColor(color));

        handlerForDialog = new Handler();
        textForDialog = text + " ";
        l = textForDialog.length();
        i = 0;
        rollingText = "";
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                rollingText += textForDialog.charAt(i);
                t.setText(rollingText);
                if (i == l - 1) {
                    return;
                }
                i++;
                handlerForDialog.postDelayed(this, 50);
            }
        };
        handlerForDialog.postDelayed(rb, 50);


    }

    public void dialogCreator(String text) {

        t.setTextColor(Color.parseColor("red"));

        handlerForDialog = new Handler();
        textForDialog = text + " ";
        l = textForDialog.length();
        i = 0;
        rollingText = "";
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                rollingText += textForDialog.charAt(i);
                t.setText(rollingText);
                if (i == l - 1) {
                    return;
                }
                i++;
                handlerForDialog.postDelayed(this, 50);
            }
        };
        handlerForDialog.postDelayed(rb, 50);


    }

    public void setBackAudio(int song) {
        if (!(mp == null)) {
            killMusic();
        }
        musicpiece = song;

        mp = MediaPlayer.create(getBaseContext(), musicpiece);
        mp.setLooping(true);
        mp.start();


    }

    protected void killMusic() {
        try {
            mp.release();


        } catch (NullPointerException n) {
            Log.i("oops", "null mp");


        }
        mp = null;

    }

    @Override
    protected void onStop() {
       // killMusic();
        super.onStop();
    }

    public void intentCreator(Context c, Class cl) {
        if (intentBlocker.equals("off")) {
            intentBlocker = "on";
            Intent i = new Intent(c, cl);
            startActivity(i);
            overridePendingTransition(0, 0);
            finish();
        } else {

        }
    }
}
