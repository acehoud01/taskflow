package com.taskflow.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task in the TaskFlow system.
 * Demonstrates complex class with multiple data types and relationships.
 * Updated to use LocalDate for proper date handling.
 */
public class Task {

    // Instance variables
    private String id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private String assignedToUserId;  // ID of the user assigned to this task
    private String projectId;         // ID of the project this task belongs to
    private LocalDate dueDate;        // Proper date handling with LocalDate

    /**
     * Full constructor with all parameters.
     *
     * @param id unique task identifier
     * @param title task title
     * @param description task description
     * @param status current status
     * @param priority task priority
     * @param assignedToUserId ID of assigned user
     * @param projectId ID of parent project
     * @param dueDate due date as LocalDate
     */
    public Task(String id, String title, String description, TaskStatus status,
                TaskPriority priority, String assignedToUserId, String projectId,
                LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedToUserId = assignedToUserId;
        this.projectId = projectId;
        this.dueDate = dueDate;
    }

    /**
     * Constructor for creating a new task (without ID).
     * Demonstrates constructor overloading.
     * Default status is TODO and priority is MEDIUM.
     *
     * @param title task title
     * @param description task description
     */
    public Task(String title, String description) {
        this(null, title, description, TaskStatus.TODO, TaskPriority.MEDIUM,
                null, null, null);
    }

    /**
     * Constructor with title, description, and priority.
     *
     * @param title task title
     * @param description task description
     * @param priority task priority
     */
    public Task(String title, String description, TaskPriority priority) {
        this(null, title, description, TaskStatus.TODO, priority, null, null, null);
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public String getAssignedToUserId() {
        return assignedToUserId;
    }

    public String getProjectId() {
        return projectId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setAssignedToUserId(String assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Business logic methods

    /**
     * Checks if the task is assigned to a user.
     * Demonstrates boolean method and comparing values.
     *
     * @return true if task has an assigned user
     */
    public boolean isAssigned() {
        return assignedToUserId != null && !assignedToUserId.isEmpty();
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if status is COMPLETED
     */
    public boolean isCompleted() {
        return status == TaskStatus.COMPLETED;
    }

    /**
     * Checks if the task has high or critical priority.
     * Demonstrates using enum methods and boolean operations.
     *
     * @return true if priority is HIGH or CRITICAL
     */
    public boolean isHighPriority() {
        return priority == TaskPriority.HIGH || priority == TaskPriority.CRITICAL;
    }

    /**
     * Marks the task as completed.
     * Demonstrates modifying object state.
     */
    public void markAsCompleted() {
        this.status = TaskStatus.COMPLETED;
    }

    /**
     * Marks the task as in progress.
     */
    public void markAsInProgress() {
        this.status = TaskStatus.IN_PROGRESS;
    }

    /**
     * Assigns the task to a user.
     *
     * @param userId ID of the user to assign
     */
    public void assignTo(String userId) {
        this.assignedToUserId = userId;
    }

    /**
     * Unassigns the task from current user.
     */
    public void unassign() {
        this.assignedToUserId = null;
    }

    /**
     * Displays task information in a formatted way.
     * Using your improved String concatenation approach!
     */
    public void displayInfo() {
        String display = "=== Task Information ===\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Status: " + status.getDisplayName() + "\n" +
                "Priority: " + priority.getDisplayName() + "\n" +
                "Assigned To: " + (isAssigned() ? assignedToUserId : "Unassigned") + "\n" +
                "Project: " + (projectId != null ? projectId : "None") + "\n" +
                "Due Date: " + (dueDate != null ? dueDate : "Not set") + "\n" +
                "========================\n";
        System.out.println(display);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", assignedTo='" + assignedToUserId + '\'' +
                '}';
    }
}
