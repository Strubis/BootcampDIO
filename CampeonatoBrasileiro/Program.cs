using System;
using CampeonatoBrasileiro;
using CampeonatoBrasileiro.Classes;

namespace CampeonatoBrasileiro
{
    class Program
    {
        private static TimeRepositorio times = new TimeRepositorio();
        static void Main(string[] args)
        {
            Console.WriteLine("Bem vindo ao Brasileirão...");
            
            string op = showMenu();

            while( op.ToUpper() != "X" ){
                switch( op ){
                    case "1":
                        addTime();
                        break;
                    
                    case "2":
                        ListarTimes();
                        break;
                    
                    case "3":
                        infoTime();
                        break;
                    
                    case "4":
                        atualizaTime();
                        break;

                    case "5":
                        excluirTime();
                        break;

                    case "C":
                        Console.Clear();
                        break;
                    
                    default:
                        throw new ArgumentOutOfRangeException();        
                }

                op = showMenu();
            }

        }

        private static void addTime(){
            Console.WriteLine();
            Console.WriteLine("Inserindo um novo time...");

            Console.Write("Digite o nome do time: ");
			string nomeTime = Console.ReadLine();

			Console.Write("Digite o número de Títulos: ");
			int titulosTime = int.Parse(Console.ReadLine());

			Console.Write("Digite o Ano de Fundação: ");
			int anoFundacao = int.Parse(Console.ReadLine());

            foreach (int i in Enum.GetValues(typeof(Estados)))
			{
				Console.WriteLine("{0}-{1}", i, Enum.GetName(typeof(Estados), i));
			}
            Console.Write("Digite o Estado dentre as opções: ");
            int estadoTime = int.Parse(Console.ReadLine());

            Time novoTime = new Time( id: times.proximoId(),
                                    estado: (Estados)estadoTime,
                                    nome: nomeTime,
                                    titulos: titulosTime,
                                    anoFundacao: anoFundacao);

            times.insere(novoTime);
        }

        private static void ListarTimes(){
            Console.WriteLine("\nListando os times...");

            var lista = times.lista();

            if( lista.Count == 0 ){
                Console.WriteLine("Nenhum time disponível.");
                return;
            }

            foreach( var t in lista ){
                var faliu = t.retornaFalido();

                Console.WriteLine( "#ID {0}: - {1} {2}", t.retornaId(), 
                                t.retornaNome(), (faliu? "*Falido*":"Ativo") );
            }

        }

        private static void infoTime(){
            Console.Write("\nDigite o ID do time: ");
            int idTime = int.Parse(Console.ReadLine());

            var time = times.retornaPorId(idTime);

            Console.WriteLine(time);
        }

        private static void atualizaTime(){
            Console.WriteLine("\nAtualizando time...");

            Console.Write("Digite o ID do time: ");
            int idTime = int.Parse(Console.ReadLine());

            Console.Write("Digite o nome do time: ");
			string nomeTime = Console.ReadLine();

			Console.Write("Digite o número de Títulos: ");
			int titulosTime = int.Parse(Console.ReadLine());

			Console.Write("Digite o Ano de Fundação: ");
			int anoFundacao = int.Parse(Console.ReadLine());

            foreach (int i in Enum.GetValues(typeof(Estados)))
			{
				Console.WriteLine("{0}-{1}", i, Enum.GetName(typeof(Estados), i));
			}
            Console.Write("Digite o Estado dentre as opções: ");
            int estadoTime = int.Parse(Console.ReadLine());

            Time novoTime = new Time( id: idTime,
                                    estado: (Estados)estadoTime,
                                    nome: nomeTime,
                                    titulos: titulosTime,
                                    anoFundacao: anoFundacao);
            
            times.atualiza(idTime, novoTime);
        }

        private static void excluirTime(){
            Console.Write("\nDigite o ID do time: ");
            int idTime = int.Parse(Console.ReadLine());

            times.excluir(idTime);
        }

        private static string showMenu(){
            Console.WriteLine();
            Console.WriteLine("Escolha sua opcao:");
            Console.WriteLine("1- Adicionar time");
            Console.WriteLine("2- Listar os times");
            Console.WriteLine("3- Info. do time");
            Console.WriteLine("4- Atualizar um time");
            Console.WriteLine("5- Excluir um time");
            Console.WriteLine("C- Limpar a tela");
            Console.WriteLine("x- Sair");
            Console.WriteLine();

            string op = Console.ReadLine().ToUpper();

            return op;
        }
    }
}
