package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class policeStation extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,Garden.class);
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
        dialogCreator("Do you want to enter the police station?", R.drawable.blackpic, "red");

        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(null);
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                poffice();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(null);
        bOpt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                t.setText("");
            }
        });
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStartingText();
            }
        });
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.policestation);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("The city's police station", R.drawable.blackpic, "red");
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
        areasong= JukeBox.DANGER;
        esH.updateEvent("song",areasong.getName());
    }

    public void poffice() {
        intentCreator(this,PoliceOffice.class);
    }
}
