//Ex1
function seriesInvalidas(array) {
  var retorno = "Séries inválidas: ";
  for (let i in array) {
    let verificacao = [array[i].anoEstreia, array[i].diretor, array[i].distribuidora,
    array[i].elenco, array[i].genero, array[i].numeroEpisodios, array[i].temporadas, array[i].titulo]
    if (array[i].anoEstreia>2017) {
      retorno += array[i].titulo + " - ";
    }
    for(let j in verificacao){
      if (verificacao[j] === null || verificacao[j] === undefined) {
        retorno += array[i].titulo + " - ";
      }
    }
  }
  return retorno;
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
  var retorno;
  var utilidade;
  for (let i in series) {
    utilidade = series[i].elenco;
    for (let j in utilidade) {
      if (utilidade[j].match(nome)) {
        retorno = true;
        break;
      } else {
        retorno = false;
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
