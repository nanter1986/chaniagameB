package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 8/8/2016.
 */
public class SamariaLadder extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,SamariaAncient.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaBlood.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("A ladder is going up.\nProbably on the gorge path.", R.drawable.blackpic, "red");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samarialadder);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("Up");
            bSouth.setText("Back");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.HOTEL;
        esH.updateEvent("song",areasong.getName());
    }
}
