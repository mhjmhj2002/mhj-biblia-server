/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel.jara
 */
@Entity
@Table(name = "testamentos", catalog = "", schema = "MHJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testamentos.findAll", query = "SELECT t FROM Testamentos t"),
    @NamedQuery(name = "Testamentos.findByTesId", query = "SELECT t FROM Testamentos t WHERE t.tesId = :tesId"),
    @NamedQuery(name = "Testamentos.findByTesNome", query = "SELECT t FROM Testamentos t WHERE t.tesNome = :tesNome")})
public class Testamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tes_id")
    private Integer tesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tes_nome")
    private String tesNome;

    public Testamentos() {
    }

    public Testamentos(Integer tesId) {
        this.tesId = tesId;
    }

    public Testamentos(Integer tesId, String tesNome) {
        this.tesId = tesId;
        this.tesNome = tesNome;
    }

    public Integer getTesId() {
        return tesId;
    }

    public void setTesId(Integer tesId) {
        this.tesId = tesId;
    }

    public String getTesNome() {
        return tesNome;
    }

    public void setTesNome(String tesNome) {
        this.tesNome = tesNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tesId != null ? tesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testamentos)) {
            return false;
        }
        Testamentos other = (Testamentos) object;
        if ((this.tesId == null && other.tesId != null) || (this.tesId != null && !this.tesId.equals(other.tesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Testamentos[ tesId=" + tesId + " ]";
    }
    
}
