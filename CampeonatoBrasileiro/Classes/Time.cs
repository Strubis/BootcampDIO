using CampeonatoBrasileiro;
using System;

namespace CampeonatoBrasileiro.Classes
{
    public class Time : timeBase
    {
        private Estados estado { get; set; }
		private string nome { get; set; }
		private int titulos { get; set; }
		private int anoFundacao { get; set; }
        private bool faliu {get; set;}

        public Time(int id, Estados estado, string nome, int titulos, int anoFundacao)
		{
			this.id = id;
			this.estado = estado;
			this.nome = nome;
			this.titulos = titulos;
			this.anoFundacao = anoFundacao;
            this.faliu = false;
		}

        public override string ToString()
		{
            string retorno = "";
            
            retorno += "Nome: " + this.nome + Environment.NewLine;
            retorno += "Titulos: " + this.titulos + Environment.NewLine;
            retorno += "Estado: " + this.estado + Environment.NewLine;
            retorno += "Ano de Fundação: " + this.anoFundacao + Environment.NewLine;
            retorno += "Falido: " + this.faliu;

			return retorno;
		}

		public string retornaNome(){
			return this.nome;
		}
        public int retornaTitulos()
		{
			return this.titulos;
		}

		public int retornaId()
		{
			return this.id;
		}
        public bool retornaFalido()
		{
			return this.faliu;
		}
        public void Excluir() {
            this.faliu = true;
        }
    }
}