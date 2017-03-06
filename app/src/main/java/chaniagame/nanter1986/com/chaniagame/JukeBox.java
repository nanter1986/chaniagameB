package chaniagame.nanter1986.com.chaniagame;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public enum JukeBox {
    AGORAANDROID(R.raw.agoraandroid,"agoraandroid"),
    AWESOME(R.raw.awesome,"awesome"),
    BITTERSWEET(R.raw.bittersweet,"bittersweet"),
    DANGER(R.raw.danger,"danger"),
    DROP(R.raw.drop,"drop"),
    EMPTYSOUND(R.raw.emptysound,"emptysound"),
    FUTURISTIC(R.raw.futuristic,"futuristic"),
    GOODBYE(R.raw.goodbye,"goodbye"),
    HELPINGHAND(R.raw.helpinghand,"helpinghand"),
    HOPELESS(R.raw.hopeless,"hopeless"),
    HOTEL(R.raw.hotel,"hotel"),
    IRONWALLS(R.raw.ironwalls,"ironwalls"),
    MEMORIES(R.raw.memories,"memories"),
    REAL(R.raw.real,"real"),
    REALDANGER(R.raw.realdanger,"realdanger"),
    SAD(R.raw.sad,"sad"),
    SWEET(R.raw.sweet,"sweet"),
    TRAVEL(R.raw.travel,"travel"),
    WALLS(R.raw.walls,"walls"),
    WAR(R.raw.war,"walls"),
    WEIRD(R.raw.weird,"weird"),
    WINTER(R.raw.winter,"winter"),
    WINTERMIX2(R.raw.wintermix2,"wintermix2"),
    YES(R.raw.yes,"yes");

    private int song;
    private String name;

    JukeBox(int s,String n) {
        song=s;
        name=n;

    }

    public int getSong(){
        return song;
    }

    public String getName(){
        return name;
    }
}
