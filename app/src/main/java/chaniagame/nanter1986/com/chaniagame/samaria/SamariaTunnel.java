package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaTunnel extends RoomMaker {


    @Override
    public void north(View north) {
        dialogCreator("The trapdoor can't be opened from this side.");
        exitForward();
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaPrison.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("Nothing interesting here");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.tunnelone);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("Up");
            bSouth.setText("Forward");

        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
