package chaniagame.nanter1986.com.chaniagame.fragokastello;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 17/8/2016.
 */
public class FragoEight extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,FragoSeven.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,FragoNineOne.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.fragoeigth);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("firsttalktostatue","yes");
        dialogCreator("(A voice from the middle statue)\nTo enter the castle,\nsolve the seven riddles,\n to ring the seven bells.",R.drawable.blackpic,"green");

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
        areasong= JukeBox.MEMORIES;
        esH.updateEvent("song",areasong.getName());
    }
}
