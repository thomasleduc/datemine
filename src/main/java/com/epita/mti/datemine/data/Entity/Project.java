package com.epita.mti.datemine.data.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
     * The project url.
     */
    @Column
    @Getter @Setter private String url; 

    /**
     * The user who own the project.
     */
    @ManyToOne
    @JoinColumn
    @Getter @Setter private User owner;
    
    @Override
    public String asCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
