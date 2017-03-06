package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class Mpalos extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this, MpalosTwo.class);
    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if (esH.readEvent("mpalosChurchOneDoor").equals("yes")) {
            enterChurch();
        } else {
            if (esH.readEvent("mpalosChurchOneKey").equals("no")) {
                locked();

            } else if (esH.readEvent("mpalosChurchOneKey").equals("yes")) {
                unlock();

            } else {

            }
        }
    }

    private void unlock() {
        esH.updateEvent("mpalosChurchOneKey", "used");
        esH.updateEvent("mpalosChurchOneDoor", "yes");
        effect2.start();
        dialogCreator("You unlocked the door.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterChurch();
            }
        });
    }

    private void enterChurch() {
        intentCreator(this, MpalosInsideChurchOne.class);
    }

    private void locked() {
        dialogCreator("It's locked");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpalosonechurch);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass", "mpalos");
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
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
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
