using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace folhaDePagamento
{
    class GeradorDemonstrativo : IFolhaDePagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double SalarioBase = salarioBase;
            double HorasConvencao = horasCategoria;
            double HorasExtras = horasExtras;
            double HorasDescontadas = horasDescontadas;
        }
    }
}
