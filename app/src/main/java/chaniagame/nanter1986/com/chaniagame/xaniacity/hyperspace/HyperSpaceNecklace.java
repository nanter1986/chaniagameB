package chaniagame.nanter1986.com.chaniagame.xaniacity.hyperspace;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Tzami;

/**
 * Created by nanter1986 on 12/10/2016.
 */
public class HyperSpaceNecklace extends RoomMaker{
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
        b.setImageResource(R.drawable.hyperspaceone);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("killedBarwoman").equals("no")){
            notKilled1();
        }else {
            voice0();

        }
    }

    private void notKilled1() {
        dialogCreator("Where am I?\nAm I in space?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notkilled1();
            }
        });
    }

    private void notkilled1() {
        dialogCreator("[UNKNOWN VOICE]You came for the necklace.\nYou are trying to help your brother.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notkilled2();
            }
        });
    }

    private void notkilled2() {
        dialogCreator("[UNKNOWN VOICE]Here take it.\nI'm here to make sure justice is served. ");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notkilled3();
            }
        });
    }

    private void notkilled3() {
        esH.updateEvent("gotTzamiNecklace","yes");
        intentCreator(this,Tzami.class);
    }

    private void voice0() {
        dialogCreator("Where am I?\nAm I in space?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice1();
            }
        });
    }

    private void voice1() {
        dialogCreator("[UNKNOWN VOICE]You came for the necklace.\nYou killed an innocent woman to take come here.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice2();
            }
        });
    }

    private void voice2() {
        dialogCreator("[UNKNOWN VOICE]Why do you think you deserve it?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice3();
            }
        });
    }

    private void voice3() {
        dialogCreator("I have to save my brother, who are you?\nWhy are you getting in my way?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice4();
            }
        });
    }

    private void voice4() {
        dialogCreator("[UNKNOWN VOICE]It doesn't matter who I am. \nMy job is to make sure nobody breaks the rules in this world.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice5();
            }
        });
    }

    private void voice5() {
        dialogCreator("[UNKNOWN VOICE]And you did. \nYou don't belong here abd yet you came.\nYou are not allowed to kill and yet you killed.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice6();
            }
        });
    }

    private void voice6() {
        dialogCreator("[UNKNOWN VOICE]I will not get in your way.\nBut I will not be protecting you from any rules that other beings break.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice7();
            }
        });
    }

    private void voice7() {
        dialogCreator("[UNKNOWN VOICE]Here is the necklace.\nYou are on your own now.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice8();
            }
        });
    }

    private void voice8() {
        esH.updateEvent("gotTzamiNecklace","yes");
        intentCreator(this,Tzami.class);
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
