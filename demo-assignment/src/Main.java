import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Learner {
        private final String name;
        private final int age;
        private final int xp;

        Learner(String name, int age, int xp){
            this.name = name;
            this.age = age;
            this.xp = xp;
        }

        int getXp(){
            return xp;
        }

        @Override
        public String toString() {
            return name + " | Age : " + age + " | XP : " + xp;
        }
    }


    private static final List<Learner> learners = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do{
            printMenu();
            choice = readInt("Enter Your Choice :");

            if(choice < 0 || choice > 3){
                System.out.println("⚠ Invalid input choice! try again!");
            }

            switch (choice){
                case 1:
                    addLearner();;
                    break;

                case 2:
                    displayLearners();
                    break;
                case 3:
                    calculateAverageXp();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    System.out.println("👋 Thank you for using Airtribe Manager!");
                    break;

                default:
                    System.out.println("Goodbye!");
                    System.out.println("👋 Thank you for using Airtribe Manager!");
                    break;
            }


        }while (choice != 0);

    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // nextLine() → Reads the entire line entered by the user until they press Enter.
        return value;
    }

    private static void printMenu(){
        System.out.println("\n===== Airtribe Manager =====");
        System.out.println("1. Add Learner");
        System.out.println("2. Display all Learners");
        System.out.println("3. Calculate Average XP");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addLearner(){
        System.out.println("\n---------- Add Learner ---------");
        System.out.print("Enter Name :");
        String name = scanner.nextLine().trim();

        if(name.trim().isEmpty()){
            System.out.println("⚠ Invalid input!");
            System.out.println("Please Enter again Learner's Name : ");
            name = scanner.nextLine().trim();
        }

        int age = readInt("Enter Age: ");

        if(age < 18 || age > 100){
            System.out.println("⚠ Invalid age! age must been between 18 to 100");
            System.out.println("Please Enter again Learner's Age : ");
            age =  readInt("Enter Age: ");
        }
        int xp = readInt("Enter xp :");

        learners.add(new Learner(name,age,xp));
        System.out.println("✓ Learner added successfully!");
    }

    private static void displayLearners(){
        System.out.println("\n---------- Learner's List ---------");

        for(int i = 0; i < learners.size(); i++){
            System.out.println((i + 1) + " | " + learners.get(i));
        }
    }

    private static void calculateAverageXp(){
        if(learners.isEmpty()){
            System.out.println("✗ Learner not found!");
            return;
        }

        double totalAverage = 0;
        for (Learner learner : learners){
            totalAverage += learner.getXp();
        }

        System.out.printf("✓ Average XP: %.2f%n", totalAverage / learners.size());
    }
}