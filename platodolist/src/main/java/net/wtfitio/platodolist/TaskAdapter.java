package net.wtfitio.platodolist;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import java.util.List;

/**
 * Created by plamend on 12/28/13.
 */
public class TaskAdapter extends ArrayAdapter<Task>{
    public TaskAdapter(Context context, int list_item_task, List<Task> tasks) {
        super(context,list_item_task,tasks);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            // get the adapter context
            Context context = getContext();
            // create an layout inflater
            LayoutInflater inflater = LayoutInflater.from(context);
            // use the inflater to create the view hierarchy
            convertView = inflater.inflate(R.layout.list_item_task, parent,
                    false);
            // init the holder
            TasksViewHolder holder = initilaseHolder(convertView);
            assert convertView != null;
            convertView.setTag(holder);
        }

        Task task_item = getItem(position);
        TasksViewHolder holder = (TasksViewHolder) convertView.getTag();
        String Task_info = task_item.getTaskInfo();
        Boolean Task_status = task_item.getTaskStatus();
        if (Task_status){
            holder.task.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.task.setText(Task_info);
            holder.task.setChecked(Task_status);
        }
        else{
        holder.task.setText(Task_info);
        holder.task.setChecked(Task_status);
        }



        return convertView;
    }
    private TasksViewHolder initilaseHolder(View covertView){
            TasksViewHolder holder= new TasksViewHolder();
            holder.task = (CheckedTextView) covertView.findViewById(R.id.task);

        return holder;
    }
    private class TasksViewHolder{
        private CheckedTextView task;
    }
}
