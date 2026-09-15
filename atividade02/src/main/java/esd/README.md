# Agenda de Contatos - Array de Listas

## Questões para Responder na Entrega

### 1. Por que essa abordagem usando um array de instâncias da classe Vetor torna a busca de um contato mais rápida em comparação com a versão anterior (uma única lista contendo todos os contatos)?

Na versão anterior, todos os contatos ficavam numa lista só, então pra achar
alguém o programa precisava, no pior caso, passar por todos os elementos até
encontrar (ou não encontrar) o nome. Se eu tivesse 10.000 contatos, a busca
podia ter que olhar os 10.000, um por um.

Com o array de 26 posições, eu já "corto caminho" antes de começar a busca de
verdade: em vez de vasculhar tudo, eu olho só a primeira letra do nome e vou
direto na gaveta certa (índice = letra - 'A'). Isso é O(1), instantâneo, não
depende de quantos contatos existem.

Depois disso, eu só preciso buscar dentro daquele Vetor específico da letra,
que é bem menor que a lista inteira. Se eu tenho 10.000 contatos espalhados
mais ou menos igual entre as 26 letras, cada gaveta vai ter uns 380 contatos
em vez de 10.000. Ou seja, eu troquei "procurar em 10.000" por "ir direto na
gaveta certa + procurar em +-380". Isso deixa a busca (e também o inserir e o
remover) bem mais rápida na prática, porque o espaço de busca real fica bem
menor.

### 2. O que acontece com o desempenho da busca se a maioria dos contatos cadastrados começar com a mesma letra (ex: centenas de nomes iniciando com a letra "M")? O sistema continuará rápido? Justifique.

Não, nesse caso o ganho de performance praticamente desaparece pra essa
letra específica. Se centenas (ou milhares) de contatos começarem com "M",
o Vetor da posição do "M" vai crescer até ficar do tamanho de uma lista
gigante sozinho, enquanto as outras 25 gavetas continuam pequenas ou até
vazias.

Ou seja, o "ir direto na gaveta certa" continua sendo rápido (isso não muda,
é sempre O(1)), mas depois disso eu ainda preciso fazer uma busca linear
dentro daquele Vetor enorme do "M" - e aí sim, no pior caso, eu volto a
percorrer centenas de elementos, exatamente como acontecia na lista única
original.

Isso acontece porque essa estrutura só é eficiente quando os dados estão bem
distribuídos entre as 26 posições. Quando a distribuição é desbalanceada
(muita gente com nomes começando com a mesma letra), a gente perde a
vantagem principal do array de listas, porque uma das gavetas concentra
quase todo o trabalho que antes estava espalhado pela lista inteira.

Uma forma de melhorar isso, se fosse continuar evoluindo o sistema, seria
usar uma estrutura de espalhamento melhor (tipo uma função de hash que olha
mais de uma letra do nome, ou uma tabela hash de verdade) em vez de depender
só da primeira letra, que na prática não distribui os nomes de forma tão
uniforme (tem muito mais gente com nomes começando com "M", "A" ou "J" do
que com "X", "Y" ou "Z", por exemplo).
