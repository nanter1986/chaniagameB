package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.RingStory;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriTen extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,AkrotiriNine.class);
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
        b.setImageResource(R.drawable.akrotiriten);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("talisman").equals("yes")){
            esH.updateEvent("talisman","used");
            dialogCreator("That's impossible...\nIt's not over yet...\nYou will hear from me sooooon....", R.drawable.blackcoat, "green");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    talisman();
                }
            });
        }else {
            esH.updateEvent("akrotiriairportfirst","yes");
            dialogCreator("I will not allow you to succeed.\nYou have no power over me in this mind.", R.drawable.blackcoat, "green");
            exitForward();
        }
    }

    private void talisman() {
        intentCreator(this,RingStory.class);
    }

    @Override
    public void onNavOn() {
        navigationAssigner(true,false,false,false);
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.HELPINGHAND;
        esH.updateEvent("song",areasong.getName());
    }
}
