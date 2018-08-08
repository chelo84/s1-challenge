var counter = 1;

function addLivro(){
	var container = document.getElementById("servico-de-ordenacao");
	
	var div = document.createElement("div");
	div.className = "input";
	container.appendChild(div);
	
	var idInput = document.createElement("input");
	idInput.className = "input-id";
	idInput.name = "id";
	idInput.value = counter;
	idInput.readOnly = true;
	div.appendChild(idInput);
	
	var tituloInput = document.createElement("input");
	tituloInput.className = "input-titulo";
	tituloInput.name = "titulo";
	div.appendChild(tituloInput);

	var autorInput = document.createElement("input");
	autorInput.className = "input-author";
	autorInput.name = "autor";
	div.appendChild(autorInput);

	var anoEdicaoInput = document.createElement("input");
	anoEdicaoInput.className = "input-edition-year";
	anoEdicaoInput.name = "anoEdicao";
	div.appendChild(anoEdicaoInput);
	
	counter++;
}