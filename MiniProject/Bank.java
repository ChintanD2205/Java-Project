package MiniProject;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.Console;
import java.util.Date;
import java.text.DateFormat;

public class Bank extends Methods
{
    /*Normal Account : Account No., Name, Birthdate, email, phone no, pin confirm pin, address, 
        pincode, aadhar, pan, bank branch, bank name, ifsc code, account balance, gender,
        type of account : savings/current, firm license no., firm elecbill no., application pin

        Savings Adult : Normal Account - current account ka thing
        Savings Adult Joint : savings adult + beneficiary details(name, birthdate, email, phone no,
        confirm pin, address, aadhar, pan , pincode, gender)
        Savings Child : savings Adult Joint

        Conditions to check for : 
        Authenticate  full project for syntax and InputMismatchException
        Authenticate email, aadhar, pan, firm license no., firm elecbill no. for syntax
        Authenticate a 4 digit pin and its confirmation pin for similarity

        Things to assign : 
        bank name, bank branch, ifsc, application pin 
        Rest all things take user input.

        Put customized exception handling and while blocks
        */
    public long account_no, phone_number;
    public String fname, mname, lname, application_username, address, Name;
    String email, bank_branch, bank_name, account_type, date, aadhar="", pan, ifsc, firm_license, firm_elecbill;
    int account_pin, appCount, age, wc=0;
    public int application_pin, account_balance, pincode;
    char gender;
    Date dob, doj = new Date();
    public int n=0;

    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    Console cs = System.console();
    IndividualJoint ij = new IndividualJoint();
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Bank(int acc, int holder_type, long accnum, String n, char gen, String birthdate, String eid, long phonenum, String add, int pc, String adhar, String pannum, int accpin, String appuname, int apppin, int accbal)
    {
        account_type = "Savings Account - Adult";
        account_no = accnum;
        Name = n;
        gender = gen;
        try
        {
            dob = new SimpleDateFormat("dd/mm/yyyy").parse(birthdate);
        }
        catch(ParseException e)
        {
            System.out.println("Enter the date of birth in proper format.");
        }
        email = eid;
        phone_number = phonenum;
        address = add;
        pincode = pc;
        if(pincode>400000 && pincode<=400050)
        {
            bank_branch = "Sikka Nagar";
            ifsc = "SBMS02";
        }
        else if(pincode>400050 && pincode<=400100)
        {
            bank_branch = "IRLA";
            ifsc = "SBMI02";
        }
        else
        {
            bank_branch = "GOREGAON";
            ifsc = "SBMG02";
        }
        aadhar = adhar;
        pan = pannum;
        account_pin = accpin;
        application_username = appuname;
        application_pin = apppin;
        account_balance = accbal;
    }


    public Bank()
    {}

    public Bank(int a, int b)
    {
        setAccount(a,b);
        n++;
    }

    void setAccNum(int c)
    {
        long base;
        if(c==1)
        {
            base = 1300000000;
            account_no = base;
            base++;
        }
        else
        {
            base = 1400000000;
            account_no = base;
            base++;
        }
    }

    void setAccount(int acc, int holder_type)
    {
        if(acc == 1)
        {
            if(holder_type == 1)
            {
                setAccNum(acc);
                account_type = "Savings Account - Adult";
                Adult();
            }
            else if(holder_type == 2)
            {
                setAccNum(acc);
                account_type = "Savings Account - Adult-Joint";
                Adult();
                System.out.println("Beneficiary Details : ");
                ij.setAccount(holder_type);
            }
            else
            {
                setAccNum(acc);
                account_type = "Savings Account - Child";
                System.out.println("Child Details : ");
                ij.setAccount(holder_type);
                System.out.println("Parent/Guardian Details ");
                Adult();
            }
        }
        else 
        {
            setAccNum(acc);
            account_type = "Current Account";
            while(true)
            {
                while(appCount == 0)
                {
                    System.out.print(ANSI_RESET);
                    System.out.print("\t\tEnter Firm License No. : ");
                    System.out.print(ANSI_CYAN);
                    firm_license = sc.next();
                    System.out.print(ANSI_RESET);
                    System.out.print("\t\tAuthenticating License ");
                    progress(3, 500);
                    if(pan.length() == 10)
                    {
                        System.out.println(ANSI_GREEN + "\n\t\tLicense approved!" + ANSI_RESET);
                        appCount++;
                    }
                    else
                    {
                        System.out.println(ANSI_RED + "\n\tLicense declined" + ANSI_RESET);
                    }
                }
                while(appCount == 1)
                {
                    System.out.print(ANSI_RESET);
                    System.out.print("\t\tEnter Firm Electric Bill No. : ");
                    System.out.print(ANSI_CYAN);
                    firm_elecbill = sc.next();
                    System.out.print(ANSI_RESET);
                    System.out.print("\t\tAuthenticating Electric Bill ");
                    progress(3, 500);
                        if(pan.length() == 10)
                        {
                            System.out.println(ANSI_GREEN + "\n\t\tElectric Bill approved!" + ANSI_RESET);
                            appCount++;
                        }
                        else
                        {
                            System.out.println(ANSI_RED + "\n\t\tElectric Bill declined" + ANSI_RESET);
                        }
                }
                if(appCount == 2)
                {
                    break;
                }
            }
            Adult();
        }
    }

    int Adult()
    {
        System.out.print(ANSI_RESET);
        System.out.print("Enter Full Name : ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            try
            {
                Name = sc.nextLine();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Name Format");
                System.out.print("Try again : ");
            }
        }
        System.out.print(ANSI_RESET);
        System.out.print("Enter Gender : ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            try
            {
                gender = sc.next().charAt(0);
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Format");
                System.out.print("Try again : ");
            }
        }
        System.out.print(ANSI_RESET);
        System.out.print("Enter date of birth (dd/mm/yyyy) : ");
        System.out.print(ANSI_CYAN);
        /*while(true)
        {
            date = sc.next();
            try
            {
                dob = new SimpleDateFormat("dd/mm/yyyy").parse(date);
                //age = (Integer.parseInt(formatter.format(doj)) - Integer.parseInt(formatter.format(dob)))/10000;
                if(age < 18)
                {
                    System.out.println("Age is Less Than 18 Years!");
                    System.out.println("Please Opt for Child Account !");
                    System.exit(0);  
                }
                else
                {
                    break;
                }
            }
            catch(ParseException e)
            {
                System.out.println("Enter the date of birth in proper format.");
            }
        }*/
        System.out.print(ANSI_RESET);
        System.out.print("Enter your email address : ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            email = sc.next();
            for(int i=0;i<email.length();i++)
            {
                if(email.charAt(i) == '@')
                {
                    if(email.substring(i).equals("@gmail.com"))
                    {
                        break;
                    }
                    else if(email.substring(i).equals("@yahoo.com"))
                    {
                        break;
                    }
                    else if(email.substring(i).equals("@microsoft.com"))
                    {
                        break;
                    }
                    else if(email.substring(i).equals("@svkmmumbai.onmicrosoft.com"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Email Address!");
                        System.out.print("Try Again : ");
                        break;
                    }
                }
            }
        System.out.print(ANSI_RESET);
        System.out.print("Enter your phone number : ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            try
            {
                phone_number = sc.nextLong();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Number Format");
                System.out.print("Try again : ");
            }
        }
        System.out.print(ANSI_RESET);
        System.out.print("Enter Region (eg ; Vile_Parle) : ");
        System.out.print(ANSI_CYAN);
        address = sc.next();
        System.out.print(ANSI_RESET);
        System.out.print("Enter Pincode : ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            try
            {
                pincode = sc.nextInt();
                if(pincode>400000 && pincode<=400050)
                {
                    bank_branch = "SIKKA NAGAR";
                    ifsc = "SBMS02";
                }
                else if(pincode>400050 && pincode<=400100)
                {
                    bank_branch = "IRLA       ";
                    ifsc = "SBMI02";
                }
                else
                {
                    bank_branch = "GOREGAON   ";
                    ifsc = "SBMG02";
                }
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Name Format");
                System.out.print("Try again : ");
                break;
            }
        }
    
        while(true)
        {
            while(appCount == 0)
            {
                System.out.print(ANSI_RESET);
                System.out.print("\t\tEnter Aadhar Card Number (without spaces): ");
                System.out.print(ANSI_CYAN);
                aadhar = sc.next();
                System.out.print(ANSI_RESET);
                System.out.print("\tAuthenticating Aadhar ");
                progress(3, 500);
                if(aadhar.length() == 12)
                {
                    System.out.println(ANSI_GREEN + "\n\t\tAadhar approved!" + ANSI_RESET);
                    appCount++;
                }
                else
                {
                    System.out.println(ANSI_RED + "\n\tAadhar declined" + ANSI_RESET);
                }
            }

            while(appCount == 1)
            {
                System.out.print(ANSI_RESET);
                System.out.print("\t\tEnter PAN Card Number : ");
                System.out.print(ANSI_CYAN);
                pan = sc.next();
                System.out.print(ANSI_RESET);
                System.out.print("\tAuthenticating Pan ");
                progress(3, 500);
                if(pan.length() == 10)
                {
                    System.out.println(ANSI_GREEN + "\n\t\tPan approved!" + ANSI_RESET);
                    appCount++;
                }
                else
                {
                    System.out.println(ANSI_RED + "\n\tPAN declined" + ANSI_RESET);
                }
            }

            if(appCount == 2)
            {
                break;
            }
        }

        while(true)
        {
            try
            {
                System.out.print(ANSI_RESET);
                char pin[] = cs.readPassword("\t\tSet your 4-digit account pin : ");
                System.out.print(ANSI_CYAN);
                
                String str = String.valueOf(pin);
                account_pin = Integer.parseInt(str);
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter a Numeric Pin");
                System.out.print("Try again : ");
            }
        }
        while(true)
        {
            System.out.print(ANSI_RESET);
            char pin[]= cs.readPassword("\t\tConfirm your account pin : ");
            System.out.print(ANSI_CYAN);
            String str = String.valueOf(pin);
            int conpin = Integer.parseInt(str);
            if(account_pin == (conpin))
            {
                break;
            }
            else
            {
                System.out.println("Wrong Password Entered !");
            }
        }
        System.out.print(ANSI_RESET);
        System.out.print("\t\tSet Application Username (minimum 6 characters & maximum 15 characters): ");
        System.out.print(ANSI_CYAN);
        while(true)
        {
            try
            {
                application_username = sc.next();
                if(application_username.length() < 6 && application_username.length() > 15)
                {
                    System.out.println("Username not in specified range !");
                    System.out.print("Try again : ");
                }
                else
                {
                    break;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Format");
                System.out.print("Try Again!");
            }
        }
        application_pin =  random.nextInt(1000, 9999);
        System.out.print(ANSI_RESET);
        System.out.print("\t\tYour account is being created ");
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.println("\nThank you for your patience !");
            Thread.sleep(1000);
            System.out.println("Your account has now been created !");
            Thread.sleep(1000);
            new Welcome("notify").t.join();
            System.out.println("Your Credentials are as follows : ");
            Thread.sleep(5000);
            System.out.print(ANSI_CYAN);
        }
        catch(InterruptedException e)
        {
            System.out.println("Sorry for the inconvenience");
            System.exit(0);
        }

        System.out.println("Account Number : " + account_no + "\nAccount PIN : " + account_pin + "\nApplication PIN : " + application_pin);
        for(int i=0;i<1000000;i++)
        System.out.print(ANSI_RESET);
        while(account_balance < 1000)
        {
            System.out.println("A minimum deposit of $1000 is required to enable your bank account and related services !");
            System.out.println("Enter amount you would like to deposit : ");
            System.out.print(ANSI_CYAN);
            try
            {
                account_balance = sc.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Name Format");
                System.out.print("Try again : ");
            }
        }
    
        System.out.println(ANSI_GREEN + "Great !! \nYour account has now been enabled !" + ANSI_RESET);
        return 0;
        //fname = Name.substring(0, divide(0));
        /*int wc = divide(0);
        mname = Name.substring(wc, divide(wc));
        wc = divide(wc);
        lname = Name.substring(wc, divide(wc));*/
    }
    }

    public void getAccount()
    {
        System.out.print(ANSI_BLUE);
        String n = "| Account Name : " + Name;
        System.out.println(" __________________________________________________");
        System.out.println("| Branch Name : " + bank_branch + "  Phone : " + phone_number + "     |");
        System.out.println("| IFSC : " + ifsc+"\t\t\t\t\t   |");
        System.out.println("| Account Number : " + account_no + "\t\t\t   |");
        System.out.print(n);
        for(int i=n.length();i<=51;i++)
        {
            if(i==51)
            {
                System.out.println("|");
            }
            else
            {
                System.out.print(" ");
            }
        }
        System.out.println("| Region : " + address + "\t\t\t\t   |");
        System.out.println("| A/c Opening Date : " + formatter.format(doj) + "\t\t\t   |");
        System.out.println("[__________________________________________________]");
    }

    public static void main(String args[])
    {
        Bank b = new Bank(1,1,1300000001L, "Chintan Dodia", 'M', "22/08/2004", "chintan@gmail.com", 987654321L, "Charni Road", 400004, "152436725894", "D5F248W621", 4321, "ChiD_22", 2205, 2000);
        b.getAccount();
    }
}