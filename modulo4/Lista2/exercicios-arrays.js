//Ex1
/*
arrow function
forEach
map
filter
reduce
find
object
Pesquisar sobre e refatorar.
template strings
*/
function seriesInvalidas(array) {
  // var retorno = "Séries inválidas: ";
  // for (let i in array) {
  //   let verificacao = [array[i].anoEstreia, array[i].diretor, array[i].distribuidora,
  //   array[i].elenco, array[i].genero, array[i].numeroEpisodios, array[i].temporadas, array[i].titulo]
  //   if (array[i].anoEstreia>2017) {
  //     retorno += array[i].titulo + " - ";
  //   }
  //   for(let j in verificacao){
  //     if (verificacao[j] === null || verificacao[j] === undefined) {
  //       retorno += array[i].titulo + " - ";
  //     }
  //   }
  // }
  // return retorno;
  let retorno = series.filter(serie =>{ let validacaoAno = serie.anoEstreia> new Date().getFullYear();
    let validacaoCampo = Object.values(serie).some(s=> s===null|| typeof s==='undefined');
    return validacaoCampo || validacaoAno });
    return `Séries Inválidas: ${retorno.map(s => s.titulo).join(" - ") }`;
}
//Ex2
function filtrarSeriesPorAno(series, ano) {
  var retorno = new Array();
  for (let i in series) {
    if(series[i].anoEstreia>=ano){
      retorno.push(series[i].titulo);
    }
  }
  return retorno;
}
//Ex3
function mediaDeEpisodios(series) {
  var numEpisodios = 0;
  var numSeries = 0;
  for (let i in series) {
    numSeries++;
    numEpisodios += series[i].numeroEpisodios;
    console.log(numEpisodios, numSeries);
  }
  return numEpisodios/numSeries;
}
//Ex4
function procurarPorNome(series, nome) {
  var retorno = false;
  var utilidade;
  for (let i in series) {
    utilidade = series[i].elenco;
    for (let j in utilidade) {
      if (utilidade[j].match(nome)) {
        retorno = true;
      }
    }
  }
  return retorno;
}
//Ex5
function mascadaEmSerie(series){
  var mascadaDiretor = 100000*series.diretor.length;
  var mascadaAtor = 40000*series.elenco.length;
  return mascadaDiretor+mascadaAtor;
}
//Ex6
function queroGenero(genero) {
  var retorno = new Array();
  var utilidade;
  for(let i in series){
    utilidade = series[i].genero;
    for (let j in utilidade) {
      if (utilidade[j].match(genero)) {
        retorno.push(series[i].titulo);
      }
    }
  }
  return retorno;
}
function queroTitulo(titulo) {
  var retorno = new Array();
  for (let i in series) {
    if (series[i].titulo.match(titulo)) {
      retorno.push(series[i].titulo);
    }
  }
  return retorno;
}
//Ex7
function creditosIlluminatis(series) {
  var retorno = new Array();
  retorno.push(series.titulo)
  retorno.push("--Diretor(es)--");
  series.diretor.sort();
  series.diretor.reverse()
  for (let i in series.diretor){
    retorno.push(series.diretor[i]);
  }
  retorno.push("--Atores--");
  series.elenco.sort();
  series.elenco.reverse()
  for (let i in series.elenco){
    retorno.push(series.elenco[i]);
  }
  return retorno;
}
//Ex8
function serieIlluminati() {
  var retorno = "#";
  var validacao;
  var elenco;
  var ator;
  for (let i in series) {
    elenco = series[i].elenco;
    validacao = abreviacao(elenco);
    if (validacao == true) {
      for (let j in elenco) {
        ator = elenco[j];
        retorno += ator.substr((ator.indexOf(" ")+1), 1)
      }
    }
  }
  return retorno
}
function abreviacao(elenco) {
  var validacao;
  for (let i in elenco) {
    var ator = elenco[i]
    if(ator[ator.indexOf(" ")+2]==".") {
      validacao=true
    } else {
      validacao=false;
      continue;
    }
  }
  return validacao;
}
