package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 5/9/2016.
 */
public class RingStory extends StoryTeller {
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
        dialogCreator("This is our childhood room...\nagain....",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room1();
            }
        });
    }

    private void room1() {
        dialogCreator("[TOM]Mom told me to go pick up the jewels she gave for cleaning.\nCome with me...",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room2();
            }
        });
    }

    private void room2() {
        dialogCreator("No ,I want to stay here and read.\nShe asked you to go. \n You didn't want to help me yesterday with the garden. ",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room3();
            }
        });
    }

    private void room3() {
        dialogCreator("[TOM]Fine little sis, you are just scared of my friends...",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room4();
            }
        });
    }

    private void room4() {
        dialogCreator("These aren't your friends...\nyou are scared of them too...",R.drawable.childhoodroom,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room5();
            }
        });
    }

    private void room5() {
        dialogCreator("[TOM]What did you say?\nSay that again...",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room6();
            }
        });
    }

    private void room6() {
        dialogCreator("[MOM]Tom go.\nNow!",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room7();
            }
        });
    }

    private void room7() {
        dialogCreator("[TOM]You were lucky this time...",R.drawable.childhoodroom,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room8();
            }
        });
    }

    private void room8() {
        dialogCreator("This is our school...\n and these are my brothers's 'friends'....",R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room9();
            }
        });
    }

    private void room9() {
        dialogCreator("[OLIVER]Tom...\n how are you man?\nWhat did you steal from your mom for us today?",R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room10();
            }
        });
    }

    private void room10() {
        dialogCreator("{TOM]Nah man,\nshe didn't have any alcohol this time.",R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room11();
            }
        });
    }

    private void room11() {
        dialogCreator("[OLIVER]It was your turn and you know it...\n 2 days ago you drank my beers...",R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room12();
            }
        });
    }

    private void room12() {
        dialogCreator("[TOM]I didn't forget...\nI....",R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room13();
            }
        });
    }

    private void room13() {
        dialogCreator("[OLIVER]What's in the bag tom?",R.drawable.schoolyard,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room14();
            }
        });
    }

    private void room14() {
        dialogCreator("The image starts to blur and you appear at ktel in Chania.",R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room15();
            }
        });
    }

    private void room15() {
        dialogCreator("Nooo not now, \n I have to know what happened",R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room16();
            }
        });
    }

    private void room16() {
        dialogCreator("I thought Tom lost the bag with the jewels,\nand my parents and Tom always avoided to talk about this day.",R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room17();
            }
        });
    }

    private void room17() {
        esH.updateEvent("ring","used");
        esH.updateEvent("doneakrotiri","yes");
        intentCreator(this,Ktel.class);
    }


}
