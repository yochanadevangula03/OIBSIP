import java.util.*;
class bankAcc{
Scanner in=new Scanner(System.in);
 String name;
 String userName;
 String password;
 String accountNo;
 float balance=10000f;
 int transcations=0;
 String tarnscationHistory="";


 // === register
 public void register(){
    System.out.println("Enter Your Name: ");
    this.name=in.nextLine();
    System.out.println("Enter Your UserName: ");
    this.userName=in.nextLine();
    System.out.println("Enter Your password: ");
    this.password=in.nextLine();
    System.out.println("Enter Your Account Number: ");
    this.accountNo=in.nextLine();
    System.out.println("\n--Resteration completed successfully,Please Login to Bank Account.--");
 }


 // ===login
 public boolean login(){
    boolean isLogin=false;
    while(!isLogin){
        System.out.println("\nEnter your User Name: ");
        String username=in.nextLine();
        if(username.equals(userName)){
            while(!isLogin){
                System.out.println("Enter Your Password: ");
                String Password=in.nextLine();
                if(Password.equals(password)){
                    isLogin=true;
                    System.out.println("\n--Login successfully.--");
                }
                else{
                    System.out.println("\n!!  Invalid Password.  !!");
                }
            }
        }
        else{
            System.out.println("\n!!  Inavlid userName.  !!");
        }
    }
    return isLogin;
 }



 // ===withdraw
 public void withdraw(){
    System.out.println("\nEnter Amount To withdraw: ");
    float amount=in.nextFloat();
    in.nextLine();
    try{
        if(balance >=amount){
            transcations++;
            balance-=amount;
            System.out.println("\n--withdraw Successful.--");
            String str=amount + "Rs withdraw\n";
            tarnscationHistory=tarnscationHistory.concat(str);
        }
        else{
            System.out.println("\n!!  Insufficient Balance.  !!");
        }
    }catch(Exception e){

    }
 }



 // ===deposite
 public void deposite(){
    System.out.println("\nEnter Amount To Deposite: ");
    float amount=in.nextFloat();
    in.nextLine();
    try{
        if(amount<=10000f){
            transcations++;
            balance+=amount;
            System.out.println("\n--Dposite Successful.--");
            String str=amount + "Rs Deposite\n";
            tarnscationHistory=tarnscationHistory.concat(str);
        }
        else{
            System.out.println("\n!!  Sorry. The Limit is 10000.  !!");
        }
    }catch(Exception e){

    }
 }


// ===transfer
 public void transfer(){
    System.out.println("\nEnter Receipent's Name: ");
    String resceipent=in.nextLine();
    System.out.println("Enter Amount to Transfer: ");
    float amount=in.nextInt();
     in.nextLine();
    try{ 
        if(balance>=amount){
        if(amount<=50000f){
            transcations++;
            balance-=amount;
            System.out.println("--Succesfully Transfer to: "+resceipent+".--");
            String str=amount + "Rs transferred to " + resceipent + "\n";
            tarnscationHistory=tarnscationHistory.concat(str);
        }
        else{
            System.out.println("!!  Sorry. The Limit is 50000.  !!");
        }
    }
    else
        {
        System.out.println("!!  Insuffient Balance.  !");
        }
    }
        catch(Exception e){

    }
 
}



// ===check baalnce
public void check(){
    System.out.println("\n---BALANCE : "+balance +"Rs---");
}


 // ===transcation History
 public void transHis(){
    if(transcations==0){
        System.out.println("\n--No Transcations Happened.--");
    }
    else{
        System.out.println("\n--TRANSCATION HISTORY--");
        System.out.println(""+tarnscationHistory);
    }
 }
}



public class ATMCre {
    public static int takenInteger(int limit){
        int input=0;
        boolean flag=false;
         
        while(!flag){
            try{
                Scanner in=new Scanner(System.in);
                input=in.nextInt();
                flag=true;
                if(flag && input>limit || input<1){
                    System.out.println("!! Choose Number Between 1 to "+limit+".  !!");
                }
            }
            catch(Exception e){
                System.out.println("!!  Enter only integer value.  !!");
                flag=false;
            }
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("******************************WELCOME TO YOCHANA ATM INTERFACE******************************");
        System.out.println("1.Register \n2.Exit");
        System.out.println("\nChoose one option.");
        int choose=takenInteger(2);
        if(choose==1){
            bankAcc b=new bankAcc();
            b.register();
            while (true) {
                System.out.println("1.Login \n2.Exist");
                System.out.println("\nEnter your choice: ");
                int ch=takenInteger(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("\n\n******************************WELCOME BACK "+b.name+"******************************");
                        boolean isFinished=false;
                        while(!isFinished){
                            System.out.println("\n\n1.withDraw \n2.Deposite \n3.Transfer \n4.Check Balance \n5.Transcation History \n6.Exit");
                            System.out.println("\nEnter your choice: ");
                            int c=takenInteger(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposite();
                                     break;
                                case 3:
                                    b.transfer();
                                     break;
                                case 4:
                                    b.check();
                                     break;
                                case 5:
                                    b.transHis();
                                     break;
                                case 6:
                                    isFinished=true;
                                    break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }
    }
}
