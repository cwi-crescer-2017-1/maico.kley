using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Entidades;

namespace EditoraCrescer.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();
        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Adicionar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(a => (a.Id == id));
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}
