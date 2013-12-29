package net.wtfitio.platodolist;

import java.io.Serializable;

/**
 * Created by plamend on 12/28/13.
 */
public class Task implements Serializable {

    private String TaskInfo;
    private Boolean TaskStatus;

    public String getTaskInfo(){
        return TaskInfo;
    }
    public Boolean getTaskStatus(){
        return TaskStatus;
    }

    public void setTaskInfo(String info){
        this.TaskInfo=info;
    }

    public void setTaskStatus(Boolean status){
        this.TaskStatus=status;
    }
}
