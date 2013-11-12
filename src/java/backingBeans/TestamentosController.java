package backingBeans;

import entities.Testamentos;
import sessionBeans.TestamentosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "testamentosController")
@ViewScoped
public class TestamentosController extends AbstractController<Testamentos> implements Serializable {

    @EJB
    private TestamentosFacade ejbFacade;

    public TestamentosController() {
        super(Testamentos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
