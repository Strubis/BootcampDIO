using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace BrasileiraoAPI.InputModel
{
    public class TimeInputModel
    {
        [Required]
        [StringLength(60, MinimumLength = 1, ErrorMessage = "O nome deve conter 1-60 caracteres.")]
        public string nome { get; set; }

        [Required]
        [Range(0, 200, ErrorMessage = "O time deve ter 0 ou mais títulos")]
        public int titulos { get; set; }

        [Required]
        [Range(1500, 2021, ErrorMessage = "O ano deve estar entre 1500 e 2021")]
        public int anoFundacao { get; set; }
    }
}
