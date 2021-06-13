using CovidAPI.Data.Collections;
using CovidAPI.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CuradoController : ControllerBase
    {
        Data.MongoDB _mongoDB;
        IMongoCollection<Curado> _curadoCollection;

        public CuradoController(Data.MongoDB mongoDB)
        {
            _mongoDB = mongoDB;
            _curadoCollection = _mongoDB.Database.GetCollection<Curado>(
                typeof(Curado).Name.ToLower());
        }

        [HttpPost]
        public ActionResult SalvarCurado([FromBody] CuradoDto dto)
        {
            var infectado = new Curado(dto.DataNascimento, dto.Sexo, dto.Latitude, dto.Longitude);
            _curadoCollection.InsertOne(infectado);

            return StatusCode(201, "Curado salvo com sucesso.");
        }

        [HttpGet]
        public ActionResult ObterCurados()
        {
            var curados = _curadoCollection.Find(Builders<Curado>.Filter.Empty).ToList();

            return Ok(curados);
        }
    }
}
