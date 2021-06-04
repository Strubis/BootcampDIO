using BrasileiraoAPI.Exceptions;
using BrasileiraoAPI.InputModel;
using BrasileiraoAPI.Services;
using BrasileiraoAPI.ViewModel;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace BrasileiraoAPI.Controllers.V1
{
    [Route("api/V1/[controller]")]
    [ApiController]
    public class TimesController : ControllerBase
    {
        private readonly ITimeService _timeService;

        public TimesController(ITimeService timeService)
        {
            _timeService = timeService;
        }

        /// <summary>
        /// Apresenta todos os times cadastrados.
        /// </summary>
        /// <remarks>
        /// Não é possível retornar os times sem paginação.
        /// </remarks>
        /// <param name="pagina">Indique qual página será consultada.</param>
        /// <param name="quantidade">Indique a quantidade de times que irá aparecer.</param>
        /// <response code="200">Retorna a lista de times.</response>
        /// <response code="204">Caso não haja times.</response>
        [HttpGet]
        public async Task<ActionResult<IEnumerable<TimeViewModel>>> Obter(
            [ FromQuery, Range(1, int.MaxValue) ] int pagina = 1, 
            [ FromQuery, Range(1, 50) ] int quantidade = 5 )
        {

            var times = await _timeService.Obter(pagina, quantidade);

            if (times.Count() == 0)
                return NoContent();

            return Ok(times);
        }

        /// <summary>
        /// Buscar um time pelo seu Id.
        /// </summary>
        /// <param name="idTime">Id do time buscado.</param>
        /// <response code="200">Retorna o jogo filtrado.</response>
        /// <response code="204">Caso não haja time com esse Id.</response>
        [HttpGet("{idTime:guid}")]
        public async Task<ActionResult<TimeViewModel>> ObterTime([FromRoute] Guid idTime)
        {
            var time = await _timeService.ObterTime(idTime);

            if (time == null)
                return NoContent();

            return Ok(time);
        }

        // Insere um novo elemento.
        [HttpPost]
        public async Task<ActionResult<TimeViewModel>> InserirTime([FromBody] TimeInputModel timeInputModel)
        {
            try
            {
                var result = await _timeService.InserirTime(timeInputModel);

                return Ok(result);

            }catch( TimeCadastradoException ex )
            {
                return UnprocessableEntity("Já existe um time com este nome na competição.");
            }

            return Ok();
        }

        // Atualiza o elemento inteiro.
        [HttpPut("{idTime:guid}")]
        public async Task<ActionResult> AtualizarTime([FromRoute] Guid idTime, [FromBody] TimeInputModel timeInputModel)
        {
            try
            {
                await _timeService.AtualizarTime(idTime, timeInputModel);

                return Ok();

            }catch( TimeNaoCadastradoException ex )
            {
                return NotFound("Este time não existe.");
            }

            return Ok();
        }

        // Atualiza um valor específico do elemento.
        [HttpPatch("{idTime:guid}/titulos/{titulos:int}")]
        public async Task<ActionResult> AtualizarTime([FromRoute] Guid idTime, [FromRoute] int titulos)
        {
            try
            {
                await _timeService.AtualizarTime(idTime, titulos);

                return Ok();

            }catch( TimeNaoCadastradoException ex )
            {
                return NotFound("Este time não existe.");
            }

            return Ok();
        }

        //Deleta o elemento.
        [HttpDelete("{idTime:guid}")]
        public async Task<ActionResult> ApagarTime([FromRoute] Guid idTime) 
        {
            try
            {
                await _timeService.ApagarTime(idTime);

                return Ok();

            }catch( TimeNaoCadastradoException ex )
            {
                return NotFound("O time não existe.");
            }

            return Ok();
        }

    }
}
