package com.taskflow.model;

/**
 * Represents the priority level of a task.
 * Uses enum to define a fixed set of priority levels.
 */
public enum TaskPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    CRITICAL(4);

    // Instance variable - each enum constant has a priority value
    private final int value;

    /**
     * Constructor for TaskPriority enum.
     * Demonstrates constructor in enum and final variables.
     *
     * @param value numeric priority value
     */
    TaskPriority(int value) {
        this.value = value;
    }

    /**
     * Gets the numeric value of this priority.
     *
     * @return priority value (1-4)
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a user-friendly display name for the priority.
     *
     * @return formatted priority name
     */
    public String getDisplayName() {
        // Capitalize first letter, rest lowercase
        String name = this.name();
        return name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
    }

    /**
     * Compares this priority with another priority.
     * Demonstrates relational operators.
     *
     * @param other the priority to compare with
     * @return true if this priority is higher than the other
     */
    public boolean isHigherThan(TaskPriority other) {
        return this.value > other.value;
    }
}