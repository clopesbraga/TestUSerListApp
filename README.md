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
| <img width="1440" height="3120" alt="lista_usuarios_ativos" src="https://github.com/user-attachments/assets/c9d03ba3-81e9-4734-843e-72fccc6be62f" />| <img width="1440" height="3120" alt="lista_usuarios_desativados" src="https://github.com/user-attachments/assets/6a884de6-d5cf-425c-bd9b-3d7a23c3c450" />| <img width="1440" height="3120" alt="cadastrar_usuarios" src="https://github.com/user-attachments/assets/d7f53cd5-aebe-4b81-b478-4d2fe5e4f7d3" />|<img width="1440" height="3120" alt="alteracao_cadastro" src="https://github.com/user-attachments/assets/c49ce160-09a7-4e93-8199-d603ced32d3b" />

| Video 1| Video 2 | Video 3 |
|----------|----------|----------|
|[Screen_recording_20250813_133120.webm](https://github.com/user-attachments/assets/b24783bb-0fd8-4d74-9b33-be31bae3e963) | [Screen_recording_20250813_134029.webm](https://github.com/user-attachments/assets/fa8b1cdb-b8f4-462f-b132-c9ef1d5c7b41)|[Screen_recording_20250813_134514.webm](https://github.com/user-attachments/assets/b23a07f0-f46d-43a3-88e9-3c4c68845bbd)|<img width="1440" height="3120" alt="alteracao_cadastro" src="https://github.com/user-attachments/assets/c49ce160-09a7-4e93-8199-d603ced32d3b" />|






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
     

