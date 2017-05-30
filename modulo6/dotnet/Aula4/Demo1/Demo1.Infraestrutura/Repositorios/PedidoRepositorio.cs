using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = @"Server=13.65.101.67;User Id=maico.kley;Password=123456;Database=aluno09db";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"insert into Pedido (NomeCliente) values (@NomeCliente);";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                   
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }
            }
            foreach(ItemPedido item in pedido.Itens)
            {
                using (var conexao = new SqlConnection(stringConexao))
                {
                    conexao.Open();

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"insert into ItemPedido(PedidoId, ProdutoId, Quantidade)
                                                values(@PedidoId, @ProdutoId, @Quantidade)";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                        using (var comandoInterno = conexao.CreateCommand())
                        {
                            comandoInterno.CommandText = "SELECT @@IDENTITY";
                            var result = (decimal)comandoInterno.ExecuteScalar();
                            item.Id = (int)result;
                        }
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            throw new NotImplementedException();
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
