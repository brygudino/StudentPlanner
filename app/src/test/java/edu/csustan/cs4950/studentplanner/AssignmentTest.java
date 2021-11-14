// Author:      Sherly Yaghoubi
// Description: To test the Assignment and Subtask objects

package edu.csustan.cs4950.studentplanner;

public class AssignmentTest {
    public static void main(String[] args){

        //create a new assignment object
        Assignment myAssignment = new Assignment();

        //variables to input in the test assignment
        String n = "Report 1";
        String d = "Report 1 for SWE Project";
        String dd = "09/23/21";
        String l = "SWE";
        //variables to input in the test subtasks
        String s1_n = "Sections 1-3";
        String s1_d = "Background sections";
        String s1_dd = "09/17/21";
        String s2_n = "Sections 4-6";
        String s2_d = "Main body sections";
        String s2_dd = "09/20/21";

        //creating a array for all subtask info
        String[] stInfo = {s1_n, s1_d, s1_dd, s2_n, s2_d, s2_dd};

        //use the below to test an assignment w/o subtasks
        //String[] stInfo = null;

        //create the new assignment within the object
        myAssignment.create(n, d, dd, l, stInfo);

        //test to see if the assignment was created
        System.out.println(myAssignment.confirmAssignment());
    }
}
