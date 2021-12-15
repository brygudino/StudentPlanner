# StudentPlanner

On GitHub please select the "updated_main" branch when pulling.

In order to run this program, Android Studio will be needed. 
When you open it, at the top choose the Pixel_3a_API_31_arm64-v8a emulator.
Then, to the left of that, click the drop down and create a configuration to run the app. 
    Where it says "Launch Options", change the "Activity" from "MainActivity" to "HomepageActivity"

That file is found here: StudentPlanner/app/src/main/java/edu.csustan.cs4950.studentplanner/HomepageActivity.java

When you run it, Android Studio should open a emulator that looks like a Google Pixel. 
It will take a few seconds to go, but once it's ready it will open the app on its own. 
Then you can click around and add assignments.
No User ID necessary.

Parameters:
Assignment name: Any string
Assignment Details: Any string
Assignment Due Date: int in form MMDDYYYY
Subtask Details: Any string

Important files in project:
Assignment.java- Assignment Object
AssignmentModel.java- Assignment Object Model
CalendarAdapter.java- Is transition from CalendarViewHolder to homepage.xml
CalendarViewHolder.java- Creates and stores the Calendar information
Database.java- Creates the SQLite database to store assignments
HomepageActivity.java- contains activity for the main homepage
MainActivity.java- contains the activity for the adding assignments homepage
Subtask.java- Subtask object
AssignmentTest.java- test for the Assignment and Subtask objects
activity_main.xml- layout for adding assignments page
calendar_cell.xml- layout for calendar object on the homepage
homepage.xml- layout for the homepage
edit_assignments.xml- layout for the edit assignments page
