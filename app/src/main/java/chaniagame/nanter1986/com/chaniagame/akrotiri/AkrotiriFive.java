package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriFive extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,AkrotiriFour.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,AkrotiriSix.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirifive);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,true,true);
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.HELPINGHAND;
        esH.updateEvent("song",areasong.getName());
    }
}
