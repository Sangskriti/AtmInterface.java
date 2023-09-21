import java.util.Scanner;
class BankAccount {
    String name;
    String UserName;
    String password;
    String accountNo;
    int transactions=0;
    float balance = 1000000f;
    String transactionHistory = "";
    public void  register (){
        Scanner sc = new Scanner (System.in);
        System.out.println("\nEnter your name- ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your UserName- ");
        this.UserName = sc.nextLine();
        System.out.println("\nEnetr your password-");
        this.password = sc.nextLine();
        System.out.println("\nEnter your accountNo-");
        this.accountNo= sc.nextLine();
        System.out.println("\nRegistration completed...please login");

    }
    public boolean Login (){
        boolean isLogin = false;
        Scanner sc = new Scanner (System.in);
        while(!isLogin){
            System.out.println("\nEnter your UserName-");
            String UserName = sc.nextLine();
            if(UserName.equals(UserName)){
              while(!isLogin){
                System.out.println("\nEnter your password-");
                String password = sc.nextLine();
            
                 if( password.equals(password)){
                System.out.println("\nLogin is successfull");
                isLogin = true;
                }
                 else{
                System.out.println("\nLogin is in valid...incorrect password");
                }
            }
        }
        else {
        System.out.println("\nUserName not found");
        }
    }
  return isLogin;
}  
  public void withDraw (){
       System.out.print("\nEnter amount to withDraw-");
       Scanner sc = new Scanner(System.in);
       float amount = sc.nextFloat();
       try {
          if(balance>=amount){
            transactions++;
            balance = balance-amount;
            System.out.println("\nwithDraw successfully");
            String str = amount+"rs withDrawed\n";
            transactionHistory = transactionHistory. concat(str);
             }
         else {
                System.out.println("\nInsufficient balance");
           }
        }
             catch (Exception e){
       }
    }
    public void deposit(){
        System.out.print("\nEnter amount to deposit-");
       Scanner sc = new Scanner(System.in);
       float amount = sc.nextFloat();
       try {
          if(amount<=1000000f){
            transactions++;
            balance = balance+amount;
            System.out.println("\ndeposit successfully");
            String str = amount+"rs deposited\n";
            transactionHistory = transactionHistory. concat(str);
             }
         else {
                System.out.println("\nSorry....limit is 1000000.00");
           }
        }
             catch (Exception e){
       }
    
    }
    public void transfer (){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent name -");
        String receipent = sc.nextLine();
        System.out.println("\nEnter amount to transfer - ");
       float amount = sc.nextFloat();
       try {
          if(balance>=amount){
            if( amount <= 50000f){
            transactions++;
            balance = balance-amount;
            System.out.println("\nsuccessfully transfered to " + receipent);
            String str = amount+"rs transfered to " + receipent + "\n";
            transactionHistory = transactionHistory. concat(str);
            }
            else {
                System.out.println("\nSorry...limit is 50000.00" );
            }
        }
         else {
                System.out.println("\nInsufficient balance");
           }
        }
             catch (Exception e){
       }
    
    }
    public void CheckBalance (){
        System.out.println("\n"+ balance + "rs");
    }
    public void transHistory(){
        if (transactions==0){
            System.out.println("\nEmpty");
        }
        else{
            System.out.println("\n"+transactionHistory);
        }
    }

}
public class AtmInterface{
    public static int takeIntegerInput(int limit){
          int input = 0;
          boolean flag = false;
          while(!flag){
            try{
                Scanner sc = new Scanner (System.in);
                input = sc.nextInt();
                flag = true;
                if( flag && input>limit || input<1){
                    System.out.println("choose the number between 1 to "+limit);
                    flag = false;
                }
            }
            catch (Exception e){
                System.out.println("enter only integer value");
                flag = false;
            }
          };
          return input;
    }
public static void main(String args[]){
 System.out.println("\n****WELCOME TO ATM SYSTEM****");
 System.out.println("1.registration \n2.exit");
 System.out.print("enter your choice-");
 int choice = takeIntegerInput(2);
 if(choice == 1){
    BankAccount b = new BankAccount();
    b.register();
    while(true){
        System.out.println("\n1.Login, \n2.Exit");
        System.out.println("enter your choice -");
        int ch = takeIntegerInput(2);
        if(ch==1){
           if(b.Login()){
              System.out.println("\n\n-------WELCOME BACK " +b.name+"---\n");
              boolean isFinished = false;
              while(!isFinished){
        System.out.println("\n1.withDraw \n2.deposit \n3.transfer  \n4.CheakBalance \n5.transHistory \n6.Exit");
        System.out.println("\nenter your choice-");
        int c = takeIntegerInput(6);
        switch(c){
            case 1:
               b.withDraw();
               break;
            case 2:
               b.deposit();
               break;
            case 3:
               b.transfer();
               break;
            case 4:
               b.CheckBalance();
               break;
            case 5:
               b.transHistory();
               break;
            case 6:
              isFinished = true;
              break;
        }
    }

 }
}
else{
    System.exit(0);
}
    }
}
else{
    System.exit(0);
}
}
}





