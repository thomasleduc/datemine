package com.epita.mti.datemine.data.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
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
public class User extends AbstractEntity {
    /**
     * serial version number for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The user id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    @Getter @Setter private Long id;

    /**
     * The user login.
     */
    @Column
    @Getter @Setter private String login;

    /**
     * The user login.
     */
    @Column
    @Getter @Setter private String passwd;
    
    /**
     * The user email.
     */
    @Column
    @Getter @Setter private String email;

    /**
     * The user creation date.
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Getter @Setter private Date creationDate;

    @Override
    public String asCSV() {
        return User.toCSV(id, login, passwd, email, creationDate);
    }
}
