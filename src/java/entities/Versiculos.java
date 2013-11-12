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
import javax.persistence.Lob;
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
@Table(name = "versiculos", catalog = "", schema = "MHJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versiculos.findAll", query = "SELECT v FROM Versiculos v"),
    @NamedQuery(name = "Versiculos.findByVerId", query = "SELECT v FROM Versiculos v WHERE v.verId = :verId"),
    @NamedQuery(name = "Versiculos.findByVerVrsId", query = "SELECT v FROM Versiculos v WHERE v.verVrsId = :verVrsId"),
    @NamedQuery(name = "Versiculos.findByVerLivId", query = "SELECT v FROM Versiculos v WHERE v.verLivId = :verLivId"),
    @NamedQuery(name = "Versiculos.findByVerCapitulo", query = "SELECT v FROM Versiculos v WHERE v.verCapitulo = :verCapitulo"),
    @NamedQuery(name = "Versiculos.findByVerVersiculo", query = "SELECT v FROM Versiculos v WHERE v.verVersiculo = :verVersiculo")})
public class Versiculos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ver_id")
    private Integer verId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ver_vrs_id")
    private int verVrsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ver_liv_id")
    private int verLivId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ver_capitulo")
    private int verCapitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ver_versiculo")
    private int verVersiculo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "ver_texto")
    private String verTexto;

    public Versiculos() {
    }

    public Versiculos(Integer verId) {
        this.verId = verId;
    }

    public Versiculos(Integer verId, int verVrsId, int verLivId, int verCapitulo, int verVersiculo, String verTexto) {
        this.verId = verId;
        this.verVrsId = verVrsId;
        this.verLivId = verLivId;
        this.verCapitulo = verCapitulo;
        this.verVersiculo = verVersiculo;
        this.verTexto = verTexto;
    }

    public Integer getVerId() {
        return verId;
    }

    public void setVerId(Integer verId) {
        this.verId = verId;
    }

    public int getVerVrsId() {
        return verVrsId;
    }

    public void setVerVrsId(int verVrsId) {
        this.verVrsId = verVrsId;
    }

    public int getVerLivId() {
        return verLivId;
    }

    public void setVerLivId(int verLivId) {
        this.verLivId = verLivId;
    }

    public int getVerCapitulo() {
        return verCapitulo;
    }

    public void setVerCapitulo(int verCapitulo) {
        this.verCapitulo = verCapitulo;
    }

    public int getVerVersiculo() {
        return verVersiculo;
    }

    public void setVerVersiculo(int verVersiculo) {
        this.verVersiculo = verVersiculo;
    }

    public String getVerTexto() {
        return verTexto;
    }

    public void setVerTexto(String verTexto) {
        this.verTexto = verTexto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (verId != null ? verId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versiculos)) {
            return false;
        }
        Versiculos other = (Versiculos) object;
        if ((this.verId == null && other.verId != null) || (this.verId != null && !this.verId.equals(other.verId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Versiculos[ verId=" + verId + " ]";
    }
    
}
