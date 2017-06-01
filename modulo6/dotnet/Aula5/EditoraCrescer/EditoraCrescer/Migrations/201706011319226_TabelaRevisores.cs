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
            Sql("INSERT INTO dbo.Revisores values ('Revisor Locão')");
            Sql("UPDATE dbo.Livros set IdRevisor = 1");
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropColumn("dbo.Livros", "IdRevisor");
            DropColumn("dbo.Livros", "DataRevisao");
            DropTable("dbo.Revisores");
        }
    }
}
