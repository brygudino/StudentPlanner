package edu.csustan.cs4950.studentplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.studentplanner.MESSAGE";

    //references to buttons and other controls on the layout
    Button btn_addAssignment, btn_viewAll;
    EditText tb_assignment, tb_description, tb_date, tb_task;
    ListView lv_assignmentList;

    ArrayAdapter assignmentArrayAdapter;
    DataBase dataBase;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // \/ THE PAGE THAT FIRST OPENS
        setContentView(R.layout.activity_main);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();


        btn_addAssignment = findViewById(R.id.btn_addAssignment);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        tb_assignment = findViewById(R.id.tb_assignment);
        tb_description = findViewById(R.id.tb_description);
        tb_date = findViewById(R.id.tb_date);
        tb_task = findViewById(R.id.tb_task);
        lv_assignmentList = findViewById(R.id.lv_assignmentList);

        dataBase = new DataBase(MainActivity.this);

        ShowAssignmentOnListView(dataBase);

// button listeners for the add and view all buttons
        btn_addAssignment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// the try catch avoids the app crashing when the user tries to leave fields empty

                AssignmentModel assignmentModel;
                try{
                    assignmentModel = new AssignmentModel(-1, tb_assignment.getText().toString(), tb_description.getText().toString(),Integer.parseInt(tb_date.getText().toString()),tb_task.getText().toString());
                    Toast.makeText(MainActivity.this, assignmentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error creating assignment", Toast.LENGTH_SHORT).show();
                    assignmentModel = new AssignmentModel(-1, "error","error", 0, "error");
                }

    // references assignment database
                DataBase dataBase = new DataBase(MainActivity.this);
                boolean success = dataBase.addOne(assignmentModel);
                Toast.makeText(MainActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                ShowAssignmentOnListView(dataBase);
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
            DataBase dataBase = new DataBase(MainActivity.this);
            ShowAssignmentOnListView(dataBase);

            //Toast.makeText(MainActivity .this,"view all button",Toast.LENGTH_SHORT).show();
        }
        });

        }

    private void ShowAssignmentOnListView(DataBase dataBase2) {
        assignmentArrayAdapter = new ArrayAdapter<AssignmentModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBase2.getEverything());
        lv_assignmentList.setAdapter(assignmentArrayAdapter);
    }
    public void goBackAction(View view) {

        //setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, HomepageActivity.class);
        String message = "homepage";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

