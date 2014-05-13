package com.epita.mti.datemine.data.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author leduc_t
 */
@Entity
@XmlRootElement
@AllArgsConstructor @NoArgsConstructor
public class Task extends AbstractEntity {

    /**
     * The task id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    @Getter @Setter private Long id;

    /**
     * The task name.
     */
    @Column
    @Getter @Setter private String name;
    /**
     * The task deadline.
     */
    @Column
    @Getter @Setter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadline;
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
    /**
     * The task group of the task.
     */
    @ManyToOne
    @JoinColumn
    @Getter @Setter private Task parent;
    /**
     * The project of the task.
     */
    @ManyToOne
    @JoinColumn
    @Getter @Setter private Project project;

    @Override
    public String asCSV() {
        return toCSV(id, name, deadline, description,
                     progress, priority, status);
    }
}
