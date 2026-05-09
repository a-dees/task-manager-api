package com.example.taskmanager.service;
import com.example.taskmanager.dto.TaskRequestDTO;
import com.example.taskmanager.dto.TaskResponseDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //GET ALL
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTitle(),
                        task.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    //GET BY ID
    public TaskResponseDTO getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.isCompleted()
        );
    }

    //CREATE
    public TaskResponseDTO createTask(TaskRequestDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.isCompleted());

        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.isCompleted()
        );
    }

    //DELETE
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    //UPDATE
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO updatedTaskDTO) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        existingTask.setTitle(updatedTaskDTO.getTitle());
        existingTask.setCompleted(updatedTaskDTO.isCompleted());

        Task savedTask = taskRepository.save(existingTask);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.isCompleted()
        );
    }
}
