//Author:       Sherly Yaghoubi
//Description:  Assignment object class

package edu.csustan.cs4950.studentplanner;

public class Assignment {
    //set values as null to begin with
    String assignmentName = null;
    String details = null;
    String dueDate = null;
    String label = null;


    //method to store assignment values in the object
    public void create(String n, String d, String dd, String l, String[] stInfo){
        //if the value exists, save it in the object
        if (n != null){
            assignmentName = n;
        }
        if (d != null) {
            details = d;
        }
        if (dd != null) {
            dueDate = dd;
        }
        if (l != null) {
            label = l;
        }
        if (stInfo != null){
            for (int i = 0; i < stInfo.length; i += 3){
                //create a new subtask object
                Subtask subtask = new Subtask();
                //send the subtask info to the object
                subtask.create(stInfo[i], stInfo[i + 1], stInfo[i + 2]);
                //verify the subtask was created
                System.out.println(subtask.confirmSubtask());
            }
        }
    }

    //method to confirm the assignment was created
    public String confirmAssignment(){
        return "Assignment :'" + assignmentName + "' created";
    }
}