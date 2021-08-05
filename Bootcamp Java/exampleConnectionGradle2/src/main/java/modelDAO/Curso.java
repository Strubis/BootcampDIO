package modelDAO;

import javax.persistence.*;

/**
 *
 * @author Emerson
 */
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String curso;
    
    @Column(nullable = false)
    private double duracaoHoras;
    
    public Curso(String curso, double duracaoHoras){
        if( validacao( curso ) && validacao( duracaoHoras ) ){
            this.curso = curso;
            this.duracaoHoras = duracaoHoras;
        }else{
            String errorMsg = "Nome ou duracao do curso invalidos.";
            throw new Error( errorMsg );
        }
    }
    
    private boolean validacao(String string){
        return !string.equals("") && !string.isEmpty();
    }
    
    private boolean validacao(double d){
        return !( d <= 0 );
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setCurso(String novoNome){
        if( validacao( novoNome ) ){
            curso = novoNome;
        }else{
            String errorMsg = "Nome do curso invalido.";
            throw new Error( errorMsg );
        }
    }
    
    public String getCurso(){
        return curso;
    }
    
    public void setDuracaoHoras(double novaDuracao){
        if( validacao( novaDuracao ) ){
            duracaoHoras = novaDuracao;
        }else{
            String errorMsg = "Duracao do curso invalida.";
            throw new Error( errorMsg );
        }
    }
    
    public double getDuracaoHoras(){
        return duracaoHoras;
    }
    
    @Override
    public String toString(){
        return curso != null? "Curso{\n\tId: " + getId() +
                "\n\tNome: " + getCurso() +
                "\n\tHoras de Duracao: " + getDuracaoHoras() +
                "\n}" : "";
    }
}
