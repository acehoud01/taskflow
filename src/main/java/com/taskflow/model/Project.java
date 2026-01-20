package com.taskflow.model;

/**
 * Represents a project in the TaskFlow system.
 * A project contains multiple tasks and can have multiple team members.
 * Demonstrates arrays for storing collections of related data.
 */
public class Project {

    // Instance variables
    private String id;
    private String name;
    private String description;
    private String ownerId;              // ID of the user who owns this project
    private String[] memberIds;          // Array of user IDs who are team members
    private String[] taskIds;            // Array of task IDs belonging to this project
    private int memberCount;             // Track actual number of members
    private int taskCount;               // Track actual number of tasks
    private static final int MAX_MEMBERS = 50;  // Maximum team members
    private static final int MAX_TASKS = 100;   // Maximum tasks per project

    /**
     * Full constructor with all parameters.
     *
     * @param id unique project identifier
     * @param name project name
     * @param description project description
     * @param ownerId ID of project owner
     */
    public Project(String id, String name, String description, String ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.memberIds = new String[MAX_MEMBERS];
        this.taskIds = new String[MAX_TASKS];
        this.memberCount = 0;
        this.taskCount = 0;
    }

    /**
     * Constructor without ID - for creating new projects.
     *
     * @param name project name
     * @param description project description
     * @param ownerId ID of project owner
     */
    public Project(String name, String description, String ownerId) {
        this(null, name, description, ownerId);
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String[] getMemberIds() {
        return memberIds;
    }

    public String[] getTaskIds() {
        return taskIds;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public int getTaskCount() {
        return taskCount;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    // Array manipulation methods

    /**
     * Adds a member to the project.
     * Demonstrates array operations and conditional statements.
     *
     * @param userId ID of user to add as member
     * @return true if member was added successfully, false if array is full
     */
    public boolean addMember(String userId) {
        // Check if array is full
        if (memberCount >= MAX_MEMBERS) {
            return false;
        }

        // Check if user is already a member (iterating over arrays)
        for (int i = 0; i < memberCount; i++) {
            if (memberIds[i].equals(userId)) {
                return false;  // Already a member
            }
        }

        // Add the member
        memberIds[memberCount] = userId;
        memberCount++;  // Increment count
        return true;
    }

    /**
     * Removes a member from the project.
     * Demonstrates array iteration and element removal.
     *
     * @param userId ID of user to remove
     * @return true if member was removed, false if not found
     */
    public boolean removeMember(String userId) {
        // Find the member
        for (int i = 0; i < memberCount; i++) {
            if (memberIds[i].equals(userId)) {
                // Shift elements left to fill the gap
                for (int j = i; j < memberCount - 1; j++) {
                    memberIds[j] = memberIds[j + 1];
                }
                memberIds[memberCount - 1] = null;  // Clear last position
                memberCount--;  // Decrement count
                return true;
            }
        }
        return false;  // Member not found
    }

    /**
     * Checks if a user is a member of this project.
     *
     * @param userId ID of user to check
     * @return true if user is a member
     */
    public boolean isMember(String userId) {
        for (int i = 0; i < memberCount; i++) {
            if (memberIds[i].equals(userId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a task to the project.
     *
     * @param taskId ID of task to add
     * @return true if task was added successfully
     */
    public boolean addTask(String taskId) {
        if (taskCount >= MAX_TASKS) {
            return false;
        }

        // Check if task already exists
        for (int i = 0; i < taskCount; i++) {
            if (taskIds[i].equals(taskId)) {
                return false;
            }
        }

        taskIds[taskCount] = taskId;
        taskCount++;
        return true;
    }

    /**
     * Removes a task from the project.
     *
     * @param taskId ID of task to remove
     * @return true if task was removed
     */
    public boolean removeTask(String taskId) {
        for (int i = 0; i < taskCount; i++) {
            if (taskIds[i].equals(taskId)) {
                // Shift elements
                for (int j = i; j < taskCount - 1; j++) {
                    taskIds[j] = taskIds[j + 1];
                }
                taskIds[taskCount - 1] = null;
                taskCount--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the project has any tasks.
     *
     * @return true if project has at least one task
     */
    public boolean hasTasks() {
        return taskCount > 0;
    }

    /**
     * Checks if the project has any members.
     *
     * @return true if project has at least one member
     */
    public boolean hasMembers() {
        return memberCount > 0;
    }

    /**
     * Displays all member IDs.
     * Demonstrates iterating over arrays and printing data.
     */
    public void displayMembers() {
        if (memberCount == 0) {
            System.out.println("No members in this project.");
            return;
        }

        System.out.println("Project Members:");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("  - " + memberIds[i]);
        }
    }

    /**
     * Displays all task IDs.
     */
    public void displayTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks in this project.");
            return;
        }

        System.out.println("Project Tasks:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("  - " + taskIds[i]);
        }
    }

    /**
     * Displays project information.
     */
    public void displayInfo() {
        String display = "=== Project Information ===\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Owner: " + ownerId + "\n" +
                "Members: " + memberCount + "/" + MAX_MEMBERS + "\n" +
                "Tasks: " + taskCount + "/" + MAX_TASKS + "\n" +
                "===========================\n";
        System.out.println(display);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", members=" + memberCount +
                ", tasks=" + taskCount +
                '}';
    }
}
