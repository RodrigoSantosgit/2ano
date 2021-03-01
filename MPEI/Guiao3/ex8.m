x = [1:4]; % valores que a variavél aleatoria assume

fx = (x+5)./30; % função f(x) para os valores da variável aleatória

if (min(fx) >= 0 && max(fx) <= 1 && sum(fx) == 1)
    fprintf("A função f(x) = (x + 5)/30 pode representar a variavél aleatória para os valores 1, 2, 3 e 4.\n")
else 
    fprintf("A função f(x) = (x + 5)/30 não pode representar a variavél aleatória para os valores 1, 2, 3 e 4.\n")
end
