package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class Gialos extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,Limnaki.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,Karavopetra.class);
    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("elafonisiGreenStone").equals("no")) {
            if (esH.readEvent("elafonisiFishingRod").equals("no")) {
                dialogCreator("I see something shinny in the water.\nI can't reach it...");
            } else if (esH.readEvent("elafonisiFishingRod").equals("yes")) {
                esH.updateEvent("elafonisiGreenStone", "yes");
                dialogCreator("You reach for the shinny thing with the fishing rod.\nIt's a green stone.");
            }
        }else{
            dialogCreator("Nothing interesting here.");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.gialos);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bWest.setText("West");
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
