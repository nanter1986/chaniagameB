package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Garden extends RoomMaker {



    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,policeStation.class);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("A garden with tall trees,benches and cages.", R.drawable.blackpic,"red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("South");
            bWest.setText("West");
            bEast.setText("East");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.AGORAANDROID;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void west(View west) {

        intentCreator(this,AgoraAct.class);

    }

    @Override
    public void east(View east) {
        intentCreator(this,Graveyard.class);
    }

    @Override
    public void investigate(View investigate) {
            bOpt1.setText("Cages");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cage1();
                }
            });
            bOpt2.setText("Tree");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tree1();
                }
            });
            bOpt3.setText("Benches");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    benches();
                }
            });
    }

    private void benches() {
        if(esH.readEvent("drinkgarden").equals("yes")){
            givedrink();
        }else {
            dialogCreator("Sometimes the bar woman keeps me company\nafter work ,early in the morning.", R.drawable.garden, "green");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    benches2();
                }
            });
        }
    }

    private void givedrink() {
        dialogCreator("Is that drink for me?\nHow can I pay you back?\nThe crowbar?",R.drawable.garden,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givedrink2();
            }
        });
    }

    private void givedrink2() {
        dialogCreator("Here,take it. \nThere are more of these in the warehouse.",R.drawable.garden,"green");
        esH.updateEvent("drinkgarden","no");
        esH.updateEvent("crowbar","yes");
        exitForward();
    }

    private void benches2() {
        esH.updateEvent("knowpills","yes");
        dialogCreator("That's because she has trouble sleeping.",R.drawable.garden,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benches3();
            }
        });
    }

    private void benches3() {
        dialogCreator("I've known her since she was a little girl.",R.drawable.garden,"green");
        if(esH.readEvent("crowbar").equals("no")){
            crowbar();
        }else  if(esH.readEvent("crowbar").equals("yes")){
            exitForward();
        }
    }

    private void crowbar() {
        dialogCreator("Ah?\nThis crowbar?\nI need it to check the sewers around the park.",R.drawable.garden,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crowbar1();
            }
        });
    }

    private void crowbar1() {
        esH.updateEvent("knowdrink","yes");
        dialogCreator("Oh man,I'd give anything for a drink now.",R.drawable.garden,"green");
        exitForward();
    }


    private void tree1() {
        dialogCreator("A very tall tree with huge roots\ncoming out of the ground.",R.drawable.blackpic,"red");
        exitForward();
    }

    private void cage1() {
        dialogCreator("There are many cages with exotic birds",R.drawable.blackpic,"red");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.bgarden);
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.birds);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.6f, 0.6f);
        effect1.start();
    }
}
