# Preços Mercado

### Descrição

#### Um aplicativo para economizar nas compras!

### Público Alvo

#### Consumidores

### Requisitos não funcionais

- Gratuíto ao consumidor (Exceto livre de progagandas);
- Disponíveis em Android e IOS;
- Usabilidade;
- Usuários logados podem curtir e descurtir os preços(Caso o usuário não logado clique em curtir, apareça um popup de cadastro);
- Popup de histórico de preços;
- Histórico de horários e preços;
- Visualizar preços detalhadamente.

### Requisitos Funcionais

- Tela principal, os produtos mais pesquisados (Clicados);
- Cada produto da tela principal, tera os preços conforme os mercados (Rolagem de preço horizontal);
- Clicando no preço, será exibido um histórico dos preços anteriores;
- Cada preço anterior ou vigente terá uma avaliação com likes e deslikes;
- Os preços serão categorizados por horário:
- - { Macarrão => 
- - 08:00 = R$ 5,00 [Likes: 50, Deslikes: 5]
- - 12:00 = R$ 2,00 [Likes: 10, Deslikes: 60],
- - Resultado: O horário das 12 será descartado, e não irá ser exibido como valor principal. }
- Os usuários que irão adicionar o **Novo preço**
- Se o preço adicionado pelo usuário receber a maior % de deslikes, quer dizer que é um preço falso:
- - O usuário receberá advertência (Pontuação de estrelas);
- - Aquele usuário que tiver uma pontuação negativa, não poderá mais, postar preços (Durante um determinado tempo).
- - OBS: Pensar em uma realimentação da pontuação do usuário.
- Preços de usuários admins ou moderadores, será 100% efetivados e não terá a opção de likes pois é um preço confiável.
- Bonificação de Cash Back;
- Usuários Estrelas (Mercados, padarias, empresas);
- Será possivel criar uma lista compras no proprio aplicativo e calcular qual o mercado mais barato conforme os preços;
- Monetização;
