% versão 1:

letras = ['a':'z' 'A':'Z'];
fatorDeCarga = 0.8;
m = round(1000/fatorDeCarga);

contador_valores = zeros(1,m);

for i=1 : 1000
    
    length = randi([3 20]);
    chave = '';
    for j=1 : length
        chave(j) = letras(ceil(rand()*52));
    end
    valor = mod(string2hash(chave), m) + 1;
    contador_valores(valor) = contador_valores(valor) + 1;
    
end

subplot(3,1,1)
bar(contador_valores)
grid on
title("Numero de chaves (Strings) mapeadas para cada posição")

subplot(3,1,2) 
hist(contador_valores, 0:10) 
grid on 
title("Histograma de Strings em cada posição")

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