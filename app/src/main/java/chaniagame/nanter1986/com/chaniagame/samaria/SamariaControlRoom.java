package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 8/8/2016.
 */
public class SamariaControlRoom extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaAncient.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("It looks like someone moved the furniture\nand all the equipment not long ago.\nThey left a few things pinned on the wall.\nWhat do you want to investigate?");
        bOpt1.setText("Note");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                note();
            }
        });

        exitForward();
    }


    private void note() {
        dialogCreator("A handwritten note:\nA equals 0.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.controlroom);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("Out");

        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.DANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
