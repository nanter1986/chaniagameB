package chaniagame.nanter1986.com.chaniagame.stories;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.samaria.SamariaRocks;

public class WhirlpoolStory extends StoryTeller {


    @Override
    protected void setMusic() {
        setBackAudio(R.raw.realdanger);
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("A cave?\nWhere a I?\nHow will I.....",R.drawable.whirlpoolcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cave1();
            }
        });
    }

    private void cave1() {
        dialogCreator("I feel that I'm not alone here.",R.drawable.whirlpoolcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cave2();
            }
        });
    }

    private void cave2() {
        dialogCreator("Who is there?\nTom?",R.drawable.whirlpoolcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cave3();
            }
        });
    }

    private void cave3() {
        dialogCreator("................",R.drawable.whirlpoolcave,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cave4();
            }
        });
    }

    private void cave4() {
        dialogCreator("................",R.drawable.whirlpoolcave,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cave5();
            }
        });
    }

    private void cave5() {
        bForward.setOnClickListener(null);
        dialogCreator("WTF?",R.drawable.whirlpoolcave,"white");
        setBackAudio(R.raw.monster);
        Handler h = new Handler();
        Handler h2 = new Handler();
        Runnable rb1 = new Runnable() {
            @Override
            public void run() {
                esH.updateEvent("whirlpoolstory","yes");
                dialogCreator("Noooooooo",R.drawable.eyesinthedark,"white");
            }
        };
        Runnable rb2 = new Runnable() {
            @Override
            public void run() {
                Intent story = new Intent(getBaseContext(), SamariaRocks.class);
                startActivity(story);
                overridePendingTransition(0, 0);
                finish();
            }
        };
        h.postDelayed(rb1,2000);
        h2.postDelayed(rb2,6000);

    }
}
