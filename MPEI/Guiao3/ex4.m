% alinea (a):

N = 1e4;  %numero de experiencias,
n = 5;    %numero de peças tiradas aleatoriamente,
p = 0.3;  %probabilidade do defeito.

experiencias = rand(n, N);
numPecas  = sum(experiencias < p);
prob = histc(numPecas, 0:n) / N;
stem(0:n, prob)
axis([0,6,0,0.50]);
xlabel('Numero de peças defeituosas');
ylabel('P_x(x)')
title('Distribuição de Probabilidades da variavel aleatoria X')
grid on

% alinea (b):

P = sum(prob(1:3));
fprintf('P(no maximo 2 peças defeituosas) = %.3f\n', P)