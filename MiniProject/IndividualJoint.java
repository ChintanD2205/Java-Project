package MiniProject;
import java.util.*;
import java.text.ParseException;
import java.text.*;

public class IndividualJoint extends Methods
{
    long account_no;
    String b_Name, b_email, b_date, b_aadhar, b_pan, relation;
    int b_phone_number, appCount, b_age;
    char b_gender;
    Date b_dob;
    DateFormat formatter = new SimpleDateFormat("yyyymmdd");
    Scanner sc = new Scanner(System.in);

    void setAccount(int c)
    {
        if(c==2)
        {
            System.out.print("Enter relation with account holder : ");
            relation = sc.next();
        }
        else
        {
            System.out.print("Enter Relation (Parent/Guardian) : ");
            relation = sc.next();
        }
        System.out.print("Enter Full Name : ");
        b_Name = sc.next();
        System.out.print("Enter Gender : ");
        b_gender = sc.next().charAt(0);
        while(true)
        {
            System.out.print("Enter date of birth (dd/mm/yyyy) : ");
            b_date = sc.next();
            if(c==2)
            {
                try
                {
                    b_dob = new SimpleDateFormat("dd/mm/yyyy").parse(b_date);
                    b_age = (Integer.parseInt(formatter.format(new Date())) - Integer.parseInt(formatter.format(b_dob)))/10000;
                    if(b_age < 18)
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
            }
            else
            {
                try
                {
                    b_dob = new SimpleDateFormat("dd/mm/yyyy").parse(b_date);
                    b_age = (Integer.parseInt(formatter.format(b_dob)))/10000;
                    break;
                }
                catch(ParseException e)
                {
                    System.out.println("Enter the date of birth in proper format.");
                }
            }
            
        }
        System.out.print("Enter your b_email address : ");
        while(true)
        {
            b_email = sc.next();
            for(int i=0;i<b_email.length();i++)
            {
                if(b_email.charAt(i) == '@')
                {
                    if(b_email.substring(i).equals("@gmail.com"))
                    {
                        break;
                    }
                    else if(b_email.substring(i).equals("@yahoo.com"))
                    {
                        break;
                    }
                    else if(b_email.substring(i).equals("@microsoft.com"))
                    {
                        break;
                    }
                    else if(b_email.substring(i).equals("@svkmmumbai.onmicrosoft.com"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid b_email Address!");
                        System.out.print("Try Again : ");
                    }
                }
            }
                System.out.print("Enter your phone number : ");
                b_phone_number = sc.nextInt();

                while(true)
                {
                    if(c==2)
                    {
                        while(appCount == 0)
                        {
                            System.out.print("Enter Aadhar Card Number : ");
                            b_aadhar += sc.nextLine();

                            System.out.print("Authenticating Aadhar ");
                            progress(3, 500);
                            if(b_aadhar.length() == 12 || b_aadhar.length() == 14)
                            {
                                System.out.println("\nAadhar approved!");
                                appCount++;
                            }
                            else
                            {
                                System.out.println("\nAadhar declined");
                            }
                        }

                        while(appCount == 1)
                        {
                            System.out.print("Enter PAN Card Number : ");
                            b_pan = sc.next();

                            System.out.print("Authenticating Pan ");
                            progress(3, 500);
                            if(b_pan.length() == 10)
                            {
                                System.out.println("\nPan approved!");
                                appCount++;
                            }
                            else
                            {
                                System.out.println("\nPAN declined");
                            }
                        }

                        if(appCount == 2)
                        {
                            break;
                        }
                    }
                    else
                    {
                        while(appCount == 0)
                        {
                            System.out.print("Enter Aadhar Card Number : ");
                            b_aadhar += sc.nextLine();

                            System.out.print("Authenticating Aadhar ");
                            progress(3, 500);
                            if(b_aadhar.length() == 12 || b_aadhar.length() == 14)
                            {
                                System.out.println("\nAadhar approved!");
                                appCount++;
                            }
                            else
                            {
                                System.out.println("\nAadhar declined");
                            }
                        }
                        if(appCount == 1)
                        {
                            break;
                        }
                    }
                }
            }
        }
}
