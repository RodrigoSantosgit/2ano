% versão 2 e 3:

letras = ['A':'Z' 'a':'z' 'À', 'Á', 'Â', 'Ã', 'Ç', 'É', 'Ê', 'Í', 'Ó', 'Ô', 'Õ', 'Ú', 'à', 'á', 'â', 'ã', 'ç', 'é', 'ê', 'í', 'ó', 'ô','õ', 'ú'];

n=1000;
fatorDeCarga = 0.8;
m = round(n/fatorDeCarga);

contador_valores = zeros(1,m);

for i=1 : 1000
    
    length = randi([5 10]);
    chave = '';
    for j=1 : length
        chave(j) = letras(ceil(rand()*76));
    end
    valor = mod(string2hash(chave), m) + 1;
    contador_valores(valor) = contador_valores(valor) + 1;
    
    if rem (i, 25) == 0
        subplot(3,1,1)
        bar(contador_valores)
        grid on
        title("Numero de Strings mapeadas para cada posição:");
        
        subplot(3,1,2)
        hist(contador_valores, 0:9)
        grid on
        title("Histograma de Strings em cada posição:")
    end
end

x = [0:9];
subplot(3,1,3)
successes = histc(contador_valores, x);
fmpX = successes / m;
stem(x, fmpX);
grid on
title('Variavel Aleatoria X FMP');
axis([-0.5, 9.5, 0, 0.5]);

e_x = sum(x.*fmpX);
fprintf('E[X] = %f\n', e_x);
e_x2 = sum((x.^2).*fmpX);
fprintf('Var(X) = %f\n', e_x2 - e_x^2);