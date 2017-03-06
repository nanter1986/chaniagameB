package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Kounoupidiana extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,Tuc.class);
    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,Graveyard.class);
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.kounoupidiana);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("The entrance to the university.",R.drawable.blackpic,"red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
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
        areasong= JukeBox.GOODBYE;
        esH.updateEvent("song",areasong.getName());
    }
}
