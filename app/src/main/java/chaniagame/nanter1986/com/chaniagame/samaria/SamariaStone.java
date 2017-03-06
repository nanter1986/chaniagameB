package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaStone extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this, SamariaBlue.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this, SamariaTree.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("");
        if (esH.readEvent("samariashovel").equals("yes")) {
            digging1();

        } else if (esH.readEvent("samariashovel").equals("used")) {
            dialogCreator("The hole is still there");
            exitForward();
        } else if (esH.readEvent("samariashovel").equals("no")) {

        }
    }

    private void digging1() {
        esH.updateEvent("samariashovel", "used");
        esH.updateEvent("keyforblue", "yes");
        dialogCreator("You dig under the bridge.\nYou obtained the old house key.");
        exitForward();
    }


    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariastone);
    }


    @Override
    public void setStartingTextOptions() {

        dialogCreator("An old stone bridge.", R.drawable.blackpic, "red");
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
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
