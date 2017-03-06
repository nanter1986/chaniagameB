package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class InsideApostoloi extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,AgioiApostoloi.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Floor");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floor();
            }
        });
        bOpt2.setText("Walls");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        bOpt3.setText("Benches");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benches();
            }
        });
        exitForward();
    }

    private void walls() {
        dialogCreator("There are christian paintings on the walls.\nNothing unusual.");
        exitForward();
    }

    private void floor() {
        if(esH.readEvent("earring").equals("no")) {
            dialogCreator("There is a black circle on the floor.\nLooks like it was burned.\nThere is an earring in the middle.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    earring();
                }
            });
        }else{
            dialogCreator("There is a black circle on the floor.\nLooks like it was burned.");
            exitForward();
        }
    }

    private void earring() {
        esH.updateEvent("earring","yes");
        dialogCreator("You obtained the earring");
        exitForward();
    }

    private void benches() {
        dialogCreator("There is what it looks like \na child's drawing on a bench.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawing();
            }
        });
    }

    private void drawing() {
        b.setImageResource(R.drawable.childdrawing2);
        dialogCreator("");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.insideapostoloi);
                setStartingText();
            }
        });
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.insideapostoloi);
    }

    @Override
    public void setStartingTextOptions() {
        dialogCreator("The air has an unusual smell,\nbut I can't recognize it.");
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
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
