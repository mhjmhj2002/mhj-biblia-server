/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.Testamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel.jara
 */
@Stateless
public class TestamentosFacade extends AbstractFacade<Testamentos> {
    @PersistenceContext(unitName = "WebApplication10PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestamentosFacade() {
        super(Testamentos.class);
    }
    
}
