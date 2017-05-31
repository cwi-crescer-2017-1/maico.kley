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
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();
        
        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();

            return Ok(autores);
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Adicionar(autor);
            return Ok();
        }

        public IHttpActionResult Remove(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
