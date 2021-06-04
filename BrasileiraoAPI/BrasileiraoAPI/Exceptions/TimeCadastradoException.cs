using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BrasileiraoAPI.Exceptions
{
    public class TimeCadastradoException : Exception
    {
        public TimeCadastradoException() : base("Este time já está cadastrado.")
        {

        }
    }
}
