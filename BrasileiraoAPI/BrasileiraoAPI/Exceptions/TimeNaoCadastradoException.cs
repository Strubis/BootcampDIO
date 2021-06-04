using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BrasileiraoAPI.Exceptions
{
    public class TimeNaoCadastradoException : Exception
    {
        public TimeNaoCadastradoException() : base("Este time não foi cadastrado.")
        { }
    }
}
