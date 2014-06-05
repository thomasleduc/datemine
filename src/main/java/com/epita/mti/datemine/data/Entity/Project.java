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
public class Project extends AbstractEntity {

    /**
     * The project id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    @Getter @Setter private Long id;

    /**
     * The project name.
     */
    @Column
    @Getter @Setter private String name;

    /**
     * The project URL.
     */
    @Column
    @Getter @Setter private String url;
    
    /**
     * The project creation date.
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Getter @Setter private Date creationDate; 

    /**
     * The user who own the project.
     */
    @ManyToOne
    @JoinColumn
    @Getter @Setter private User owner;
    
    /**
     * Constructor with only the name.
     * @param name The name.
     */
    public Project(String name) {
        this.name = name;
    } 

    @Override
    public String asCSV() {
        return toCSV(id, name, url, creationDate, owner);
    }
}
