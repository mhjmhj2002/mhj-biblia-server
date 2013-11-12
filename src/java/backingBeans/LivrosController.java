package backingBeans;

import entities.Livros;
import sessionBeans.LivrosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "livrosController")
@ViewScoped
public class LivrosController extends AbstractController<Livros> implements Serializable {

    @EJB
    private LivrosFacade ejbFacade;

    public LivrosController() {
        super(Livros.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
