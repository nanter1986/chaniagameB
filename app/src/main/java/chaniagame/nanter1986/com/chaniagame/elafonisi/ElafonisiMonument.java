package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class ElafonisiMonument extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,WeirdRock.class);
    }

    @Override
    public void west(View west) {
        intentCreator(this,ElafonisiCross.class);
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.elafonisimonument);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("elafonisiFreshWater").equals("no")) {
            if (esH.readEvent("elafonisiDaughter").equals("no")) {
                dialogCreator("[TOURIST WOMAN]I can't find my daughter.\nPlease help me find her,\n and I will give you anything you want.");

            } else if(esH.readEvent("elafonisiDaughter").equals("yes")){
                esH.updateEvent("elafonisiFreshWater","yes");
                esH.updateEvent("elafonisiDaughter","used");
                dialogCreator("[TOURIST WOMAN]OMG thank you! You want that bottle of water?\nOk here take it.");
            }else{

            }
        }
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("South");
            bWest.setText("West");
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
