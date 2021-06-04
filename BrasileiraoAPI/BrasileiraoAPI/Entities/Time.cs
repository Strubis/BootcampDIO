using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BrasileiraoAPI.Entities
{
    public class Time
    {
        public Guid id { get; set; }
        public string nome { get; set; }
        public int titulos { get; set; }
        public int anoFundacao { get; set; }
    }
}
