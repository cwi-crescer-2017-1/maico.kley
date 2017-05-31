using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Entidades;

namespace EditoraCrescer.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();
        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Adicionar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var autor = contexto.Autores.FirstOrDefault(a => (a.Id == id));
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
    }
}
