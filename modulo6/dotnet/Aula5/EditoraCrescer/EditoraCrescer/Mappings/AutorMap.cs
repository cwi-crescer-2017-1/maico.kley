﻿using EditoraCrescer.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Mappings
{
    internal class AutorMap : EntityTypeConfiguration<Autor>
    {
        public AutorMap()
        {
            ToTable("Autores");
            Property(p => p.Nome).HasMaxLength(300);
        }
    }
}