import MiniProject.Bank;
import MiniProject.Admin;
import MiniProject.Operations;
import MiniProject.ColorCode;
import MiniProject.Welcome;
import java.util.*;
import java.io.*;

public class App implements ColorCode
{
    public static void main(String[] args) throws Exception
    {
        int operation;
        int choice, userpass, adminpass=0000, n=10,i=0, access=0, an=2;
        boolean login = false;
        String username, adminuser;
        Scanner sc = new Scanner(System.in);
        Bank b[] = 
        {
            new Bank(1,1,1300000000L, "Archit Jain", 'M', "19/10/2004", "architjain2005@gmail.com", 123456789L, "Vile Parle ", 400059, "123445677890", "AB365C2567", 1234, "ArcJ_19", 1002, 2000),  
            new Bank(1,1,1300000001L, "Chintan Dodia", 'M', "22/08/2004", "chintan@gmail.com", 987654321L, "Charni Road", 400004, "152436725894", "D5F248W621", 4321, "ChiD_22", 2205, 2000),  
            new Bank(1,1,1300000002L, "Khushi Sanghavi", 'F', "18/10/2004", "khushi2005@gmail.com", 135792468L, "Kandivali  ", 400068, "754218963421", "FV15S26D21", 2563, "KhuS_19", 1245, 2000),  
            new Bank(1,1,1300000003L, "Iqra Khatib", 'F', "19/10/2004", "iqra@gmail.com", 246813579L, "Mahim      ", 400039, "457891234568", "TG254WE6D2", 2541, "IqrK_19", 5789, 2000),  
            new Bank(1,1,1300000004L, "Manav Rathod", 'M', "19/10/2004", "manav@gmail.com", 134526789L, "Vile Parle ", 400059, "154268794352", "WE254D3259", 8754, "ManR_19", 2536, 2000),  
            new Bank(1,1,1300000005L, "Vanshita Shah", 'F', "26/08/2004", "vanshita@gmail.com", 257819256L, "Virar      ", 400089, "145278945621", "WE2541F364", 8642, "VanS_26", 8856, 2000),  
            new Bank(1,1,1300000006L, "Rashmi Kamdar", 'M', "28/02/2004", "rashmi@gmail.com", 198273645L, "Kandivali  ", 400068, "147854625879", "DB254136S2", 3578, "RasK_28", 8456, 2000),  
            new Bank(1,1,1300000007L, "Het Shah", 'M', "17/07/2004", "het@gmail.com", 912873645L, "Charni Road", 400004, "547284675912", "TF52486D21", 5874, "HetS_17", 9754, 2000),  
            new Bank(1,1,1300000008L, "Jainam Barbhaya", 'M', "15/09/2004", "jainam@gmail.com", 298745136L, "Malad      ", 400064, "985426137542", "FR254163D2", 6842, "JaiB_15", 5485, 2000),  
            new Bank(1,1,1300000009L, "Ayush Vora", 'M', "19/10/2004", "ayush@gmail.com", 879654321L, "Kandivali  ", 400068, "157462548921", "SW254687M2", 3789, "AyuV_19", 8572, 2000)
        };
        Admin a[] = {
            new Admin("Mark", "MarZ_18", 1234),
            new Admin("Admin", "admin", 8432)
        };
        Operations o = new Operations();

        //Console cs = System.console();

        while(true)
        {
            System.out.flush();
            System.out.print(ANSI_RESET);
            try
            {
                new Welcome("Voice").t.join();
            }
            catch(InterruptedException e)
            {
                System.out.println("Sorry for the inconvenience");
            }
            System.out.println("\t\t\tWELCOME TO SBMP BANK !");
            System.out.println("\t\tPlease Select one of the options below : ");
            System.out.println("\t\t1. Admin Login \n\t\t2. User Login \n\t\t3. Exit");
            System.out.print("\t\tEnter your choice : ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                {
                    try
                    {
                        new Welcome("Credential").t.join();
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println("Sorry for the inconvenience");
                    }
                    System.out.println("\tPlease provide the necessary credentials : ");
                    while(true)
                    {
                        int z = 0;
                        while(z<3)
                        {
                            System.out.print(ANSI_RESET);
                            while(true)
                            {
                                System.out.print("\tEnter Admin Username : ");
                                adminuser = sc.next();
                                System.out.print("\tEnter Admin Password : ");
                                try
                                {
                                    adminpass = sc.nextInt();
                                    break;
                                }
                                catch(InputMismatchException e)
                                {
                                    System.out.println("Enter a numeric password : ");
                                }
                            }

                            for(i=0;i<n;i++)
                            {  
                                if(adminuser.equals("admin") && adminpass == 8432)
                                {
                                    login = true;
                                    break;
                                }
                            }
                            if(login)
                            {
                                try
                                {
                                    new Welcome("Welcome").t.join();
                                }
                                catch(InterruptedException e)
                                {
                                    System.out.println("Sorry for the inconvenience");
                                }
                                System.out.println(ANSI_GREEN + "\t\tWelcome Back, Admin" + ANSI_RESET);
                                break;
                            }
                            else
                            {
                                System.out.print(ANSI_RED+"\tAccess Denied! Try after 15 seconds .");
                                z++;
                                for(i=0;i<15;i++)
                                {
                                    try
                                    {
                                        Thread.sleep(1000);
                                        System.out.print(".");
                                    }
                                    catch(InterruptedException e)
                                    {
                                        System.out.println("Sorry for the incovenience");
                                        System.exit(0);
                                    }
                                }
                            }
                            if(z>2)
                            {
                                System.out.println(ANSI_RED+"\tWrong Credentials Entered ! ");
                                System.out.println("\tAccess Denied !"+ANSI_RESET);
                                System.exit(0);
                            }
                        }
                        int adminchoice =0;
                        while(adminchoice !=4)
                        {
                            System.out.println("\t\t*****OPERATIONS*****");
                            System.out.println("\t\t1. Create New Account");
                            System.out.println("\t\t2. Update Account");
                            System.out.println("\t\t3. View Feedback");
                            System.out.println("\t\t4. Exit");
                            //some more
                            System.out.print("\t\tEnter your choice : ");
                            adminchoice = sc.nextInt();

                            switch(adminchoice)
                            {
                                case 1:
                                {
                                    System.out.println("\t\t*****MENU*****");
                                    System.out.println("\t\t1. User Account");
                                    System.out.println("\t\t2. Admin Account");
                                    System.out.print("\t\tFor whom do you wish to create an account ? ");
                                    int acc_choice = sc.nextInt();
                                    switch(acc_choice)
                                    {
                                        case 1:
                                        {
                                            System.out.println("\t\t*****MENU*****");
                                            System.out.println("\t\t1. Savings Account");
                                            System.out.println("\t\t2. Current Account");
                                            System.out.print("\t\tEnter your preference : ");
                                            int acc_type = sc.nextInt();
                                            switch(acc_type)
                                            {
                                                case 1:
                                                {
                                                    System.out.println("\t\t*****MENU*****");
                                                    System.out.println("\t\t1. Adult");
                                                    System.out.println("\t\t2. Adult Joint");
                                                    System.out.println("\t\t3. Child");
                                                    System.out.print("\t\tEnter your preference : ");
                                                    int hold_type = sc.nextInt();

                                                    Bank acc[] = new Bank[50];
                                                    for(i=0;i<b.length;i++)
                                                    {
                                                        acc[i] = b[i];
                                                    }
                                                    Bank temp = new Bank();
                                                    temp.n = b.length;
                                                    b[temp.n++] = new Bank(acc_type, hold_type);
                                                    new File("PassBook"+b.length+".txt");
                                                    break;
                                                }
                                                case 2:
                                                {
                                                    Bank acc[] = new Bank[50];
                                                    for(i=0;i<b.length;i++)
                                                    {
                                                        acc[i] = b[i];
                                                    }
                                                    Bank temp = new Bank();
                                                    temp.n = b.length;
                                                    b[temp.n++] = new Bank(acc_type, 0);
                                                    break;
                                                }
                                                default:
                                                {
                                                    System.out.println("Wrong option entered try again");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 2:
                                        {
                                            System.out.println("Enter name, username and 4-digit pin for admin : ");
                                            Admin ac[] = new Admin[50];
                                            for(i=0;i<a.length;i++)
                                            {
                                                ac[i] = a[i];
                                            }
                                            Admin temp = new Admin();
                                            temp.n = a.length;
                                            a[temp.n++] = new Admin(sc.next(), sc.next(), sc.nextInt());
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("Wrong option entered try again");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2:
                                {
                                    System.out.print("\t\tEnter account number for which you wish to update : ");
                                    long uan = sc.nextLong();
                                    for(i=0;i<n;i++)
                                    {
                                        if(uan == b[i].account_no)
                                        {
                                            int cat=0;
                                            while(cat != 5)
                                            {
                                                System.out.println(ANSI_BOLD + "\t\tCategory");
                                                System.out.println("\t\t1. Application Username \n\t\t2. Application Pin \n\t\t3. Region \n\t\t4. Phone Number \n\t\t5. Exit \n\t\tEnter category to update : ");
                                                System.out.print(ANSI_CYAN);
                                                cat = sc.nextInt();
                                                System.out.print(ANSI_RESET);
                                                switch(cat)
                                                {
                                                    case 1:
                                                    {
                                                        System.out.println("\t\t Enter existing username : ");
                                                        System.out.print(ANSI_CYAN);
                                                        String eun=sc.next();

                                                        if(eun.equals(b[i].application_username))
                                                        {
                                                            System.out.print(ANSI_RESET);
                                                            System.out.println("\t\tEnter new username : ");
                                                            System.out.print(ANSI_CYAN);
                                                            while(true)
                                                            {
                                                                try
                                                                {
                                                                    String nun = sc.next();
                                                                    if(nun.length() < 6 && nun.length() > 15)
                                                                    {
                                                                        System.out.println("Username not in specified range !");
                                                                        System.out.print("Try again : ");
                                                                    }
                                                                    else
                                                                    {
                                                                        b[i].application_username = nun;
                                                                        break;
                                                                    }
                                                                }
                                                                catch(InputMismatchException e)
                                                                {
                                                                    System.out.println("Invalid Format");
                                                                    System.out.print("Try Again!");
                                                                }
                                                            }
                                                            System.out.print(ANSI_RESET);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Please Enter Correct Existing Username and Try Again !");
                                                        }
                                                        break;
                                                    }
                                                    case 2:
                                                    {
                                                        System.out.println("\t\t Enter existing application pin : ");
                                                        System.out.print(ANSI_CYAN);
                                                        int eun=sc.nextInt();

                                                        if(eun == (b[i].application_pin))
                                                        {
                                                            System.out.print(ANSI_RESET);
                                                            System.out.println("\t\tEnter new password (4 numerics) : ");
                                                            System.out.print(ANSI_CYAN);
                                                            while(true)
                                                            {
                                                                try
                                                                {
                                                                    int nun = sc.nextInt();
                                                                    b[i].application_pin = nun;
                                                                    break;
                                                                }
                                                                catch(InputMismatchException e)
                                                                {
                                                                    System.out.println("Invalid Format");
                                                                    System.out.print("Try Again!");
                                                                }
                                                            }
                                                            System.out.print(ANSI_RESET);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Please Enter Correct Existing Application Pin and Try Again !");
                                                        }
                                                        break;
                                                    }
                                                    case 3:
                                                    {
                                                        System.out.println("\t\t Enter username : ");
                                                        System.out.print(ANSI_CYAN);
                                                        String eun=sc.next();

                                                        if(eun.equals(b[i].application_username))
                                                        {
                                                            System.out.print(ANSI_RESET);
                                                            System.out.println("\t\tEnter new region : ");
                                                            System.out.print(ANSI_CYAN);
                                                            String nun = sc.next();
                                                            System.out.println("\t\tEnter pincode : ");
                                                            System.out.print(ANSI_CYAN);
                                                            while(true)
                                                            {
                                                                try
                                                                {
                                                                    int np = sc.nextInt();
                                                                    b[i].address = nun;
                                                                    b[i].pincode = np;
                                                                    break;
                                                                }
                                                                catch(InputMismatchException e)
                                                                {
                                                                    System.out.println("Invalid Format");
                                                                    System.out.print("Try Again!");
                                                                }
                                                            }
                                                            System.out.print(ANSI_RESET);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Please Enter Correct Existing Username and Try Again !");
                                                        }
                                                        break;
                                                    }
                                                    case 4:
                                                    {
                                                        System.out.println("\t\t We'll get back to you soon !");
                                                        break;
                                                    }
                                                    case 5:
                                                    {
                                                        break;
                                                    }
                                                    default:
                                                    {
                                                        System.out.println("Enter appropriate category !");
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\t\tNo such Account exists!");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 3:
                                {
                                    long l = o.viewfb();
                                    if(l==0)
                                    {
                                        System.out.println("No records to display !");
                                    }
                                    break;
                                }
                                default:
                                {
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    break;
                }
            
                case 2:
                {
                    try
                    {
                        new Welcome("Credential").t.join();
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println("Sorry for the inconvenience");
                    }
                    System.out.println("\t\tPlease provide the necessary credentials : ");
                    while(true)
                    {
                        int z = 0;
                        while(!login)
                        {
                            System.out.print("\t\tEnter Username : ");
                            username = sc.next();
                            System.out.print("\t\tEnter Password : ");
                            userpass = sc.nextInt();
                            for(i=0;i<n;i++)
                            {  
                                if(username.equals(b[i].application_username) && userpass == b[i].application_pin)
                                {
                                    login = true;
                                    access = i;
                                    break;
                                }
                            }
                            if(login)
                            {
                                try
                                {
                                    new Welcome("Welcome").t.join();
                                }
                                catch(InterruptedException e)
                                {
                                    System.out.println("Sorry for the inconvenience");
                                }
                                System.out.println("\t\tWelcome Back, "+ b[i].Name);
                            }
                            else
                            {
                                System.out.print("Access Denied! Try after 15 seconds .");
                                z++;
                                for(i=0;i<15;i++)
                                {
                                    try
                                    {
                                        Thread.sleep(1000);
                                        System.out.print(".");
                                    }
                                    catch(InterruptedException e)
                                    {
                                        System.out.println("Sorry for the incovenience");
                                        System.exit(0);
                                    }
                                }
                            }
                            if(z>2)
                            {
                                System.out.println("\tWrong Credentials Entered ! ");
                                System.out.println("\tAccess Denied !");
                                System.exit(0);
                            }
                        }

                        System.out.println(ANSI_BOLD + "\tWhat would you like to do today ? " + ANSI_RESET);
                        System.out.println("\t1. Deposit");
                        System.out.println("\t2. Withdraw");
                        System.out.println("\t3. Transfer Money");
                        System.out.println("\t4. Display Passbook");
                        System.out.println("\t5. Clear Out Account");
                        System.out.println("\t6. Give Feedback");
                        System.out.println("\t7. Exit");
                        System.out.print("\tEnter your choice : ");
                        operation = sc.nextInt();

                        switch(operation)
                        {
                            case 1:
                            {
                                o.deposit(b, access);
                                break;
                            }
                            case 2:
                            {
                                o.withdraw(b, access);
                                break;
                            }
                            case 3:
                            {
                                o.transfer(b, access);
                                break;
                            }
                            case 4:
                            {
                                b[access].getAccount();
                                o.display(b, access);
                                break;
                            }
                            case 5:
                            {
                                o.clear(b, access);
                                break;
                            }
                            case 6:
                            {
                                o.feedback(b,access);
                                break;
                            }
                            case 7:
                            {
                                try
                                {
                                    new Welcome("SYS").t.join();
                                }
                                catch(InterruptedException e)
                                {
                                    System.out.println("Sorry for the inconvenience");
                                }
                                System.exit(0);
                            }
                        }
                    }
                }
                default:
                {
                    System.exit(0);
                }
                
            }
        }
    }
}