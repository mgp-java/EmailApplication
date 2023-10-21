import java.sql.SQLOutput;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private int defaultpasswordLength = 10;
    private String email;
    private String companySuffix = "anyCompany.com";

    //Constructor to receive first name and last name
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created : "+this.firstName+"@"+this.lastName);
        //calling a method asking for department
        this.department = setDepartment();
        System.out.println("Department : "+ this.department);
        //call a method to call random password
        this.password = randomPassword(defaultpasswordLength);
        System.out.println("Random password : "+ this.password);
        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"." + companySuffix;
        System.out.println(email);
    }
    //Ask for the department
    private String setDepartment(){
        System.out.println("Enter the department codes : \n 1.Sales \n 2.Development \n 3.Accounting\n 0 for none");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if(deptChoice == 1){return "sales";}
        else if(deptChoice == 2){return "dev";}
        else if(deptChoice == 3){return "accounting";}
        else {return "";}
    }
    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#@$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity(){ return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo()
    {
        return "Display Name : "+firstName+""+lastName+
                "Company Email : "+email+"MailBox Capacity :"+mailboxCapacity+"mb";
    }

}
