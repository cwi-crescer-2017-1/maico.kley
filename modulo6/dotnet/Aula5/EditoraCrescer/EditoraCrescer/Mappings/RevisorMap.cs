using EditoraCrescer.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Mappings
{
    internal class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");
            Property(p => p.Nome).HasMaxLength(300);
        }
    }
}
