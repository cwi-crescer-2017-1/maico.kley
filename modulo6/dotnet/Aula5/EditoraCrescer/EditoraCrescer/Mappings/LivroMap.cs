using EditoraCrescer.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Mappings
{
    internal class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");

            HasKey(x => x.Isbn);

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);
        }
    }
}