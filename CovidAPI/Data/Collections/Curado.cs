using MongoDB.Driver.GeoJsonObjectModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidAPI.Data.Collections
{
    public class Curado
    {
        public Curado(DateTime dataNascimento, string sexo, double latitude, double longitude)
        {
            this.DataNascimento = dataNascimento;
            this.Sexo = sexo;
            this.Localizacao = new GeoJson2DGeographicCoordinates(longitude, latitude);
        }

        public string Sexo { get; set; }
        public DateTime DataNascimento { get; set; }
        public GeoJson2DGeographicCoordinates Localizacao { get; set; }
    }
}
