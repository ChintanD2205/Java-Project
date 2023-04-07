package MiniProject;

public class Methods implements ColorCode
{
    void progress(int n, int time)
    {
        try
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(ANSI_BLUE + "." + ANSI_RESET);
                Thread.sleep(time);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Sorry for the inconvenience!");
        }
    }
}
