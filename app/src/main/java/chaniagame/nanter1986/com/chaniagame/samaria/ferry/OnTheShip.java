package chaniagame.nanter1986.com.chaniagame.samaria.ferry;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 9/8/2016.
 */
public class OnTheShip extends RoomMaker {

    @Override
    public void north(View north) {
        intentCreator(this,OnTheShipBenches.class);
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

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ferryone);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass","ontheship");
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

    }
}
