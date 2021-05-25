using CampeonatoBrasileiro.Interface;
using System;
using System.Collections.Generic;
using CampeonatoBrasileiro.Classes;

namespace CampeonatoBrasileiro
{
    public class TimeRepositorio : IRepositorio<Time>
    {
        private List<Time> listaTimes = new List<Time>();

        public void atualiza(int id, Time objeto)
		{
			listaTimes[id] = objeto;
		}

		public void excluir(int id)
		{
			listaTimes[id].Excluir();
		}

		public void insere(Time objeto)
		{
			listaTimes.Add(objeto);
		}

		public int proximoId()
		{
			return listaTimes.Count;
		}

		public List<Time> lista()
		{
			return listaTimes;
		}

		public Time retornaPorId(int id)
		{
			return listaTimes[id];
		}
    }
}