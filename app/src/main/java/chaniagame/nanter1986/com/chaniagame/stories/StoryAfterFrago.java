package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 6/9/2016.
 */
public class StoryAfterFrago extends StoryTeller{
    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("[OLIVER]What's in the bag tom?", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room1();
            }
        });
    }

    private void room1() {
        dialogCreator("[TOM]It's nothing...\n nothing really...", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room2();
            }
        });
    }

    private void room2() {
        dialogCreator("[OLIVER]Let's see...\n Holy shit, do you know how many beers \nand cigarettes can these buy?", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room3();
            }
        });
    }

    private void room3() {
        dialogCreator("[TOM]Oliver these aren't yours to take or sell...", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room4();
            }
        });
    }

    private void room4() {
        dialogCreator("[OLIVER]You owe me... Don't worry, I'll make sure your mom gets \nsome alcohol too,", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room5();
            }
        });
    }

    private void room5() {
        dialogCreator("[OLIVER]Maybe I'll go drink it with her when \nsince your daddy is rarely at home...", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room6();
            }
        });
    }

    private void room6() {
        dialogCreator("[REST OF FRIENDS]Hahahah,yeah you'll show \nthat bitch who's the boss...", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room7();
            }
        });
    }

    private void room7() {
        dialogCreator("[TOM]Hey, stop it you....", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room8();
            }
        });
    }

    private void room8() {
        dialogCreator("Oliver punches tom to the ground...", R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room9();
            }
        });
    }

    private void room9() {
        dialogCreator("[OLIVER]I didn't hear you, \ncan you say that again?", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room10();
            }
        });
    }

    private void room10() {
        dialogCreator("[TOM].........", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room11();
            }
        });
    }

    private void room11() {
        dialogCreator("[OLIVER]That's right....", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room12();
            }
        });
    }

    private void room12() {
        dialogCreator("[OLIVER]Let's go guys and see where \nwe can kill these shinny things.", R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room13();
            }
        });
    }

    private void room13() {
        dialogCreator("As they are leaving tom picks up a big rock in his hand,\nand approaches Oliver from behind...", R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room14();
            }
        });
    }

    private void room14() {
        esH.updateEvent("watch","used");
        esH.updateEvent("donefragokastello","yes");
        dialogCreator("Everything brightens up and you appear in the city\nof Chania...", R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room15();
            }
        });
    }

    private void room15() {
        intentCreator(this, Ktel.class);
    }


}
