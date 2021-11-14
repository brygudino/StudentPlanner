//Author:       Sherly Yaghoubi
//Description:  Subtask object class

package edu.csustan.cs4950.studentplanner;

public class Subtask {
    //set variables to null to begin with
    String subTaskName = null;
    String details = null;
    String dueDate = null;

    //method to store subtask values in the object
    public void create (String n, String d, String dd){
        //if the value exists, save it
        if (n != null) {
            subTaskName = n;
        }
        if (d != null) {
            details = d;
        }
        if (dd != null) {
            dueDate = dd;
        }
    }

    //method to confirm the subtask was created
    public String confirmSubtask(){
        return "Subtask: '" + subTaskName + "' created!";
    }
}