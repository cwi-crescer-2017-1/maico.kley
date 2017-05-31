namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class TabelaRevisores : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Revisores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 300),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: true));
            Sql("UPDATE dbo.Livros SET IdRevisor = 1");
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            AddColumn("dbo.Livros", "Revisor_Id", c => c.Int());
            CreateIndex("dbo.Livros", "IdRevisor");
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Autores", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            DropColumn("dbo.Livros", "IdRevisor");
            DropColumn("dbo.Livros", "Revisor_Id");
            DropColumn("dbo.Livros", "DataRevisao");
            DropTable("dbo.Revisores");
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id", cascadeDelete: true);

        }
    }
}
