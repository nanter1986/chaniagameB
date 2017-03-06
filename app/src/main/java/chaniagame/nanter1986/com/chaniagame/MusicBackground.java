package chaniagame.nanter1986.com.chaniagame;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MusicBackground extends IntentService {


    MediaPlayer mp;
    JukeBox currentSong;
    JukeBox nextSong;
    String nextSongName;

    private eventSaver esH;
    Handler h;

    public MusicBackground() {
        super("MusicBackground");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("started","service started");
        esH=new eventSaver(this);
        currentSong= JukeBox.BITTERSWEET;
        nextSong= JukeBox.BITTERSWEET;
        nextSongName= JukeBox.BITTERSWEET.getName();
        loopCheck();




    }

    private void loopCheck() {
        while(true){
            readS();
            if(esH.readEvent("song").equals("NONE")){
                mp.pause();

            }else if(currentSong.getName().equals(nextSongName) && mp==null) {
                mp = MediaPlayer.create(getBaseContext(), currentSong.getSong());
                mp.setLooping(true);
                mp.start();
            }else if(currentSong.getName().equals(nextSongName)){

            }else if(!(currentSong.getName().equals(nextSongName)) && mp!=null) {
                mp.release();
                mp=null;
                setNextSong();
                currentSong=nextSong;
                esH.updateEvent("song",currentSong.getName());
                mp = MediaPlayer.create(getBaseContext(), currentSong.getSong());
                mp.setLooping(true);
                mp.start();

            }else if(!(currentSong.getName().equals(nextSongName)) && mp==null) {
                setNextSong();
                currentSong=nextSong;
                esH.updateEvent("song",currentSong.getName());
                mp = MediaPlayer.create(getBaseContext(), currentSong.getSong());
                mp.setLooping(true);
                mp.start();

            }
            Log.i("song",currentSong.getName() + " " + esH.readEvent("song"));
        }

    }

    private void readS() {
        nextSongName=esH.readEvent("song");
    }

    public void setNextSong(){
        for (JukeBox juke : JukeBox.values()) {
            if (juke.getName().equals(esH.readEvent("song"))){
                nextSong=juke;
                break;
            }
        }
    }
}
