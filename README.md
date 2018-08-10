# SumOne Challenge
Linguagem de programação utilizada - Java 8
Spring boot 2.0.4

## O que é necessário para executar o código
 * É necessária uma variável de ambiente de sistema chamada '**JAVA_HOME**' e como valor o caminho da JDK (Não JRE), exemplo '**C:\Program Files\Java\jdk1.8.0_101**'.
 * P.S: Testado em windows 10 e windows 7.

## Como executar o código
* Clone o repositório ou faça o download em zip e extraia para a pasta que desejar
* Vá até a pasta '**~/s1-challenge-1.0.0**' e clique SHIFT + botão direito do mouse e escolha '**Abrir janela de comando aqui**', ou então abra um prompt de comando e dê cd até a pasta **~/s1-challenge-1.0.0**
* Digite '**mvnw clean install**' e dê enter, isso irá fazer com que o maven seja instalado e todas as dependências necessárias sejam baixadas e fará a construção do arquivo executável do programa
* Após o término do comando acima, digite no prompt de comando '**cd target**' e dê enter
* Digite '**java -jar S1Challenge-1.0.0.jar**' e dê enter, isso irá fazer com que o servidor tomcat embutido no Spring Boot seja inicializado e rode o programa
* Abra o navegador de sua escolha e vá a url '**localhost:8080/ordenar**'
* Digite os livros que deseja ordenar e as regras de ordenação e clique no botão **Enviar**
