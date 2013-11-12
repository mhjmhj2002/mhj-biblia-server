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
@Table(name = "versoes", catalog = "", schema = "MHJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versoes.findAll", query = "SELECT v FROM Versoes v"),
    @NamedQuery(name = "Versoes.findByVrsId", query = "SELECT v FROM Versoes v WHERE v.vrsId = :vrsId"),
    @NamedQuery(name = "Versoes.findByVrsNome", query = "SELECT v FROM Versoes v WHERE v.vrsNome = :vrsNome")})
public class Versoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vrs_id")
    private Integer vrsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vrs_nome")
    private String vrsNome;

    public Versoes() {
    }

    public Versoes(Integer vrsId) {
        this.vrsId = vrsId;
    }

    public Versoes(Integer vrsId, String vrsNome) {
        this.vrsId = vrsId;
        this.vrsNome = vrsNome;
    }

    public Integer getVrsId() {
        return vrsId;
    }

    public void setVrsId(Integer vrsId) {
        this.vrsId = vrsId;
    }

    public String getVrsNome() {
        return vrsNome;
    }

    public void setVrsNome(String vrsNome) {
        this.vrsNome = vrsNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vrsId != null ? vrsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versoes)) {
            return false;
        }
        Versoes other = (Versoes) object;
        if ((this.vrsId == null && other.vrsId != null) || (this.vrsId != null && !this.vrsId.equals(other.vrsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Versoes[ vrsId=" + vrsId + " ]";
    }
    
}
