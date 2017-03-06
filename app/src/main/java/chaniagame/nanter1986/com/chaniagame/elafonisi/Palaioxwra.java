package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class Palaioxwra extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,Karavopetra.class);
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("elafonisiBlueStone").equals("no")) {
            if (esH.readEvent("elafonisiFishingRod").equals("no")) {
                dialogCreator("I see something shinny in the hole\non the wall.\nI can't reach it with my hand.");
            } else if (esH.readEvent("elafonisiFishingRod").equals("yes")) {
                esH.updateEvent("elafonisiBlueStone", "yes");
                dialogCreator("You reach for the shinny thing with the fishing rod.\nIt's a blue stone.");
            }
        }else{
            dialogCreator("Nothing interesting here.");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.palaioxwrakastro);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass","palaioxwra");
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
