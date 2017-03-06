package chaniagame.nanter1986.com.chaniagame;

/**
 * Created by nanter1986 on 28/9/2016.
 */
public class MagicNotebook extends Item{



    public MagicNotebook(String nm, int im, String des) {
        super(nm, im, des);


    }

    public String giveAdvice(String location){
        String s="";
        switch (location){
            case "AbandondedHotel":
                s+="We need some tools here!";
                break;
            case "AgioiApostoloi":
                s+="Just put a key in the hole.";
                break;
            case "AgoraAct":
                s+="The password must be the name of someone important,so it's not your name. ";
                break;
            default:
                s+="I don't know everything.I certainly know more than you.";

        }
        return s;
    }
}
