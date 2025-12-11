Este repositório apresenta a solução para um desafio de desenvolvimento mobile Android, que consiste na criação das telas de Login e Home.

O objetivo principal foi entregar um aplicativo funcional que demonstrasse proficiência em implementação de layout, manipulação de estado (validação de formulário) e navegação entre atividades.

O projeto cobre todos os requisitos do desafio, garantindo uma experiência de usuário e fidelidade visual de alto nível.

O layout da tela de Login foi implementado com precisão pixel-perfect em relação ao design fornecido no Figma.

- Habilitação do Botão: O botão de Login só é ativado e sua cor muda para azul quando ambos os campos (E-mail e Senha) estão preenchidos.
- Exibição de Erros: As mensagens de erro visual (mudança na cor do stroke e texto de feedback) são exibidas somente se as seguintes condições não forem satisfeitas:
- E-mail:** Deve ser um endereço de e-mail válido.
- Senha: Deve conter 4 ou mais caracteres.
- Após o preenchimento correto e login bem-sucedido, o usuário é navegado para a `HomeActivity`, que apresenta uma mensagem de boas-vindas personalizada:
- A mensagem exibe o nome do usuário em letras maiúsculas, extraído da parte do e-mail que precede o símbolo `'@'`.

Exemplo: Se o e-mail for `joao.silva@exemplo.com`, a mensagem será: "BEM-VINDO, JOAO.SILVA".

Desenvolvedores: Alessandra Kaline Cerqueira e Daniel Emygdio