
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * Created by rodger on Mar 27, 2019 7:22:48 PM
 */
@Named("pController")
@SessionScoped
public class PessoaController implements Serializable {
    
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pManager;
    
    private int id;
    private String nome;
    
    public String salvar(){
        
        pManager = new PessoaDAO();
        pManager.salvarPessoa(pessoa);
        
        pessoa = new Pessoa();
        
        return "";
    }

    public List<Pessoa> todos(){
        pManager = new PessoaDAO();
        return pManager.todasPessoas();
    }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
}
