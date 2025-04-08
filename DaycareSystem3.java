import java.util.Scanner;

public class DaycareSystem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_SIZE = 100;
        final int currentYear = 2024;
        final double taxRate = 0.05;
        
        // 1. Ask for number of staff and children (max 100 each)
        System.out.print("Enter number of staff members (max 100): ");
        int numStaff = scanner.nextInt();
        scanner.nextLine();
        if(numStaff > MAX_SIZE) {
            numStaff = MAX_SIZE;
        }
        
        System.out.print("Enter number of children (max 100): ");
        int numChildren = scanner.nextInt();
        scanner.nextLine();
        if(numChildren > MAX_SIZE) {
            numChildren = MAX_SIZE;
        }
        
        // 2. Declare 1-D arrays for staff attributes
        String[] staffName = new String[numStaff];
        int[] birthYear = new int[numStaff];
        String[] gender = new String[numStaff];
        String[] jobTitle = new String[numStaff];
        int[] weeklyHours = new int[numStaff];
        double[] wageRate = new double[numStaff];
        int[] hiringYear = new int[numStaff];
        
        // Input staff information
        System.out.println("\nEnter information for " + numStaff + " staff member(s):");
        for (int i = 0; i < numStaff; i++) {
            System.out.println("\nStaff Member #" + (i + 1));
            System.out.print("First and Last Name: ");
            staffName[i] = scanner.nextLine();
            System.out.print("Year of Birth: ");
            birthYear[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Gender: ");
            gender[i] = scanner.nextLine();
            System.out.print("Job Title: ");
            jobTitle[i] = scanner.nextLine();
            System.out.print("Weekly Hours: ");
            weeklyHours[i] = scanner.nextInt();
            System.out.print("Wage Rate per Hour: ");
            wageRate[i] = scanner.nextDouble();
            System.out.print("Hiring Year: ");
            hiringYear[i] = scanner.nextInt();
            scanner.nextLine();
        }
        
        // 3. Declare 1-D arrays for children attributes
        String[] childName = new String[numChildren];
        int[] childBirthYear = new int[numChildren];
        String[] childGender = new String[numChildren];
        String[] parentName = new String[numChildren];
        String[] parentPhone = new String[numChildren];
        String[] parentLanguage = new String[numChildren];
        String[] hasAllergies = new String[numChildren];
        int[] daysInDaycare = new int[numChildren];
        int[] shiftChoice = new int[numChildren];
        String[] dropOffTime = new String[numChildren];
        String[] pickUpTime = new String[numChildren];
        
        // Input children registration information
        System.out.println("\nEnter information for " + numChildren + " child(ren):");
        for (int i = 0; i < numChildren; i++) {
            System.out.println("\nChild #" + (i + 1));
            System.out.print("First and Last Name: ");
            childName[i] = scanner.nextLine();
            System.out.print("Year of Birth: ");
            childBirthYear[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Gender: ");
            childGender[i] = scanner.nextLine();
            System.out.print("Parent's First and Last Name: ");
            parentName[i] = scanner.nextLine();
            System.out.print("Parent's Phone Number: ");
            parentPhone[i] = scanner.nextLine();
            System.out.print("Parent's First Language: ");
            parentLanguage[i] = scanner.nextLine();
            System.out.print("Allergies (Yes/No): ");
            hasAllergies[i] = scanner.nextLine();
            System.out.print("Number of Days Going to Daycare: ");
            daysInDaycare[i] = scanner.nextInt();
            System.out.print("Shift Choice (1=8am-12pm, 2=12pm-4pm, 3=8am-4pm): ");
            shiftChoice[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Drop Off Time: ");
            dropOffTime[i] = scanner.nextLine();
            System.out.print("Pick Up Time: ");
            pickUpTime[i] = scanner.nextLine();
        }
        
        // 4. Create a 2-D array for parent ratings for staff.
        // Each child (parent) gives a rating for each staff member.
        double[][] ratings = new double[numChildren][numStaff];
        System.out.println("\nEnter ratings for staff (1-5) by each parent:");
        for (int i = 0; i < numChildren; i++) {
            System.out.println("Ratings by Parent #" + (i + 1) + " (for each staff member):");
            for (int j = 0; j < numStaff; j++) {
                System.out.print("Rating for " + staffName[j] + ": ");
                ratings[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }
        
        // 5. Compute average rating for each staff member
        double[] avgRating = new double[numStaff];
        for (int j = 0; j < numStaff; j++) {
            double sum = 0;
            for (int i = 0; i < numChildren; i++) {
                sum += ratings[i][j];
            }
            avgRating[j] = sum / numChildren;
        }
        
        // 6. Sort staff by average rating in descending order using bubble sort.
        // For simplicity, we sort only the staff names and avgRating arrays in parallel.
        for (int i = 0; i < numStaff - 1; i++) {
            for (int j = 0; j < numStaff - i - 1; j++) {
                if (avgRating[j] < avgRating[j + 1]) {
                    // Swap average ratings
                    double tempRating = avgRating[j];
                    avgRating[j] = avgRating[j + 1];
                    avgRating[j + 1] = tempRating;
                    
                    // Swap corresponding staff names
                    String tempName = staffName[j];
                    staffName[j] = staffName[j + 1];
                    staffName[j + 1] = tempName;
                }
            }
        }
        
        // 7. Display sorted staff ratings
        System.out.println("\nStaff Members Sorted by Average Rating (Highest to Lowest):");
        for (int j = 0; j < numStaff; j++) {
            System.out.println(staffName[j] + " - Average Rating: " + String.format("%.2f", avgRating[j]));
        }
        
        // 8. Additional calculations (e.g., salary computation) for staff members
        double[] weeklyPay = new double[numStaff];
        double[] annualSalary = new double[numStaff];
        double[] netIncome = new double[numStaff];
        for (int i = 0; i < numStaff; i++) {
            if (weeklyHours[i] > 40) {
                weeklyPay[i] = (40 * wageRate[i]) + ((weeklyHours[i] - 40) * 1.5 * wageRate[i]);
            } else {
                weeklyPay[i] = weeklyHours[i] * wageRate[i];
            }
            annualSalary[i] = weeklyPay[i] * 52;
            netIncome[i] = annualSalary[i] * (1 - taxRate);
        }
        
        // Display detailed staff information
        System.out.println("\nStaff Information with Salary Details:");
        for (int i = 0; i < numStaff; i++) {
            int experience = currentYear - hiringYear[i];
            System.out.println(staffName[i] + " has " + experience + " years of experience, Weekly Pay: $" +
                    String.format("%.2f", weeklyPay[i]) + ", Annual Salary: $" +
                    String.format("%.2f", annualSalary[i]) + ", Net Income: $" +
                    String.format("%.2f", netIncome[i]) + ", Average Rating: " +
                    String.format("%.2f", avgRating[i]));
        }
        
        // Compute and display children status and weekly bill calculations
        System.out.println("\nChildren Information and Weekly Bills:");
        for (int i = 0; i < numChildren; i++) {
            int age = currentYear - childBirthYear[i];
            double baseRate;
            String ageStatus;
            if (age <= 1) {
                baseRate = 20.0;
                ageStatus = "Infant";
            } else if (age <= 3) {
                baseRate = 15.0;
                ageStatus = "Toddler";
            } else {
                baseRate = 10.0;
                ageStatus = "Preschool";
            }
            
            // Determine daily hours based on shift choice
            double hoursPerDay = (shiftChoice[i] == 1 || shiftChoice[i] == 2) ? 4 : 8;
            double weeklyBill = daysInDaycare[i] * baseRate * hoursPerDay;
            System.out.println("Child: " + childName[i] + ", Age: " + age + " (" + ageStatus +
                    "), Weekly Bill: $" + String.format("%.2f", weeklyBill));
        }
        
        // Close scanner
        scanner.close();
    }
}
