package net.wtfitio.platodolist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by plamend on 12/28/13.
 */
public class MainActivity extends Activity {
    List <Task> tasks;
    int task_number;
    EditText input;
    Context context;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        this.tasks= new ArrayList<Task>();
        this.task_number=0;
        this.context=this;
        this.input=(EditText)findViewById(R.id.input);
        this.listview = (ListView)findViewById(R.id.list_view);
        Button new_task=(Button)findViewById(R.id.new_task);
        //Task task1= new Task();
        //task1.setTaskStatus(true);
        //task1.setTaskInfo("empty");
        //tasks.add(task1);

        final TaskAdapter adapter = new TaskAdapter(this,R.layout.list_item_task,tasks);
        this.listview.setAdapter(adapter);

        new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_text = input.getText().toString();
                if (!input_text.equals("")||input_text.length()>0){
                tasks.add(createTask(input_text,task_number));
                task_number++;
                    input.setText("");
                    listview.setAdapter(adapter);
                }
                else{
                    Toast.makeText(context,"Enter valide task!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,"Click it for log time to mark it as Ready",Toast.LENGTH_SHORT).show();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                markAsReady(adapterView,i);
                listview.setAdapter(adapter);
                return false;
            }
        });
    }

    private void markAsReady(AdapterView<?> adapterView, int i) {
        Task task = (Task) adapterView.getItemAtPosition(i);
        task.setTaskStatus(true);

    }

    private Task createTask(String input_text, int task_number) {
        Task task =new Task();
        task.setTaskInfo(input_text);
        task.setTaskStatus(false);
        return task;
    }
}
