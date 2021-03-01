% ex1:

% (a)
T = [ 0.9 0.5 0.5;
     0.09 0.4 0.4;
     0.01 0.1 0.1];
     
v = [0; 0; 1];

% (b)
P0 = (T^4 * v)(1);
P1 = (T^4 * v)(2);
P2 = (T^4 * v)(3);

fprintf('Probabilidade 0 erros: %f\n' , P0);
fprintf('Probabilidade 1 erros: %f\n' , P1);
fprintf('Probabilidade 2 ou mais erros: %f\n' , P2);

% (c)
T_p = T;
prev_T = zeros(3,3);

while sum(abs(T_p - prev_T)) > 0.001
  prev_T = T_p;
  T_p = T_p * T;
end

fprintf('Probabilidade perda de pacote: %f\n', (T_p*v)(3));
fprintf('Probabilidade perda de pacote sem corretor: %f\n', (T_p*v)(2) + (T_p*v)(3));
fprintf('Probabilidade não perda de pacote: %f\n', (T_p*v)(1));