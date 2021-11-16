package edu.csustan.cs4950.studentplanner;

public class AssignmentModel {
    //id of the assignment
    private int id;
    private String assignment;
    private String description;
    private int date;
    private String task;

    //constructor

    public AssignmentModel(int id, String assignment, String description, int date, String task) {
        this.id = id;
        this.assignment = assignment;
        this.description = description;
        this.date = date;
        this.task = task;
    }

    public AssignmentModel() {
    }

    //toString prints the contents of a class object


    @Override
    public String toString() {
        return "AssignmentModel{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", task='" + task + '\'' +
                '}';
    }

    //Settera and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
