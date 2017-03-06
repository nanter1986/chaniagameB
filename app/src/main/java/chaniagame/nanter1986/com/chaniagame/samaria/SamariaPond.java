package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.WhirlpoolStory;

public class SamariaPond extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaChurch.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaFountain.class);
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
        bOpt1.setText("Pond");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pond();
            }
        });
        bOpt2.setText("Rocks");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocks();
            }
        });
        if(esH.readEvent("pondtourist").equals("no")) {
            bOpt3.setText("Tourist");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pondtourist();
                }
            });
        }
        exitForward();
    }

    private void pondtourist() {

    }

    private void rocks() {
        dialogCreator("There are pieces of a book scattered around\nbetween the rocks.\nIt's the little prince.\nTomas' favorite childhood book");
        exitForward();
    }

    private void pond() {
        if(esH.readEvent("leverchurch").equals("no")) {
            dialogCreator("There is what appears to be a lever in the pond.");
            bOpt1.setText("Swim");
            bOpt1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    swim();
                }
            });
            bOpt2.setText("I'm Ok");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imok();
                }
            });
        }else{
            dialogCreator("The lever is stuck.\nNothing left to do in the pond.\nI wonder if it opened anything.");
            exitForward();
        }
    }

    private void imok() {
        setStartingText();
    }

    private void swim() {
        if(esH.readEvent("whirlpoolstory").equals("yes")){
            dialogCreator("The lever moved.", R.drawable.blackpic, "white");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    levermoved();
                }
            });
        }else {
            dialogCreator("The lever is stuck.\nI can't move it", R.drawable.blackpic, "white");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    swim2();
                }
            });
        }

    }

    private void levermoved() {
        esH.updateEvent("leverchurch","yes");
        dialogCreator("You hear a mechanical sound for 10 seconds.\nThen it stops.");
        exitForward();
    }

    private void swim2() {
        dialogCreator("The water starts to move.\nIt's a whirlpool");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swim3();
            }
        });
    }

    private void swim3() {
        dialogCreator("I can't get out.\nIt's taking me to the bottom.\nBut the pond wasn't that deep...",R.drawable.blackpic,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swim4();
            }
        });
    }

    private void swim4() {
        intentCreator(this,WhirlpoolStory.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariapond);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("A small pond of water.",R.drawable.blackpic,"red");
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
