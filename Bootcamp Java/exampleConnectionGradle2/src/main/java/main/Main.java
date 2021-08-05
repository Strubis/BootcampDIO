package main;

import java.util.List;
import modelDAO.Curso;
import modelDAO.CursoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Emerson
 */
public class Main {

    public static void main(String[] args) {
        // EXEMPLO ------------- JDBC ---------------
        CursoDAO curso = new CursoDAO();
        
        listar( curso );
        System.out.println();
        /* Criação de um curso novo:
        Curso novoCurso = new Curso( "Construcao de Compiladores", 62.10 );
        curso.inserirCurso( novoCurso );
        listar( curso );
        */
        
        /* Remoção de um curso por Id:
        curso.removerPorId(3);
        listar( curso );
        */
        
        /* Atualização de um curso:
        Curso cursoAtualiza = curso.getCurso( 2 );
        cursoAtualiza.setCurso( "Construcao de Compilador" );
        cursoAtualiza.setDuracaoHoras( 63.20 );
        curso.updatePorId( 2, cursoAtualiza );
        listar( curso );
        */
        
        // EXEMPLO -------------- JPA ----------------
        
        // 1- Criando o o Entity para gerenciar o JPA
//        EntityManagerFactory entityManagerFactory = 
//                Persistence.createEntityManagerFactory( "part2-DIO" );
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // 2.1- Criando um novo objeto para testar
//        Curso cursoNovo = new Curso( "Inteligencia Artificial", 40.35 );
        
        // 2.2- Inicia uma transação
//        entityManager.getTransaction().begin();
//        
//        entityManager.persist( cursoNovo );
//        
//        entityManager.getTransaction().commit();
        
        // 3 - Resgatar instâncias no banco de dados
//        Curso cursoEncontrado = entityManager.find( Curso.class, 1 );
//
//        System.out.println( cursoEncontrado );
        
//        // 4 - Alterar uma entidade
//        entityManager.getTransaction().begin();
//
//        cursoEncontrado.setCurso( "IA" );
//        cursoEncontrado.setDuracaoHoras( 42 );
//
//        entityManager.getTransaction().commit();
//
//        // 5 - Remover uma entidade
//        entityManager.getTransaction().begin();
//
//        entityManager.remove( cursoEncontrado );
//
//        entityManager.getTransaction().commit();

        // 6- Fechando o Entity
//        entityManager.close();
//        entityManagerFactory.close();
        
        // EXEMPLO --------------- JPQL ----------------
        
        // 1 - Dados instanciados para serem utilizados como exemplo
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist( new Curso( "MLA", 60) );
//        entityManager.persist( new Curso( "SOC", 45.25) );
//        entityManager.persist( new Curso( "INA", 54.30) );
//        entityManager.getTransaction().commit();
        
        // 2 - Vamos utilizar o método do EntityManager find(), SQL nativo, JPQL e JPA Criteria API para realizar uma
        // consulta que retornarar o mesmo valor equivalente aos seguintes SQL:
        // SELECT * FROM Aluno WHERE id = 1 (Equivalente ao método find do entityManager na parte 2.2)
        // SELECT * FROM Aluno WHERE nome = 'Daniel' (Sera o equivalente para as outras consultas nas partes 2.3 - 2.4 - 2.5)

        // 2.1 O parametro de busca que será utilizado nas proximas consultas
//        String nomeCurso = "MLA";
        
        // =============================================================================================================

        // 2.2 - Utilizando o método find do entityManager
        // Trazendo somente 1 resultado
//        Curso cursoEntityManager = entityManager.find( Curso.class, 1 );

        // Trazendo uma lista como resultado
        // Nao eh possivel!!! Deve utilizar um dos métodos utilizados abaixos nas partes 2.3 - 2.4 - 2.5

        // Resultados das consultas acima
//        System.out.println( "Consulta alunoEntityManager: " + cursoEntityManager );

        // =============================================================================================================

        // 2.3 - SQL nativo

//        // Trazendo somente 1 resultado
//        String sql = "SELECT * FROM Curso WHERE curso = :nomeCurso ";
//        Curso cursoSQL = (Curso) entityManager
//                .createNativeQuery( sql, Curso.class )
//                .setParameter( "nomeCurso", nomeCurso )
//                .getSingleResult();
//
//        // Trazendo uma lista como resultado
//        String sqlList = "SELECT * FROM Curso";
//        List<Curso> alunoSQLList = entityManager
//                .createNativeQuery( sqlList, Curso.class )
//                .getResultList();
//
//        // Resultados das consultas acima
//        System.out.println( "Consulta cursoSQL: " + cursoSQL );
//        alunoSQLList.forEach( Curso -> System.out.println( "Consulta cursoSQLList: " + Curso ) );

        // =============================================================================================================

        // 2.4 - JPQL

//        // Trazendo somente 1 resultado
//        String jpql = "select c from Curso c where c.curso = :nomeCurso";
//        Curso cursoJPQL = entityManager
//                .createQuery( jpql, Curso.class )
//                .setParameter( "nomeCurso", nomeCurso )
//                .getSingleResult();
//
//        // Trazendo uma lista como resultado
//        String jpqlList = "select c from Curso c where c.id = :idCurso";
//        List<Curso> alunoJPQLList = entityManager
//                .createQuery( jpqlList, Curso.class )
//                .setParameter( "idCurso", entityManager.find( Curso.class, 2 ).getId() )
//                .getResultList();
//
//        // Resultados das consultas acima
//        System.out.println( "Consulta cursoJPQL: " + cursoJPQL );
//        alunoJPQLList.forEach( Curso -> System.out.println( "Consulta alunoJPQLList: " + Curso ) );

        // =============================================================================================================

        // 2.5 - JPA Criteria API + JPA Metamodel

//        // Trazendo somente 1 resultado
//        CriteriaQuery<Curso> criteriaQuery = 
//                entityManager.getCriteriaBuilder().createQuery(Curso.class);
//        Root<Curso> cursoRoot = criteriaQuery.from(Curso.class);
//        CriteriaBuilder.In<String> inClause = 
//                entityManager.getCriteriaBuilder().in(cursoRoot.get(Curso.curso));
//        inClause.value(nomeCurso);
//        criteriaQuery.select(cursoRoot).where(inClause);
//        Curso cursoAPICriteria = 
//                entityManager.createQuery(criteriaQuery).getSingleResult();
//
//        // Trazendo uma lista como resultado
//        CriteriaQuery<Curso> criteriaQueryList = 
//                entityManager.getCriteriaBuilder().createQuery(Curso.class);
//        Root<Curso> cursoRootList = criteriaQueryList.from(Curso.class);
//        List<Curso> cursoAPICriteriaList = 
//                entityManager.createQuery(criteriaQueryList).getResultList();
//
//        // Resultados das consultas acima
//        System.out.println("Consulta alunoAPICriteria: " + cursoAPICriteria);
//        cursoAPICriteriaList.forEach(Curso -> System.out.println("Consulta alunoAPICriteriaList: " + Curso));
    }
    
    private static void listar(CursoDAO curso){
        // Listagem dos cursos
        curso.listarCursos().forEach(listarCurso -> {
            System.out.println( listarCurso );
        });
    }
}
