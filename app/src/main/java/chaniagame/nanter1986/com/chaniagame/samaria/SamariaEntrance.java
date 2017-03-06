package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaEntrance extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaChurch.class);
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
        b.setImageResource(R.drawable.samariaentrance);
    }



    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass","samaria");
        dialogCreator("The entrance to the famous \ngorge of Samaria.",R.drawable.blackpic,"red");

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
        areasong= JukeBox.HOTEL;
        esH.updateEvent("song",areasong.getName());
    }
}
