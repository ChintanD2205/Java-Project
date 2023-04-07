package MiniProject;
import java.util.*;
import java.io.*;

public class Operations extends Methods
{
    Scanner sc = new Scanner(System.in);
    int on=101, ch;
    String msg, operation, source;

    public void displayResult(boolean a)
    {
        if(a)
        {
            try
            {
                System.out.println(ANSI_GREEN + "\t\tTransaction Successful");
                new Welcome("successful").t.join();
                Thread.sleep(1000);
                System.out.print(ANSI_BOLD);
                System.out.println("\t\t ______________");
                Thread.sleep(100);
                System.out.println("\t\t|              |");
                Thread.sleep(100);
                System.out.println("\t\t|         /    |");
                Thread.sleep(100);
                System.out.println("\t\t|     \\  /     |");
                Thread.sleep(100);
                System.out.println("\t\t|      \\/      |");
                Thread.sleep(100);
                System.out.println("\t\t[______________]");
                Thread.sleep(1000);
                System.out.print(ANSI_RESET + ANSI_GREEN);
            }
            catch(InterruptedException e)
            {
                System.out.println("\tSorry for the incovenience");
            }
        }
        else
        {
            try
            {
                System.out.println(ANSI_RED + "\t\tTransaction UnSuccessful");
                new Welcome("unsuccessful").t.join();
                Thread.sleep(1000);
                System.out.print(ANSI_BOLD);
                System.out.println("\t\t ______________");
                Thread.sleep(100);
                System.out.println("\t\t|              |");
                Thread.sleep(100);
                System.out.println("\t\t|     \\ /      |");
                Thread.sleep(100);
                System.out.println("\t\t|      X       |");
                Thread.sleep(100);
                System.out.println("\t\t|     / \\      |");
                Thread.sleep(100);
                System.out.println("\t\t[______________]");
                Thread.sleep(100);
                System.out.print(ANSI_RESET + ANSI_RED);
            }
            catch(InterruptedException e)
            {
                System.out.println("\tSorry for the incovenience");
            }
            
        }
    }

    public void deposit(Bank a[], int i)throws Exception
    {
        String name = "PassBook"+i+".txt";
        FileWriter fw = new FileWriter(name, true);
        int amt;
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter amount to be deposited : ");
        System.out.print(ANSI_CYAN);
        amt = sc.nextInt();
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter your account pin : ");
        System.out.print(ANSI_CYAN);
        int apin = sc.nextInt();
        if(apin == a[i].account_pin)
        {
            System.out.println("Depositing Money");
            progress(10, 1000);
            a[i].account_balance += amt;
            displayResult(true);
            System.out.println("\t\t$"+amt+" deposited successfully !");
            System.out.println("\t\tYour new account balance is $" + a[i].account_balance);
            System.out.println(ANSI_RESET);
            msg = "$"+amt+" Deposited Successfully";
            operation = "Deposit   ";
            source = on+" "+a[i].account_no+" "+operation+" "+amt+" "+a[i].account_balance+msg+"\n";
            char buffer[] = source.toCharArray();
            for(i=0;i<source.length(); i++)
            {
                fw.write(buffer[i]);
            }
        }
        else
        {
            displayResult(false);
            System.out.println("\t\tWRONG PIN ENTERED");
            System.out.println("\t\tTransaction Cancelled");
            System.out.print(ANSI_RESET);
        }
        fw.close();
    }
    public void withdraw(Bank a[], int i) throws Exception
    {
        String name = "PassBook"+i+".txt";
        FileWriter fw = new FileWriter(name, true);
        int amt;
        System.out.print(ANSI_RESET);
        System.out.println("\t\tYour current account balance is $" + a[i].account_balance);
        System.out.print("\t\tEnter amount to be withdrawn : ");
        System.out.print(ANSI_CYAN);
        amt = sc.nextInt();
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter your account pin : ");
        System.out.print(ANSI_CYAN);
        int apin = sc.nextInt();
        if(apin == a[i].account_pin)
        {
            int temp;
            if((temp = a[i].account_balance - amt) >= 1000)
            {
                System.out.println("Withdrawing Money");
                progress(10, 1000);
                a[i].account_balance -= amt;
                displayResult(true);
                System.out.println("\t\t$"+amt+" withdrawn successfully !");
                System.out.println("\t\tYour new account balance is $" + a[i].account_balance);
                System.out.print(ANSI_RESET);
                msg = "$"+amt+" Withdrawn Successfully";
                operation = "Withdraw";
                source = on+" "+a[i].account_no+" "+operation+" "+amt+" "+a[i].account_balance+msg+"\n";
                char buffer[] = source.toCharArray();
                for(i=0;i<source.length(); i++)
                {
                    fw.write(buffer[i]);
                }
            }
            else
            {
                displayResult(false);
                System.out.println("\t\tTRANSACTION FAILED !");
                System.out.println("\t\tInsufficient Balance !");
                System.out.println("\t\tA minimum balance of $1000 must be maintained");
                System.out.print(ANSI_RESET);
            }
        }
        else
        {
            displayResult(false);
            System.out.println("\t\tWRONG PIN ENTERED");
            System.out.println("\t\tTransaction Cancelled");
            System.out.print(ANSI_RESET);
        }
        fw.close();
    }
    public void transfer(Bank b[], int i) throws Exception
    {
        String name = "PassBook"+i+".txt";
        FileWriter fw = new FileWriter(name, true);
        int amt, j;
        long dest;
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter amount to be transferred : ");
        System.out.print(ANSI_CYAN);
        amt = sc.nextInt();
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter your account pin : ");
        System.out.print(ANSI_CYAN);
        int apin = sc.nextInt();
        if(apin == b[i].account_pin)
        {
            System.out.println("Transfering Money");
            progress(10, 1000);
            int temp;
            if((temp = b[i].account_balance - amt) >= 1000)
            {
                System.out.print("\t\tEnter account number to transfer amount : ");
                System.out.print(ANSI_CYAN);
                dest = sc.nextLong();
                for(j=0;j<50;j++)
                {
                    if(b[j].account_no == dest)
                    {
                        break;
                    }
                }
                if(j>49)
                {
                    displayResult(false);
                    System.out.println("\tNo Account found Associated with Account No. : " + dest);
                    System.out.println("\tTransfer cannot take place !");
                    System.out.print(ANSI_RESET);
                }
                else
                {
                    b[i].account_balance -= amt;
                    b[j].account_balance += amt;
                    displayResult(true);
                    for(int a =0;a<100000;a++)
                    System.out.println("\t\t$"+amt+" transferred successfully !");
                    System.out.println("\t\tYour new account balance is $" + b[i].account_balance);
                    System.out.print(ANSI_RESET);
                    msg = "$"+amt+" Transferred Successfully";
                    operation = "Transfer(W)";
                    source = on+" "+b[i].account_no+" "+operation+" "+amt+" "+b[i].account_balance+msg+"\n";
                    char buffer[] = source.toCharArray();
                    for(i=0;i<source.length(); i++)
                    {
                        fw.write(buffer[i]);
                    }
                    name = "PassBook"+j+".txt";
                    FileWriter fw2 = new FileWriter(name, true);
                    msg = "$"+amt+" Transferred Successfully";
                    operation = "Transfer(D)";
                    source = on+" "+b[j].account_no+" "+operation+" "+amt+" "+b[j].account_balance+msg+"\n";
                    char nbuffer[] = source.toCharArray();
                    for(i=0;i<source.length(); i++)
                    {
                        fw2.write(nbuffer[i]);
                    }
                    fw2.close();
                }
            }
            else
            {
                displayResult(false);
                System.out.println("\t\tTRANSACTION FAILED !");
                System.out.println("\t\tInsufficient Balance !");
                System.out.println("\t\tA minimum balance of $1000 must be maintained");
                System.out.print(ANSI_RESET);
            }
        }
        else
        {
            displayResult(false);
            System.out.println("\t\tWRONG PIN ENTERED");
            System.out.println("\t\tTransaction Cancelled");
            System.out.print(ANSI_RESET);
        }
        fw.close();
    }
    public void clear(Bank a[], int i) throws Exception
    {
        String name = "PassBook"+i+".txt";
        FileWriter fw = new FileWriter(name, true);
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter your account pin : ");
        System.out.print(ANSI_CYAN);
        int apin = sc.nextInt();
        if(apin == a[i].account_pin)
        {
            System.out.println("Clearing Account");
            progress(10, 1000);
            a[i].account_balance = 0;
            int amt = a[i].account_balance;
            displayResult(true);
            System.out.println("\t\tAccount Cleared Out Successfully !");
            System.out.println("\t\tYour new account balance is $" + a[i].account_balance);
            System.out.print(ANSI_RESET);
            msg = "Account Cleared Out";
            operation = "Clear     ";
            source = on+" "+a[i].account_no+" "+operation+" "+amt+" "+a[i].account_balance+" "+msg+"\n";
            char buffer[] = source.toCharArray();
            for(i=0;i<source.length(); i++)
            {
                fw.write(buffer[i]);
            }
        }
        else
        {
            displayResult(false);
            System.out.println("\t\tWRONG PIN ENTERED");
            System.out.println("\t\tTransaction Cancelled");
            System.out.print(ANSI_RESET);
        }
        fw.close();
    }
    public void feedback(Bank a[], int i) throws Exception
    {
        FileWriter fw = new FileWriter("FeedBack.txt", true);
        System.out.print(ANSI_RESET);
        System.out.print("\t\tEnter your feedback : ");
        System.out.print(ANSI_CYAN);
        String msg = sc.nextLine();
        System.out.print(ANSI_RESET);
        source = a[i].account_no+" "+msg+"\n";
        char buffer[] = source.toCharArray();
        for(i=0;i<source.length(); i++)
        {
            fw.write(buffer[i]);
        }
        
        fw.close();
    }
    public long viewfb() throws Exception
    {
        File f = new File("FeedBack.txt");
        FileReader fr = new FileReader("FeedBack.txt");
        System.out.println(ANSI_BOLD + "AccountNo. FeedBack" + ANSI_RESET);
        while((ch = fr.read()) != -1)
        {
            System.out.print((char)(ch));
        }
        fr.close();
        return f.length();
    }
    public void display(Bank a[], int i) throws Exception
        {
            String name = "PassBook"+i+".txt";
            FileReader fr = new FileReader(name);
            System.out.println(a[i].Name + " Account Details : ");
            System.out.println(ANSI_BOLD + "No. AccountNo. Operation Amount Balance Message" + ANSI_RESET);
            while((ch = fr.read()) != -1)
            {
                System.out.print((char)(ch));
            }
            fr.close();
        }
}