## Test User List

- Projeto realizado para processo seletivo da empresa Hexagon.
- Meu intuito nesse projeto é de mostrar os meus conhecimentos no desenvolvimento de software.

## Arquitetura utilizada - M.V.V.M (Model-View-ViewModel)

<!--ts-->
   Considerei utilizar esta arquitetura primeiramente devido ser a arquitetura recomendada pelo Google [link](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=pt-br)
   eu a escolhi por acreditar  na facilidade que apresenta para dividir o código e principalmente na facilidade de usar essa arquitetura com Jetpack Compose.
<!--ts-->

## Tecnologias utilizadas e minhas considerações
<!--ts-->
   * [Firebase:](https://firebase.google.com/docs?hl=pt&authuser=0&_gl=1*16m4l23*_ga*MTgzMjQzNjk3MS4xNzEwNDIyNzA5*_ga_CW55HF8NVT*MTcxOTkzODgwOC4yMDYuMS4xNzE5OTM4ODE5LjQ5LjAuMA..)
     Escolhi o Firebase para utilização da autenticação do usuário
     pensando na facilidade da implementação e uso dele no projeto.Outra vantagem em que pensei foi na possiblidade de utilizar seus outros serviços como banco de dados.
   
   * [Room Database:](https://developer.android.com/training/data-storage/room?hl=pt-br)
     Considerei utilizar o Room Database para criar o banco de dados local  devido ele já ser a muito tempo homologado  pelo google
     oferecendo uma grande praticidade para criar as tabelas e utilização dos métodos padrão como salvar, atualizar e deletar.
    
     
   * [Coroutines:](https://developer.android.com/kotlin/coroutines?hl=pt-br)
     Escolhi Coroutines devido e ele ser nativo no Kotlin, oferecer um nível baixo de complexidade ao ler o código, melhor integração e desempenho. 
     
   * [Koin:](https://insert-koin.io/)
     Escolhi utilizar o Koin devido a sua facilidade em aprender e velocidade na realização do build.

     
   * [JetPack Compose:](https://developer.android.com/develop/ui/compose/documentation?hl=pt-br)
     O Jetpack oferece uma grande possibilidade na criação de telas junto com controle dos elementos podendo fazer telas muito bonitas e responsívas
     e acredito que esse vai ser o framework padrão quando o  assunto for desenvolvimento  de novas features em um projeto para Android. 
<!--te-->

## Features criadas

- [x] Cadastro de usuário
- [x] Alterar cadastro
- [x] Ativar ou desativar o usuário do cadastro
- [X] Mostrar a lista de usuários ativos ou desativados

| Lista Ativos | Lista Desativados | Registro | Atualização|
|----------|----------|----------|----------|
|![Screenshot_20240715_165600](https://github.com/user-attachments/assets/966af895-12b5-43f0-9959-11b478d78e6a)|![Screenshot_20240715_170801](https://github.com/user-attachments/assets/48db9c05-6ec2-49ca-a00b-90decdbb4d35)| ![Screenshot_20240715_171259](https://github.com/user-attachments/assets/5a97eb4e-cd85-4425-823b-ed85bd29ea9d))|![Screenshot_20240715_171917](https://github.com/user-attachments/assets/9def659c-391e-4fd9-a8c2-1a8982f24147)



## Como baixar o apk.

Para utilizar a versão mais recente pode acessar o este [link](https://github.com/clopesbraga/EcoTrack/releases)  ou realizar o clone do proejto.

## Instalando o app no celular

Tendo realizado o download do apk para utilizá-lo é necessário realizar os seguintes passos:

- Deixar o celular no modo desenvolvedor
  
   - No seu device vá em configurações/ settings.
   - Role a tela até sobre o telefone e toque em informações de software
   - desça a tela até a opção 'número de compilação'
   - toque 7 vezes até aparecer um pop up em sua tela informando que está no 'modo desenvolvedor

-  Liberando para uso do apk
  
   - Abra o aplicativo Configurações no seu dispositivo Android.
   - Toque em "Segurança" para abrir o menu Segurança
   - Role para baixo e marque a caixa "Fontes desconhecidas". Toque em "OK" para confirmar.
   - Baixe o arquivo Apk  
     

## Observações do Projeto
🚧  Em andamento 🚧
