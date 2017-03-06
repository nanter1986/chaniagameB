package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Tuc extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,Dorm.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,Kounoupidiana.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("knowoffice").equals("yes")){
            bOpt1.setText("Offices");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    offices();
                }
            });
            exitForward();
        }else{

        }
    }

    private void offices() {
        intentCreator(this,TucOffices.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.tuc);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("The Technical University of Crete.",R.drawable.blackpic,"red");
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
        areasong= JukeBox.GOODBYE;
        esH.updateEvent("song",areasong.getName());
    }
}
