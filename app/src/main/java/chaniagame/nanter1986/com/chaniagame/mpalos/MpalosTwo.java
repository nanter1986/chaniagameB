package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class MpalosTwo extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,MpalosThree.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,Mpalos.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpalostworoad);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
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
        areasong= JukeBox.WAR;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.unlock);
        effect1.setLooping(true);
        effect1.setVolume(0.6f, 0.6f);
        effect1.start();
    }
}
