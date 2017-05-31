using EditoraCrescer;
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
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();
        [Route("")]
        [HttpGet]
        public IHttpActionResult ObterTodosLivros()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }
        [Route("Isbn:int")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorIsbn(int isbn)
        {
            var livro = repositorio.ObterPorIsbn(isbn);

            return Ok(livro);
        }
        [Route("")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            var livro = repositorio.ObterPorGenero(genero);

            return Ok(livro);
        }
        [Route("")]
        [HttpPost]
        public IHttpActionResult AdicionarLivro(Livro livro)
        {
            repositorio.Adicionar(livro);
            return Ok();
        }

        [Route("isbn:int")]
        [HttpPut]
        public IHttpActionResult AlterarLivro(int isbn)
        {
            repositorio.Alterar(isbn);
            return Ok();
        }

        [Route("id:int")]
        [HttpDelete]
        public IHttpActionResult RemoverLivro(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
