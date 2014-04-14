package com.epita.mti.datemine.data.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author leduc_t
 */
public class Task extends AbstractEntity {

    /**
     * The task id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    @Getter @Setter private Integer id;

    /**
     * The task name.
     */
    @Column
    @Getter @Setter private String name;
    /**
     * The task deadline.
     */
    @Column
    @Getter @Setter private Date deadline;
    /**
     * The task description.
     */
    @Column
    @Getter @Setter private String description;
    /**
     * The task progress (in %).
     */
    @Column
    @Getter @Setter private Integer progress;
    /**
     * The task priority (default 0).
     */
    @Column
    @Getter @Setter private Integer priority;
    /**
     * The task status
     * (code to say if the task is started, in progress, submit or finished).
     */
    @Column
    @Getter @Setter private Integer status;
    // Parent task
    // Project

    @Override
    public String asCSV() {
        return toCSV(id, name, deadline, description,
                     progress, priority, status);
    }
}
