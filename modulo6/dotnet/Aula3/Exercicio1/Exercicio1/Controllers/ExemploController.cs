using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Exercicio1.Controllers
{
    public class ExemploController : Controller
    {
        public List<string> Get()
        {
            var herois = new List<string>()
        {
            "Goku",
            "Batman",
            "Ryu"
        };
            return herois;
        }
    }    
}