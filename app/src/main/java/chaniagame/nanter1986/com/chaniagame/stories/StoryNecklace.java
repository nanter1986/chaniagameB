package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.samaria.SamariaBlood;

/**
 * Created by nanter1986 on 8/8/2016.
 */
public class StoryNecklace extends StoryTeller {
    @Override
    protected void setMusic() {
        setBackAudio(R.raw.sweet);
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("This is our childhood room.",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room1();
            }
        });
    }

    private void room1() {
        dialogCreator("[TOM]Let's go out in the abandoned house.\n",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room2();
            }
        });
    }

    private void room2() {
        dialogCreator("Mom said we shouldn't go there.\nIt's dangerous\n",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room3();
            }
        });
    }

    private void room3() {
        dialogCreator("[TOM]Oh the little girl is scared...\nhaha",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room4();
            }
        });
    }

    private void room4() {
        dialogCreator("(I remember that day.\nIt's the day Tom lost mom's things...)\n",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room5();
            }
        });
    }

    private void room5() {
        dialogCreator("The door opens...",R.drawable.childhoodroom,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room6();
            }
        });
    }

    private void room6() {
        dialogCreator("[MOM]Tom come with me.\nI have something for you to do.",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room7();
            }
        });
    }

    private void room7() {
        esH.updateEvent("necklace","used");
        dialogCreator("(I remember all these details.\nI need to find out what happened after that....)",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endofstory();
            }
        });
    }

    private void endofstory() {
        intentCreator(this,SamariaBlood.class);
    }


}
