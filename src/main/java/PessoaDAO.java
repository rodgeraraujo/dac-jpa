
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * Created by rodger on Mar 27, 2019 7:23:29 PM
 */
public class PessoaDAO {
    
    private EntityManager em;
    private static final String PERSISTENCE_UNTI = "jpa_pu";
    
    public PessoaDAO() {
        this.em = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNTI)
            .createEntityManager();
    }
    

    public void salvarPessoa(Pessoa p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        System.out.println("<< Pessoa salva >>");
    }

    List<Pessoa> todasPessoas() {
        em.getTransaction().begin();
        String sql = "SELECT p FROM Pessoa p";
        TypedQuery<Pessoa> query = em.createQuery(sql, Pessoa.class);
        List<Pessoa> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }
}
