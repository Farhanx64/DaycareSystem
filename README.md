Daycare System 3
This project is a Java-based Daycare System that manages the information of staff members and children. The system is designed to be flexible and scalable using one-dimensional arrays to store information (up to 100 records) and a two-dimensional array to store parent ratings for each staff member.

**Features**
- Dynamic Data Entry:

Prompts the user for the number of staff members and children (up to 100 each).

Stores staff and child information in arrays.

- Staff Management:

Records staff member details including name, birth year, gender, job title, weekly hours, wage rate, and hiring year.

Calculates weekly pay (with overtime), annual salary, and net income (after tax deductions).

- Child Management:

Stores child registration details such as name, birth year, gender, parent's contact information, allergies, daycare attendance details, and shift choices.

Computes weekly bills based on the child’s age, shift choice, and number of days attended.

- Rating System:

Uses a two-dimensional array to capture ratings (1-5) provided by each parent for every staff member.

Calculates the average rating for each staff member.

Implements bubble sort to display staff members sorted by their average ratings (highest to lowest).

**Project Structure**
DaycareSystem2.java:
- Contains the full implementation of the system including:

- Declaration of arrays for both staff and children.
 
- Input routines to collect user data.
 
- Computation logic for salaries, billing, and ratings.
 
- Bubble sort algorithm to order staff based on average ratings.
 
- Output routines to display all information in a formatted and user-friendly manner.
