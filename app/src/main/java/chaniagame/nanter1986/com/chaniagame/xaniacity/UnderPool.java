package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class UnderPool extends RoomMaker {



    @Override
    public void north(View north) {
        intentCreator(this,AbandondedHotel.class);
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
        bOpt1.setText("Room 1");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room1();
            }
        });
        bOpt2.setText("Room 2");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room2(); 
            }
        });
        bOpt3.setText("Room 3");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room3(); 
            }
        });
    }



    private void room3() {
        dialogCreator("There is what it looks like \na child's drawing attached to the wall.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawing();
            }
        });
    }

    private void drawing() {
        b.setImageResource(R.drawable.childdrawing);
        dialogCreator("A suicide?\nOr a murder?\nDoes this house really exist?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.underpool);
                setStartingText();
            }
        });
    }

    private void room2() {
        if(esH.readEvent("ring").equals("no")) {
            dialogCreator("There a burned circle on the floor.\nThere is a silver ring in it.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ring();
                }
            });
        }else{
            dialogCreator("There a burned circle on the floor.");
            exitForward();
        }
    }

    private void ring() {
        esH.updateEvent("ring","yes");
        dialogCreator("You obtained the ring.");
        exitForward();
    }

    private void room1() {
        dialogCreator("There are 7 rusty knives thrown in the corner.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.underpool);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("Up");

        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
