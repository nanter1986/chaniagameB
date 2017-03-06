package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.StoryElafonisiCross;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class ElafonisiCross extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {
        intentCreator(this, ElafonisiMonument.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.elafonisicross);
    }

    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("elafonisiDaughter").equals("no")) {
            dialogCreator("The crossing is pulsing with a red color.\nYou touch it and you are transferred...");
            Handler hd = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    toCrossStory();
                }
            };
            hd.postDelayed(r,5000);
        } else {

        }

    }

    private void toCrossStory() {
        intentCreator(this, StoryElafonisiCross.class);
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bEast.setText("East");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }


    @Override
    public void setAreaSong() {
        areasong= JukeBox.BITTERSWEET;
        esH.updateEvent("song",areasong.getName());
    }
}
