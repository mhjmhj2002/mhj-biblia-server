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
@Table(name = "livros", catalog = "", schema = "MHJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livros.findAll", query = "SELECT l FROM Livros l"),
    @NamedQuery(name = "Livros.findByLivId", query = "SELECT l FROM Livros l WHERE l.livId = :livId"),
    @NamedQuery(name = "Livros.findByLivTesId", query = "SELECT l FROM Livros l WHERE l.livTesId = :livTesId"),
    @NamedQuery(name = "Livros.findByLivPosicao", query = "SELECT l FROM Livros l WHERE l.livPosicao = :livPosicao"),
    @NamedQuery(name = "Livros.findByLivNome", query = "SELECT l FROM Livros l WHERE l.livNome = :livNome")})
public class Livros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "liv_id")
    private Integer livId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "liv_tes_id")
    private int livTesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "liv_posicao")
    private int livPosicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "liv_nome")
    private String livNome;

    public Livros() {
    }

    public Livros(Integer livId) {
        this.livId = livId;
    }

    public Livros(Integer livId, int livTesId, int livPosicao, String livNome) {
        this.livId = livId;
        this.livTesId = livTesId;
        this.livPosicao = livPosicao;
        this.livNome = livNome;
    }

    public Integer getLivId() {
        return livId;
    }

    public void setLivId(Integer livId) {
        this.livId = livId;
    }

    public int getLivTesId() {
        return livTesId;
    }

    public void setLivTesId(int livTesId) {
        this.livTesId = livTesId;
    }

    public int getLivPosicao() {
        return livPosicao;
    }

    public void setLivPosicao(int livPosicao) {
        this.livPosicao = livPosicao;
    }

    public String getLivNome() {
        return livNome;
    }

    public void setLivNome(String livNome) {
        this.livNome = livNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (livId != null ? livId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livros)) {
            return false;
        }
        Livros other = (Livros) object;
        if ((this.livId == null && other.livId != null) || (this.livId != null && !this.livId.equals(other.livId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Livros[ livId=" + livId + " ]";
    }
    
}
