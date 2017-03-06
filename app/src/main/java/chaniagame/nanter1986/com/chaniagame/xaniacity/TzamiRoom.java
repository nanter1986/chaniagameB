package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.xaniacity.hyperspace.HyperSpaceNecklace;

public class TzamiRoom extends RoomMaker {


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

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.tzamiroom);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("Something is wrong...\nSomething feels wrong...\nAnd this place is empty...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToHyperSpace();
            }
        });
    }

    private void moveToHyperSpace() {
        intentCreator(this,HyperSpaceNecklace.class);

    }


    @Override
    public void onNavOn() {

    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.REALDANGER;
        esH.updateEvent("song", areasong.getName());
    }
}
