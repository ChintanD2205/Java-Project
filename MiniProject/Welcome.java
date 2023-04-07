package MiniProject;
import java.io.*;
import javax.sound.sampled.*;

public class Welcome implements Runnable 
{
    public Thread t;
    String name;

    public Welcome(String n)
    {
        t = new Thread(this, n);
        name = n;
        t.start();
    }
    public void run()
    {
        File file = new File("C:\\Users\\chint\\OneDrive\\Desktop\\MiniProject\\MiniProject\\"+name+".wav");
		AudioInputStream wsbmp;
        try
        {
            wsbmp = AudioSystem.getAudioInputStream(file);
            Clip clip;
            clip = AudioSystem.getClip();
            clip.open(wsbmp);
            clip.start();
        } 
        catch (Exception e)
        {}
    }
    
}
