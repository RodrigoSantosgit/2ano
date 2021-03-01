% alinea (a):

N = 1e5; % numero de experiencias
p = 0.5; % probabilidade do sucesso
n = 4; % numero de tentativas

experiencias = rand(n,N);
numCoroas = sum(experiencias < p);

FMP = histc(numCoroas, 0:n) / N;
stem(FMP)
ylabel('P(X = xi)')
xlabel('xi')
title('Funcao Massa de Probabilidade da variavel aleatoria X');
grid on


% alinea (b):

valorEsperado = sum((0:n).*FMP);
variancia = sum((0:n).^2.*FMP) - valorEsperado ^ 2;
desvioPadrao = sqrt(variancia);

fprintf ('Valor Experado: EX = %.3f\n', valorEsperado)
fprintf ('Variancia = %.3f\n', variancia)
fprintf ('Desvio Padrao = %.3f\n', desvioPadrao)


% alinea (c):

% A varíavel X é uma variável aleatória discreta Binomial.


% alinea (e):

% i)
Pi = sum(FMP(3:end));
fprintf('\nP(sair pelo menos 2 coroas) = %.3f\n', Pi)

% ii)
Pii = sum(FMP(1:2));
fprintf('P(sair no máximo 1 coroa) = %.3f\n', Pii)

% iii)
Piii = FMP(2) + FMP(3) + FMP(4);
fprintf('P(sair entre 1 e 3 coroas) = %.3f\n', Piii)





