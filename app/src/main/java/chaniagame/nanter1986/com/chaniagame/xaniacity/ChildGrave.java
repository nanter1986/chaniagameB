package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class ChildGrave extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        if(esH.readEvent("shovel").equals("used")) {
            esH.updateEvent("shovel","restored");
            intentCreator(this, Graveyard.class);
        }else{
            intentCreator(this, Graveyard.class);
        }
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Grave");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grave();
            }
        });
        bOpt2.setText("Guard");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guard();
            }
        });
        bOpt3.setText("Wall");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wall();
            }
        });
        exitForward();
    }

    private void guard() {
        dialogCreator("That grave?\nIt belonged to a child that got drowned in the sea \nand they never found the body.\nThe grave is empty", R.drawable.graveguard,"green");
        exitForward();
    }

    private void grave() {
        if(esH.readEvent("shovel").equals("no")) {
            dialogCreator("A child's grave.\nIt looks a little different from the others.");
            exitForward();
        }else if(esH.readEvent("shovel").equals("yes")){
            areasong= JukeBox.REALDANGER;
            esH.updateEvent("song",areasong.getName());
            dialogCreator("You use the shovel to dig the grave");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dig();
                }
            });
        }else if(esH.readEvent("shovel").equals("used")){
            dialogCreator("The grave is open");
            exitForward();
        }else if(esH.readEvent("shovel").equals("restored")){
            dialogCreator("The grave is restored");
            exitForward();
        }
    }

    private void dig() {
        dialogCreator("The coffin has a burned circle on it");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dig2();
            }
        });
    }

    private void dig2() {
        dialogCreator("You break the coffin.\nThere is a necklace inside.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dig3();
            }
        });
    }

    private void dig3() {
        esH.updateEvent("necklace","yes");
        esH.updateEvent("shovel","used");
        dialogCreator("You obtained the necklace.");
        exitForward();
    }

    private void wall() {
        dialogCreator("There is something written on the wall\nNEVER WANDERS IN THE FORESTS");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.childgrave);
    }



    @Override
    public void setStartingTextOptions() {

            dialogCreator("The grave of a child", R.drawable.blackpic, "red");


    }




    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bWest.setText("West");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }



    @Override
    public void setAreaSong() {
        areasong=JukeBox.SAD;
        esH.updateEvent("song",areasong.getName());
    }
}
