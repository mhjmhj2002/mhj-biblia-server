package backingBeans;

import entities.Versoes;
import sessionBeans.VersoesFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "versoesController")
@ViewScoped
public class VersoesController extends AbstractController<Versoes> implements Serializable {

    @EJB
    private VersoesFacade ejbFacade;

    public VersoesController() {
        super(Versoes.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
