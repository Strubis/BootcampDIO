package modelDAO;

import connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emerson
 */
public class CursoDAO {
    /**
     * Consulta de todos os cursos.
     * 
     * @return List com todos os cursos dispon�veis e cadastrados no banco de 
     * dados
     */
    public List<Curso> listarCursos(){
        List<Curso> cursos = new ArrayList<>();
        
        try(Connection con = ConnectionFactory.getConnection()){
            
            PreparedStatement stmt = 
                    con.prepareStatement( "SELECT * FROM cursos" );
            ResultSet res = stmt.executeQuery();
            
            while( res.next() ){
                Curso curso = new Curso( 
                        res.getString( "nome" ), 
                        res.getDouble( "duracao_horas" ) );
                curso.setId( res.getInt( "id" ) );
                cursos.add( curso );
            }
            
        }catch(Exception e){
            System.out.println("Erro na listagem!");
        }
        
        return cursos;
    }
    
    /**
     * Busca o curso desejado de acordo com o Id passado.
     * 
     * @param id endere�o do curso desejado
     * @return o Curso desejado pelo usu�rio
     */
    public Curso getCurso(int id){
        Curso curso = null;
        
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = 
                    con.prepareStatement( "SELECT * FROM cursos WHERE id = ?" );
            stmt.setInt( 1, id );
            
            ResultSet res = stmt.executeQuery();
            while( res.next() ){
                curso = new Curso( 
                    res.getString( "nome" ), 
                    res.getDouble( "duracao_horas" ) );
                curso.setId( res.getInt( "id" ) );
            }
            
        }catch(Exception e){
            System.out.println( "Id nao encontrado!" );
        }
        
        return curso;
    }
    
    /**
     * Insere um novo curso no banco de dados.
     * 
     * @param curso o Curso que ser� inserido
     * @return True se ocorreu a inser��o com sucesso, caso contr�rio
     * retorna false
     */
    public boolean inserirCurso(Curso curso){
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = 
                    con.prepareStatement( 
                            "INSERT INTO cursos(nome, duracao_horas) VALUES(?, ?)" );
            stmt.setString( 1, curso.getCurso() );
            stmt.setDouble( 2, curso.getDuracaoHoras() );
            int res = stmt.executeUpdate();
            
            return res > 0;
        }catch(Exception e){
            System.out.println( "Erro ao inserir curso." );
            return false;
        }
    }
    
    /**
     * Remove um curso de acordo com o Id informado.
     * 
     * @param id endere�o do Curso que ser� removido
     * @return True se o Curso foi encontrado e removido com sucesso, false caso
     * contr�rio
     */
    public boolean removerPorId(int id){
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = 
                    con.prepareStatement( "DELETE FROM cursos WHERE id = ?" );
            stmt.setInt( 1, id );
            int res = stmt.executeUpdate();
            
            return res > 0;
        }catch(Exception e){
            System.out.println( "Erro ao remover." );
            return false;
        }
    }
    
    /**
     * Atualiza��o do Curso passado.
     * 
     * @param id endere�o do curso que ser� atualizado
     * @param curso novos dados para o curso ser atualizado
     * @return True se o Curso foi encontrado e atualizado com sucesso, false caso
     * contr�rio
     */
    public boolean updatePorId(int id, Curso curso){
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = 
                    con.prepareStatement( 
                            "UPDATE cursos SET nome = ?, duracao_horas = ? WHERE id = ?" );
            stmt.setString( 1, curso.getCurso() );
            stmt.setDouble( 2, curso.getDuracaoHoras() );
            stmt.setInt( 3, curso.getId() );
            
            int res = stmt.executeUpdate();
            
            return res > 0;
        }catch(Exception e){
            System.out.println( "Erro ao atualizar curso." );
            return false;
        }
    }
}
