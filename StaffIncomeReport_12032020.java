import java.util.Scanner;
public class StaffIncomeReport_12032020 {
   public static void main(String[] arg){
   Scanner sc = new Scanner(System.in);
   
   String name, id, incomeType;
   double amount, tax;
   
   System.out.println(" ");
   System.out.print("Enter the staff name: ");
      name = sc.nextLine();
   
   System.out.print("Enter the staff ID: ");
      id = sc.next();
      
   System.out.print("What is the income type?: ");
      incomeType = sc.next();
      
   System.out.print("How many is the income amount?: ");
      amount = sc.nextDouble();
      
   System.out.print("Enter the tax percentage: ");
      tax = sc.nextDouble();
   
   System.out.println(" ");
   Income aru = new Income(incomeType, amount, tax);
   Staff imasu = new Staff(name, id, aru);
   
   System.out.println("------- STAFF PERSONAL INFORMATION -------");
   imasu.displayStaffInfo();
   System.out.println(" ");

   System.out.println("------- STAFF INCOME INFORMATION -------");
   imasu.displayIncomeInfo();
   System.out.println(" ");
      
   } 
}

class Income {
   private String incomeType;
   private double amount, tax, totalTax;
   
   Income(String incomeType, double amount, double tax) {
      this.incomeType = incomeType;
      this.amount = amount;
      this.tax = tax;
   }
      
   String getIncomeType() {
      return incomeType;
   }   
   
   double getAmount() {
      return amount;
   }
      
   double getTax() {
      return tax;
   }   
   
   double getTotalTax() {
      totalTax = (tax / 100) * amount;
      return totalTax;
   }
}

class Staff {
   private String name, id;
   private Income income;
   double netincome;
   
   Staff(String name, String id, Income income) {
      this.name = name;
      this.id = id;
      this.income = income;
   }
   
   String getName() {
      return name; 
   }
   
   String getId() {
      return id; 
   }
   
   double calculateNetIncome() {
      netincome = income.getAmount() - income.getTotalTax();
      return netincome;
   }
   
   public void displayStaffInfo() {
      System.out.println("Name: "+ name);
      System.out.println("ID: "+ id);
   }
   
   public void displayIncomeInfo() {
      System.out.println("Income type: "+ income.getIncomeType() );
      System.out.printf("Income amount: %.2f", income.getAmount() );
      System.out.println("\nTax: "+ income.getTax() );
      System.out.printf("Total tax: %.2f", income.getTotalTax() );
      System.out.printf("\nNet income: %.2f", calculateNetIncome() );
   }

}