package chaniagame.nanter1986.com.chaniagame;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public abstract class RoomMaker extends Activity {
    String classNameNavigation;

    public ImageView b;
    public ImageView f;

    public Button bNorth;
    public Button bSouth;
    public Button bWest;
    public Button bEast;

    public ImageButton bInv;
    public ImageButton bInventory;

    public Button bOpt1;
    public Button bOpt2;
    public Button bOpt3;
    public Button bOpt4;
    public Button bOpt5;
    public Button bForward;
    public TextView t;
    public EditText et;

    public String intentBlocker;
    public String nav;

    public String password;
    public String passwordOffice;
    public eventSaver esH;
    public String keyopen;


    public MediaPlayer effect1;
    public MediaPlayer effect2;

    String rollingText;
    String textForDialog;
    public int i;
    int l;
    public Handler handlerForDialog;
    public Handler handlerForMusic;
    public Handler handlerForNav;
    public int musicpiece;

    public JukeBox areasong;


    public void killMusic() {

        try {

            effect1.release();
            effect2.release();

        } catch (NullPointerException n) {
            Log.i("oops", "null mp");


        }

        effect1 = null;
        effect2 = null;

    }

    @Override
    protected void onPause() {
        super.onPause();
        killMusic();

    }

    @Override
    protected void onResume() {

        super.onResume();
        setEffects();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_agora);

        setEffects();

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        b = (ImageView) findViewById(R.id.backImageStory);
        f = (ImageView) findViewById(R.id.faceImage);

        bInv = (ImageButton) findViewById(R.id.bInv);
        bInv.getBackground().setColorFilter(0xe9fffdc4, PorterDuff.Mode.MULTIPLY);
        bInv.setImageResource(R.drawable.magni);
        bInv.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
        bInventory = (ImageButton) findViewById(R.id.bInventory);
        bInventory.setImageResource(R.drawable.backpack);
        bInventory.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);

        bNorth = (Button) findViewById(R.id.bNorth);
        bSouth = (Button) findViewById(R.id.bSouth);
        bEast = (Button) findViewById(R.id.bEast);
        bWest = (Button) findViewById(R.id.bWest);
        bNorth.getBackground().setColorFilter(0xe4f5553f, PorterDuff.Mode.MULTIPLY);
        bSouth.getBackground().setColorFilter(0xe4f5553f, PorterDuff.Mode.MULTIPLY);
        bWest.getBackground().setColorFilter(0xe4f5553f, PorterDuff.Mode.MULTIPLY);
        bEast.getBackground().setColorFilter(0xe4f5553f, PorterDuff.Mode.MULTIPLY);

        bOpt1 = (Button) findViewById(R.id.bOpt1);
        bOpt1.getBackground().setColorFilter(0xdecaaeff, PorterDuff.Mode.MULTIPLY);
        bOpt2 = (Button) findViewById(R.id.bOpt2);
        bOpt2.getBackground().setColorFilter(0xdecaaeff, PorterDuff.Mode.MULTIPLY);
        bOpt3 = (Button) findViewById(R.id.bOpt3);
        bOpt3.getBackground().setColorFilter(0xdecaaeff, PorterDuff.Mode.MULTIPLY);
        bOpt4 = (Button) findViewById(R.id.bOpt4);
        bOpt4.getBackground().setColorFilter(0xdecaaeff, PorterDuff.Mode.MULTIPLY);
        bOpt5 = (Button) findViewById(R.id.bOpt5);
        bOpt5.getBackground().setColorFilter(0xdecaaeff, PorterDuff.Mode.MULTIPLY);
        bForward = (Button) findViewById(R.id.bForward);
        t = (TextView) findViewById(R.id.textStory);
        et = (EditText) findViewById(R.id.et);
        esH = new eventSaver(this);


        et.setFocusable(false);
        et.setFocusableInTouchMode(false);
        et.setClickable(false);
        et.setBackgroundColor(0xff818a88);


        // createState();
        setBack();
        setAreaSong();

        b.setScaleType(ImageView.ScaleType.FIT_XY);
        f.setScaleType(ImageView.ScaleType.FIT_XY);
        nav = "on";
        intentBlocker = "off";
        onNavOnwithImages();
        classNameNavigation=this.getClass().getSimpleName();
        esH.updateEvent("currentLocation",classNameNavigation);
        Log.i("names",classNameNavigation);
        setStartingText();


    }

    public void itemMenu(View v) {
        if (nav.equals("on")) {
            Intent i = new Intent(this, ItemsMenu.class);
            startActivity(i);
            overridePendingTransition(0, 0);
        } else {

        }
    }

    public void dialogCreator(String text, int imageID, String color) {
        resetOptions();
        f.setImageResource(imageID);
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
        resetOptions();
        f.setImageResource(R.drawable.blackpic);
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


    public void invPre(View inv) {
        if (nav.equals("on")) {
            nav = "off";
            onNavOnwithImages();
            resetOptions();
            investigate(bInv);
            exitForward();
        } else {

        }
    }

    public void northPre(View north) {
        if (nav.equals("on")) {

            north(bNorth);
        } else {

        }
    }

    public void southPre(View South) {
        if (nav.equals("on")) {

            south(bSouth);
        } else {

        }
    }

    public void eastPre(View east) {
        if (nav.equals("on")) {

            east(bEast);
        } else {

        }
    }

    public void westPre(View west) {
        if (nav.equals("on")) {

            west(bWest);
        } else {

        }
    }

   /* private void createState() {
        if (esH.checkExistence("lighthousekey")) {

        } else {
            SQLiteDatabase db = esH.getWritableDatabase();
            esH.onCreate(db);

            esH.addToTable("startingclass","neaxwra");
            esH.addToTable("storycollected5","no");

            esH.addToTable("lighthousedoor", "locked");
            esH.addToTable("lighthousekey", "no");
            esH.addToTable("bracelet", "no");

            esH.addToTable("knowdrink", "no");
            esH.addToTable("drinkgarden", "no");
            esH.addToTable("hoteldoor", "locked");
            esH.addToTable("crowbar", "no");
            esH.addToTable("ring", "no");

            esH.addToTable("knowpills", "no");
            esH.addToTable("officer", "awake");
            esH.addToTable("sleepingpills", "no");
            esH.addToTable("watch", "no");

            esH.addToTable("knowoffice", "no");
            esH.addToTable("officeunlocked", "no");
            esH.addToTable("apostoloidoor", "locked");
            esH.addToTable("apostoloikey", "no");
            esH.addToTable("earring", "no");

            esH.addToTable("knowmpalos", "no");
            esH.addToTable("mpalosticket", "no");
            esH.addToTable("childgrace", "notopened");
            esH.addToTable("shovel", "no");
            esH.addToTable("necklace", "no");


        }
    }*/

    public void resetOptions() {
        bOpt1.setText("----");
        bOpt1.setOnClickListener(null);
        bOpt2.setText("----");
        bOpt2.setOnClickListener(null);
        bOpt3.setText("----");
        bOpt3.setOnClickListener(null);
        bOpt4.setText("----");
        bOpt4.setOnClickListener(null);
        bOpt5.setText("----");
        bOpt5.setOnClickListener(null);
        bForward.setText("--");
        bForward.setOnClickListener(null);
    }

    public void etState(String edit) {
        if (edit.equals("on")) {
            et.setFocusable(true);
            et.setFocusableInTouchMode(true);
            et.setClickable(true);
            et.setBackgroundColor(0xfff00000);
        } else if (edit.equals("off")) {
            et.setFocusable(false);
            et.setFocusableInTouchMode(false);
            et.setClickable(false);
            et.setBackgroundColor(0xff818a88);
        }
    }

    public String toLower(String input) {
        if (input.length() == 0) {
            return "";
        } else {
            return input.toLowerCase();
        }
    }

    public void setStartingText() {
        resetOptions();
        nav = "on";
        onNavOnwithImages();
        f.setImageResource(R.drawable.blackpic);
        t.setText("");

        setStartingTextOptions();
    }

    public int saveValue(String state) {
        if (state.equals("start")) {
            return 1;
        } else if (state.equals("afterChase")) {
            return 2;
        } else if (state.equals("afterBarChat")) {
            return 3;
        } else if (state.equals("afterGraveChat")) {
            return 4;
        } else if (state.equals("afterLightMeet")) {
            return 5;
        } else {
            return 0;
        }
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    @Override
    protected void onStop() {
        if (effect1 == null || effect2 == null) {

        } else {
            killMusic();
        }
        super.onStop();
    }

    public void gameOver() {
        Intent gameover = new Intent(this, GameOver.class);
        startActivity(gameover);
        overridePendingTransition(0, 0);
        finish();
    }

    public void exitForward() {
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStartingText();
            }
        });
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

    public void onNavOnwithImages() {
        if (nav.equals("on")) {
            bInv.setImageResource(R.drawable.magni);
            bInventory.setImageResource(R.drawable.backpack);
        } else if (nav.equals("off")) {
            bInv.setImageResource(R.drawable.blackpic);
            bInventory.setImageResource(R.drawable.blackpic);
        }
        onNavOn();
    }

    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.emptysound);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
    }

    public void navigationAssigner(boolean n, boolean s, boolean e, boolean w) {
        if (nav.equals("on") && n == true) {
            bNorth.setText("North");
        } else {
            bNorth.setText("----");
        }
        if (nav.equals("on") && s == true) {
            bSouth.setText("South");
        } else {
            bSouth.setText("----");
        }
        if (nav.equals("on") && e == true) {
            bEast.setText("East");
        } else {
            bEast.setText("----");
        }
        if (nav.equals("on") && w == true) {
            bWest.setText("West");
        } else {
            bWest.setText("----");
        }
    }


    public abstract void north(View north);

    public abstract void south(View south);

    public abstract void west(View west);

    public abstract void east(View east);

    public abstract void investigate(View investigate);

    public abstract void setBack();

    public abstract void setStartingTextOptions();

    public abstract void onNavOn();


    public abstract void setAreaSong();

}
