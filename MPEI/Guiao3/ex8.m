x = [1:4]; % valores que a variav�l aleatoria assume

fx = (x+5)./30; % fun��o f(x) para os valores da vari�vel aleat�ria

if (min(fx) >= 0 && max(fx) <= 1 && sum(fx) == 1)
    fprintf("A fun��o f(x) = (x + 5)/30 pode representar a variav�l aleat�ria para os valores 1, 2, 3 e 4.\n")
else 
    fprintf("A fun��o f(x) = (x + 5)/30 n�o pode representar a variav�l aleat�ria para os valores 1, 2, 3 e 4.\n")
end
