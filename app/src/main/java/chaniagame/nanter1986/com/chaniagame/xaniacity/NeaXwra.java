package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class NeaXwra extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,AbandondedHotel.class);
    }

    @Override
    public void east(View east) {
        if (esH.readEvent("knowHandMonument").equals("yes")) {
            intentCreator(this,HandMonument.class);
        } else {
            intentCreator(this, Bar.class);

        }
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.neaxwra);
    }








    @Override
    public void setStartingTextOptions() {


        dialogCreator("It's full of tourists.", R.drawable.blackpic, "red");


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
        areasong= JukeBox.DROP;
        esH.updateEvent("song",areasong.getName());
    }


}
