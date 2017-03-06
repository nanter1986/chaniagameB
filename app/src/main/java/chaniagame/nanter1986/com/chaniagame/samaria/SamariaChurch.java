package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaChurch extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaEntrance.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaPond.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Door");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                door();
            }
        });
        bOpt2.setText("Window");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window();
            }
        });
        bOpt3.setText("Trash Bin");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trashbin();
            }
        });
        exitForward();
    }

    private void door() {
        if(esH.readEvent("leverchurch").equals("yes")){
            dialogCreator("This must be what the lever unlocked");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goinchurch();
                }
            });

        }else{
            dialogCreator("It's locked");
            exitForward();
        }
    }

    private void goinchurch() {
        intentCreator(this,SamariaInsideChurch.class);
    }

    private void window() {
        dialogCreator("It looks empty, but there is light from candles inside.\nSomeone must be lighting these candles...");
        exitForward();
    }

    private void trashbin() {
        dialogCreator("There are 2 empty bottles of Thomas' favorite orange soda...\nAt least I know I'm in the right brain.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariachurch);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("An old church.",R.drawable.blackpic,"red");

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
