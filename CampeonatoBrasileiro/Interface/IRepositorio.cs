using System.Collections.Generic;

namespace CampeonatoBrasileiro.Interface
{
    public interface IRepositorio<Type>
    {
         List<Type> lista();
         Type retornaPorId(int id);
         void insere(Type time);
         int proximoId();
         void excluir(int id);
         void atualiza(int id, Type time);
         
    }
}