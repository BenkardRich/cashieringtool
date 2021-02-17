package CashieringTool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MainClass {
  
	static Account osIng = new Account();
	static Account osWal = new Account();
	static Account rsIng = new Account();
	static Account rsWal = new Account();
	private static Scanner input;
	
	
  public static void main(String[] args) {
    input = new Scanner(System.in);
    String filePathString = System.getProperty("user.dir");
    
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("Welcome to Cashiering Helper v1.0!");
    System.out.println("This little tool is made by BenkardRich,");
    System.out.println("designed to help you through your cashiering!");
    System.out.println("--------------------------------------------------------------------------");
    
    if (new File(filePathString + "/stats.txt").isFile()) {
    	System.out.println("Stats file found! Loading values from file.");
    	loadData();
    }
    else {
    	System.out.println("No stats file found.");
    	System.out.println("Please set your account balances!");
    	System.out.println("-------------------------------------------------------------------------");
        System.out.print("Enter your OSRS wallet amount (in M): ");
        osWal.setBalance(input.nextDouble());
        System.out.print("Enter your OSRS ingame amount (in M): ");
        osIng.setBalance(input.nextDouble());
        System.out.print("Enter your RS3 wallet amount (in M): ");
        rsWal.setBalance(input.nextDouble());
        System.out.print("Enter your RS3 ingame amount (in M): ");
        rsIng.setBalance(input.nextDouble());
        saveData();
    }
    
    System.out.println("What cashiering action do you want to do?");
    System.out.println("-------------------------------------------------------------------------");
    
    boolean loop = true;
    while (loop == true) {
      System.out.println("(1) +++ CASH IN  +++  07 +++ ||| (5) +++ SET  07 WALLET AMOUNT +++");
      System.out.println("(2) --- CASH OUT ---  07 --- ||| (6) --- SET  07 INGAME AMOUNT ---");
      System.out.println("(3) +++ CASH IN  +++ RS3 +++ ||| (7) +++ SET RS3 WALLET AMOUNT +++");
      System.out.println("(4) --- CASH OUT --- RS3 --- ||| (8) --- SET RS3 INGAME AMOUNT ---");
      System.out.println("-----------------07-----------------------------------------RS3-----------");
      System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");
      System.out.println("-------------------------------------------------------------------------");
      
      int i = input.nextInt();
      double amount;
      
      switch (i) {
      case 1:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        osWal.withdraw(amount);
        osIng.deposit(amount);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("YOU HAVE CASHED SOMEONE IN FOR " + amount + " 07! NEW STATS:");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
        break;
      case 2:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        osIng.withdraw(amount);
        osWal.deposit(amount);
        System.out.println("YOU HAVE CASHED SOMEONE OUT FOR " + amount + " 07! NEW STATS:");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
        break;
      case 3:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        rsWal.withdraw(amount);
        rsIng.deposit(amount);
        System.out.println("YOU HAVE CASHED SOMEONE IN FOR " + amount + " RS3! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
        break;
      case 4:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        rsIng.withdraw(amount);
        rsWal.deposit(amount);
        System.out.println("YOU HAVE CASHED SOMEONE OUT FOR " + amount + " RS3! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
        break;
      case 5:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        osWal.setBalance(amount);
        System.out.println("YOU HAVE SET YOUR WALLET TO " + amount + "M 07! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
    	break;
      case 6:
    	System.out.print("Enter amount: ");
        amount = input.nextDouble();
        osIng.setBalance(amount);
        System.out.println("YOU HAVE SET YOUR INGAME TO " + amount + "M 07! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
    	break;
      case 7:
    	System.out.print("Enter amount: ");
        amount = input.nextDouble();
        rsWal.setBalance(amount);
        System.out.println("YOU HAVE SET YOUR WALLET TO " + amount + "M RS3! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
    	break;
      case 8:
        System.out.print("Enter amount: ");
        amount = input.nextDouble();
        rsIng.setBalance(amount);
        System.out.println("YOU HAVE SET YOUR INGAME TO " + amount + "M RS3! NEW STATS:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("07 WALLET/IN: " + osWal.getBalance() + "M | 07 INGAME/OUT: " + osIng.getBalance() + "M ||| RS3 WALLET/IN: " + rsWal.getBalance() + "M | RS3 INGAME/OUT: " + rsIng.getBalance() + "M");    
    	break;
      }
      System.out.println("-------------------------------------------------------------------------");
      saveData();
    }
  }
  
  public static void loadData() {
	  Double osIngValue = 0.0;
	  Double osWalValue = 0.0;
	  Double rsIngValue = 0.0;
	  Double rsWalValue = 0.0;
	  
	  try {
		  BufferedReader br = new BufferedReader(new FileReader("stats.txt"));
		  
		  osWalValue = Double.parseDouble(br.readLine());
		  osIngValue = Double.parseDouble(br.readLine());
		  rsWalValue = Double.parseDouble(br.readLine());
		  rsIngValue = Double.parseDouble(br.readLine());
		  
		  br.close();
		  
	  }
	  catch(Exception e) {
		  System.out.println("Stats could not be loaded.");
	  }
	  osWal.setBalance(osWalValue);
	  osIng.setBalance(osIngValue);
	  rsWal.setBalance(rsWalValue);
	  rsIng.setBalance(rsIngValue);
  }
  
  public static void saveData() {
	  try {
		  BufferedWriter bw = new BufferedWriter(new FileWriter("stats.txt"));
		  
		  bw.write("" + osWal.getBalance());
		  bw.newLine();
		  bw.write("" + osIng.getBalance());
		  bw.newLine();
		  bw.write("" + rsWal.getBalance());
		  bw.newLine();
		  bw.write("" + rsIng.getBalance());
		  
		  bw.close();
	  }
	  catch(Exception e) {
		  System.out.println("Could not save data.");
	  }
  }
}
