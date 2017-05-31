using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Adicionar(revisor);
            return Ok();
        }

        public IHttpActionResult Remove(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
