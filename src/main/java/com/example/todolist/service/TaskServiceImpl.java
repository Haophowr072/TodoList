package com.example.todolist.service;
import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.dal.mapper.TaskMapper;
import com.example.todolist.dal.repository.TaskRepository;
import com.example.todolist.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<TaskDto> getAllTask() {
        //repostory lun trả về kiểu dữ liệu Entity
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> result = TaskMapper.toTaskDtoList(tasks);
        return result;
    }

    @Override
    public TaskDto getById(String id) {
        Task task = taskRepository.findById(id).orElse(null);
        if(task == null)
            return null;

        TaskDto result = TaskMapper.toTaskDto(task);

        return result;
    }
    //Search Task
    @Override
    public List<TaskDto> search(String keyword) {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> result = new ArrayList<>();
        for(Task task : tasks){
            if(task.getTitle().contains(keyword)){
                result.add(TaskMapper.toTaskDto(task));
            }
        }
        return result;
    }

    @Override
    public TaskDto insert(TaskDto taskDto) {

        try{
            String uuid = UUID.randomUUID().toString();
            taskDto.setId(uuid);
            taskDto.setIsCompleted(false);
            taskDto.setCreatedDate(new Date());
            Task task = TaskMapper.toTask(taskDto);

            //lưu vào task
            taskRepository.save(task);

            return taskDto;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public TaskDto update(TaskDto taskDto) {
        try {
            String id = taskDto.getId();
            taskDto.setId(id);
            taskDto.setUpdatedDate(new Date());
            taskRepository.save(TaskMapper.toTask(taskDto));
            return taskDto;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public boolean delete(String id) {
        try {
            taskRepository.deleteById(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }


}




