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
    console.log(series[i]);
    if(series[i].anoEstreia>=ano){
      retorno.push(series[i].titulo);
    }
  }
  return retorno;
}
