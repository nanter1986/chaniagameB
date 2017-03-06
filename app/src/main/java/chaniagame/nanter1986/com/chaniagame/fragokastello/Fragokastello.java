package chaniagame.nanter1986.com.chaniagame.fragokastello;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 17/8/2016.
 */
public class Fragokastello extends RoomMaker {
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
        intentCreator(this,FragoOneOne.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.fragoone);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass","frago");
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
        areasong= JukeBox.MEMORIES;
        esH.updateEvent("song",areasong.getName());
    }
}
