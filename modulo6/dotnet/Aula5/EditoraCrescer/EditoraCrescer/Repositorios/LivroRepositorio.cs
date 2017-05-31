using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public void Adicionar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var livro = contexto.Livros.FirstOrDefault(a => (a.Isbn == id));
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

        public object ObterPorIsbn(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
            return livro;
        }

        public object ObterPorGenero(string genero)
        {
            var livro = contexto.Livros.FirstOrDefault(a => (a.Genero.Contains(genero)));
            return livro;
        }

        public void Alterar(int isbn)
        {
            Livro livroAlterado = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Entry(livroAlterado).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
