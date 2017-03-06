package chaniagame.nanter1986.com.chaniagame.stories;

import android.content.Intent;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

public class StoryCollected5 extends StoryTeller {



    @Override
    protected void setMusic() {
        setBackAudio(R.raw.real);
    }

    @Override
    public void setAreaSong() {

    }

    @Override
    public void setStartingText() {
        dialogCreator("Time to explain a few things...\nFirst of all I'm your sister.\nYou insisted to do this.",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1();
            }
        });
    }

    private void text1() {
        dialogCreator("This is not the real world...\nHave you noticed that a few things seem weird\nor out of place?",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2();
            }
        });
    }

    private void text2() {
        dialogCreator("You are inside your brother's mind.\nYou don't remember any of this but this is how it works...",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text3();
            }
        });
    }

    private void text3() {
        dialogCreator("We are using a new experimental device.\nIt allows us to locate and delete painful memories.\n",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text4();
            }
        });
    }

    private void text4() {
        dialogCreator("This is what you have to do.\nI can only guide you from the outside.\nAnd only at specific places.",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text5();
            }
        });
    }

    private void text5() {
        dialogCreator("You found the items that will trigger the memories.\nNow you need to find these memories.\n",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text6();
            }
        });
    }

    private void text6() {
        dialogCreator("You will go to 5 different locations.",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text7();
            }
        });
    }

    private void text7() {
        dialogCreator("Don't expect this to be easy.",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text8();
            }
        });
    }

    private void text8() {
        dialogCreator("Time to explain a few things... First of all...",R.drawable.ktel,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text9();
            }
        });
    }

    private void text9() {
        dialogCreator("The message repeats itself.",R.drawable.ktel,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text10();
            }
        });
    }

    private void text10() {
        dialogCreator("Why can't I remember any of this?",R.drawable.ktel,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text11();
            }
        });
    }

    private void text11() {
        esH.updateEvent("storycollected5","yes");
        dialogCreator("I don't remember any of these people.\nBut it looks that I don't have any other choice.\nI'm trapped and I need to find\nthe exit anyway.",R.drawable.ktel,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                text12();
            }
        });
    }

    private void text12() {
        Intent story = new Intent(this, Ktel.class);
        startActivity(story);
        overridePendingTransition(0, 0);
        finish();
    }
}
