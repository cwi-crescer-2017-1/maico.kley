using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> entradas = new List<int>();

            bool continua = true;

            while (continua)
            {
                var linhaLida = Console.ReadLine();
                if(linhaLida == "exit")
                {
                    break;
                }

                entradas.Add(int.Parse(linhaLida));
            }

            foreach (var entrada in entradas)
            {
                Console.WriteLine(entrada);
            }
            Console.WriteLine("===FIM===");
            Console.ReadKey();
        }
    }
}
