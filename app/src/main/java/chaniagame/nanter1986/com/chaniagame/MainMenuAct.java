package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import chaniagame.nanter1986.com.chaniagame.akrotiri.Akrotiri;
import chaniagame.nanter1986.com.chaniagame.elafonisi.Palaioxwra;
import chaniagame.nanter1986.com.chaniagame.fragokastello.Fragokastello;
import chaniagame.nanter1986.com.chaniagame.mpalos.Mpalos;
import chaniagame.nanter1986.com.chaniagame.samaria.SamariaEntrance;
import chaniagame.nanter1986.com.chaniagame.samaria.ferry.OnTheShip;
import chaniagame.nanter1986.com.chaniagame.stories.BadEnding;
import chaniagame.nanter1986.com.chaniagame.stories.BadEndingB;
import chaniagame.nanter1986.com.chaniagame.stories.GoodEnding;
import chaniagame.nanter1986.com.chaniagame.stories.StoryFirst;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

public class MainMenuAct extends Activity {

    eventSaver esH;
    MediaPlayer mp;
    boolean ready = false;
    Button bPlay;

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mp.release();
        //     mp = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_menu);
        esH = new eventSaver(this);
        bPlay = (Button) findViewById(R.id.bPlay);
        createState();


    }


    public void play(View play) {
        try {
            if (ready) {
                Intent srv = new Intent(this, MusicBackground.class);
                startService(srv);
                if (esH.readEvent("startingclass").equals("neaxwra")) {
                    Intent story = new Intent(this, StoryFirst.class);
                    startActivity(story);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("samaria")) {
                    Intent s = new Intent(this, SamariaEntrance.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("ontheship")) {
                    Intent s = new Intent(this, OnTheShip.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("palaioxwra")) {
                    Intent s = new Intent(this, Palaioxwra.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("ktel")) {
                    Intent s = new Intent(this, Ktel.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("frago")) {
                    Intent s = new Intent(this, Fragokastello.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("mpalos")) {
                    Intent s = new Intent(this, Mpalos.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("akrotiri")) {
                    Intent s = new Intent(this, Akrotiri.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("badend")) {
                    Intent s = new Intent(this, BadEnding.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("badendB")) {
                    Intent s = new Intent(this, BadEndingB.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                } else if (esH.readEvent("startingclass").equals("goodend")) {
                    Intent s = new Intent(this, GoodEnding.class);
                    startActivity(s);
                    overridePendingTransition(0, 0);
                    finish();
                }
                Log.i("dbc", "normal");
            } else {

            }
        }catch(Exception e){
            Log.i("dbc", "frmScratch");
            dbCreateFromScratch();
        }

    }

   /* public void deleteT(View deletet){
        esH.deleteTable();
        createState();
    }*/

    public void saveM(View sm) {
        Intent s = new Intent(this, SaveManager.class);
        startActivity(s);
        overridePendingTransition(0, 0);
        finish();
    }

    private void createState() {
        Log.i("dbc", "started0");
        try {
            if (esH.checkExistence("startingclass")) {
                Log.i("dbc", "started1");
                ready = true;
                bPlay.setText("Play");
            }
        } catch (Exception e) {
            dbCreateFromScratch();
        }
    }

    private void dbCreateFromScratch() {
        Log.i("dbc", "started2");
        SQLiteDatabase db = esH.getWritableDatabase();
        esH.onCreate(db);

        //CURRENT LOCATION *******************************************************************
        esH.addToTable("currentLocation", "NeaXwra");
        esH.addToTable("gotMagicNotebook", "no");
        //MEMORIES DONE ************************************************************************

        esH.addToTable("donesamaria", "no");
        esH.addToTable("doneelafonisi", "no");
        esH.addToTable("doneakrotiri", "no");
        esH.addToTable("donempalos", "no");
        esH.addToTable("donefragokastello", "no");
        esH.addToTable("allFiveDonesDone", "no");

        //SONG ********************************************************************************

        esH.addToTable("song", "memories");


        //STARTING POINT***********************************************************************

        esH.addToTable("startingclass", "neaxwra");

        //CHANIA SAVES *************************************************************************


        esH.addToTable("storycollected5", "no");

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

        //SAMARIA SAVES *********************************************************************
        esH.addToTable("leverchurch", "no");
        esH.addToTable("pondtourist", "no");
        esH.addToTable("whirlpoolstory", "no");
        esH.addToTable("churchtrapdoor", "no");
        esH.addToTable("bluekey", "no");
        esH.addToTable("keyforblue", "no");


        esH.addToTable("knowshovel", "no");
        esH.addToTable("samariashovel", "no");

        esH.addToTable("cabindoor", "no");
        esH.addToTable("cabinkey", "no");
        esH.addToTable("closetkey", "no");
        esH.addToTable("closetdoor", "no");
        esH.addToTable("knowtv", "no");
        esH.addToTable("knoworder", "no");

        //AKROTIRI SAVES **********************************************************************
        esH.addToTable("talisman", "no");

        esH.addToTable("akrotiriknowfisherman", "no");
        esH.addToTable("akrotiriairportfirst", "no");

        esH.addToTable("akrotirimonasterykey", "no");
        esH.addToTable("akrotirimonasterydoor", "no");

        esH.addToTable("akrotiriring", "no");

        esH.addToTable("akrotirihandopen", "no");
        esH.addToTable("akrotiriknowchurchkey", "no");
        esH.addToTable("akrotirichurchkey", "no");
        esH.addToTable("akrotirichurchdoor", "no");

        //FRAGOKASTELLO SAVES ******************************************************************

        esH.addToTable("firsttalktostatue", "no");

        esH.addToTable("riddle1", "no");
        esH.addToTable("riddle4", "no");
        esH.addToTable("riddle5", "no");
        esH.addToTable("riddle6", "no");
        esH.addToTable("riddle7", "no");
        esH.addToTable("riddle10", "no");
        esH.addToTable("riddle11", "no");

        //ELAFONISI SAVES ***********************************************************************

        esH.addToTable("elafonisiFishingRod", "no");
        esH.addToTable("elafonisiFreshWater", "no");
        esH.addToTable("elafonisiDaughter", "no");

        esH.addToTable("elafonisiBlueStone", "no");
        esH.addToTable("elafonisiGreenStone", "no");
        esH.addToTable("elafonisiRedStone", "no");
        esH.addToTable("elafonisiBlackStone", "no");

        //MPALOS SAVES ***************************************************************************

        esH.addToTable("mpalosChurchOneKey", "no");
        esH.addToTable("mpalosChurchOneDoor", "no");

        esH.addToTable("mpalosChurchTwoKey", "no");
        esH.addToTable("mpalosChurchTwoDoor", "no");

        esH.addToTable("mpalosCrystalBallBlue", "no");
        esH.addToTable("mpalosCrystalBallGreen", "no");
        esH.addToTable("mpalosCrystalBallRed", "no");

        //CHANIA AGAIN SAVES ********************************************************************
        esH.addToTable("talkToBoatMan", "no");
        esH.addToTable("knowAboutNecklace", "no");
        esH.addToTable("knowHandMonument", "no");
        esH.addToTable("saidTicket", "no");

        esH.addToTable("handGun", "no");

        esH.addToTable("killedBarwoman", "no");
        esH.addToTable("killedBoatman", "no");
        esH.addToTable("killedTzamiDoor", "no");
        esH.addToTable("tzamiDoorUnlocked", "no");
        esH.addToTable("gotTzamiNecklace", "no");

        esH.addToTable("gotsinner", "notyet");


        ready = true;
        bPlay.setText("Play");


    }
}

