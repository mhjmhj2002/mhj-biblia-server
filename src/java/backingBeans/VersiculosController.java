package backingBeans;

import entities.Versiculos;
import sessionBeans.VersiculosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "versiculosController")
@ViewScoped
public class VersiculosController extends AbstractController<Versiculos> implements Serializable {

    @EJB
    private VersiculosFacade ejbFacade;

    public VersiculosController() {
        super(Versiculos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
