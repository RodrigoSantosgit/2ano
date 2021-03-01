% alinea (a):

T = [ 0.7   0.2   0.3; ...
      0.2   0.3   0.3; ...
      0.1   0.5   0.4];
      
% alinea (b):

I_0 = [1; 0; 0];

dia2 = T^2 * I_0;

fprintf('Probabilidade de chuva no dia 2: %f\n', dia2(3));

% alinea (c):

n = 20;
T_p = T;

valores = zeros(9, n);
valores(:,1) = T_p(:);

for i=2:n
    T_p = T_p * T;
    valores(:,i) = T_p(:);
end

figure;
plot(valores)

% alinea (d):

T_p = T;
prev_T = zeros(3,3);

valores = zeros(9, 1);
valores(:,1) = T_p(:);

limiar = 10^(-4);

for i=2:n
    
    if (sum(abs(T_p - prev_T)) <= limiar) 
        break;
    end
    
    prev_T = T_p;
    T_p = T_p * T;
    valores(:,i) = T_p(:);
end

figure;
plot(valores)

fprintf('Numero de iteraçoes ate diferença <= 10^(-4): %d\n', size(valores, 2));
