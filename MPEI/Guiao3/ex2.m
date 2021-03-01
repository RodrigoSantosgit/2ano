%  alinea (a):

% Espaço Amostragem S = { 100 notas }
% Probabilidade dos acontecimentos elementares:
% P = 1/100


% alinea (b):

% O espaço de amostragem da variável aleatória X, S_X = {5, 50, 100}
% que corresponde aos 3 valores das 100 notas.
% Probabilidades dos varios valores de x:
% P(sair nota de 5) = 90/100 = 9/10,
% P(sair nota de 50) = 9/100,
% P(sair nota de 100) = 1/100.


% alinea (c):

stem([5, 50, 100], [0.9, 0.09, 0.01])
ylabel('P(X = xi)');
xlabel('xi');
axis([0,105,0,1]);
title('Funcao Massa Probabilidade da Variavel Aleatoria X');
grid on