package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 24/8/2016.
 */
public class AkrotiriMonastery extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,AkrotiriSeven.class);
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
        b.setImageResource(R.drawable.akrotirimonastery);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("akrotiriknowchurchkey","yes");
        dialogCreator("Something is written on the floor:\nThe devil holds the key for heaven\n in hell");
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,true,false,false);
    }



    @Override
    public void setAreaSong() {
        areasong = JukeBox.REALDANGER;
        esH.updateEvent("song", areasong.getName());
    }
}
