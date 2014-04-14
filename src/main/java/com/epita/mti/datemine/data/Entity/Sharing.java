/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author leduc_t
 */
@Entity
@XmlRootElement
@AllArgsConstructor @NoArgsConstructor
public class Sharing extends AbstractEntity {

    /**
     * The Sharing id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    @Getter @Setter private Integer id;

    /**
     * The project sharing
     */
    @Column
    @Getter @Setter private Project id_project;

    /**
     * The user with who the project is sharing.
     */
    @Column
    @Getter @Setter private User id_user;

    /**
     * The right of the user on the project,
     * chmod like (1, 2, 4),
     * default (4).
     */
    @Column
    @Getter @Setter private Integer project_right;

    @Override
    public String asCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
