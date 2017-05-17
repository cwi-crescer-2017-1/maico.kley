document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    let url = buscaPokemon(document.getElementById('numeroPkm').value);
    fetch(url)
      .then(response => response.json())
      .then(json => {
        console.log(json);
        console.log(json.name, json.id)
        console.log(json.types);
        console.log(json.sprites.front_default);
        let div = document.getElementById('detalhesPokemon');
        let nome = document.createElement('h1')
        let img = document.createElement('img');
        let lista = document.createElement("ul");
          json.types.forEach(type => {
          let item = document.createElement("li");
          item.innerHTML = type.type.name;
          lista.appendChild(item);});
        nome.innerText = json.name.toUpperCase() + " " +  json.id;
        img.src = json.sprites.front_default;
        div.appendChild(nome);
        div.appendChild(img);
        div.appendChild(lista);
          json.stats.forEach(stat => {
          let progress = document.createElement("progress");
          let statName = document.createElement("h6");
          statName.innerText = stat.stat.name;
          progress.max = 100;
          progress.value = stat.base_stat;
          div.appendChild(statName);
          div.appendChild(progress);
          });
        }
      )
    }
  }
)
function buscaPokemon(valor) {
  let url = `http://pokeapi.co/api/v2/pokemon/${valor}`
  return url
}
