package com.taskflow.model;

/**
 * Represents the status of a task in the system.
 * Uses enum to define a fixed set of possible task statuses.
 */

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    /**
     * Returns user-friendly name for status.
     * Demonstrate method in enum and String operation
     *
     * @return formatted status name
     */

    public String getDisplayName() {
        // Replace underscores with spaces and capitalize properly
        String name = this.name().replace('_', ' ');
        return name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
    }
}
