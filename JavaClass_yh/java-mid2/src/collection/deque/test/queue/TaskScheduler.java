package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {
    private Queue<Task> taskQueue = new ArrayDeque<>();
    public void addTask(Task task){
        taskQueue.offer(task);
    }

    public int getRemainingTasks(){
        return taskQueue.size();
    }

    public void processNextTask(){
        Task task =  taskQueue.poll();
        if(task != null){
            task.execute();
        }

    }
}
