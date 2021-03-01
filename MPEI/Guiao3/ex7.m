% alinea (a):

a = 15; % media de mensagens recebidas pelo computador

P = ((a^0)/1)*(exp(-a)); % Lei de Poisson

fprintf("P(nao receber nenhuma mensagem num segundo) = %.7f\n", P);

% alinea(b):

Pb=0;

for k = 10:15
    Pb = Pb + ((a^k)/factorial(k))*(exp(-a));
end

fprintf("P(receber pelo menos 10 mensagens) = %.3f\n", Pb);
