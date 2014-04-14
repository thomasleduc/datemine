package com.epita.mti.datemine.data.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author macbookpro
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
    @Getter @Setter private Integer id;

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

    // @Getter @Setter private User owner;
    
    @Override
    public String asCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
