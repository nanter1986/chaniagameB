package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

import java.util.Random;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Faros extends RoomMaker {


    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.unlock);
        effect1.setLooping(true);
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }

    @Override
    public void north(View north) {

    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("An old lighthouse", R.drawable.blackpic, "red");

    }


    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("South");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }



    @Override
    public void setAreaSong() {
        areasong = JukeBox.DANGER;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void south(View south) {

        intentCreator(this, Tzami.class);


    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

        if (esH.readEvent("lighthousedoor").equals("unlocked")) {
            unlocked();
        } else if (esH.readEvent("lighthousekey").equals("yes")) {
            keyyes();
        } else {
            keyno();
        }

    }

    private void unlocked() {
        intentCreator(this, InsideLighthouse.class);
    }

    private void keyno() {
        Random rand = new Random();
        int n = rand.nextInt(9);
        if (n == 0) {
            dialogCreator("Was that a woman's scream?", R.drawable.blackpic, "red");
            exitForward();
        } else {
            dialogCreator("It's locked", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void keyyes() {
        effect2.start();
        esH.updateEvent("lighthousedoor", "unlocked");
        esH.updateEvent("lighthousekey", "used");
        dialogCreator("You open the door with the key", R.drawable.blackpic, "red");
        Handler handlerkey = new Handler();
        Runnable rkey = new Runnable() {
            @Override
            public void run() {
                goin();
            }
        };
        handlerkey.postDelayed(rkey, 2000);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.faros);
    }


    public void goin() {
        intentCreator(this, InsideLighthouse.class);
    }

}
