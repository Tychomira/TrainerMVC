/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ticho
 */
@Entity
@Table(name = "Trainers", catalog = "trainer_mvc_assignment", schema = "")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t")
//    , @NamedQuery(name = "Trainers.findById", query = "SELECT t FROM Trainers t WHERE t.id = :id")
//    , @NamedQuery(name = "Trainers.findByFirstName", query = "SELECT t FROM Trainers t WHERE t.firstName = :firstName")
//    , @NamedQuery(name = "Trainers.findByLastName", query = "SELECT t FROM Trainers t WHERE t.lastName = :lastName")
//    , @NamedQuery(name = "Trainers.findBySubject", query = "SELECT t FROM Trainers t WHERE t.subject = :subject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @Size(min = 1, max = 25)
    @NotNull
    @Column(name = "subject", length = 25)
    private String subject;

    public Trainer() {
    }

    public Trainer(int id) {
        this.id = id;
    }

    public Trainer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 79 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 79 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trainer other = (Trainer) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.afdemp.trainermvc.entities.Trainers[ id=" + id + " ]";
    }

}
