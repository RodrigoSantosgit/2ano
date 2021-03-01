% alinea (a):

T = [0.84 0.1 0 0.5;
     0.1 0.7 0 0.1;
     0.05 0.1 0.8 0.1;
     0.01 0.1 0.2 0.3];

I_0 = [1;2;10;5];  
   
T_angola = (T^8 * I_0)(1);
T_brasil = (T^8 * I_0)(2);
T_chile = (T^8 * I_0)(3);
T_dinamarca = (T^8 * I_0)(4);

fprintf('p_A: %f\n',T_angola);
fprintf('p_B: %f\n',T_brasil);
fprintf('p_C: %f\n',T_chile);
fprintf('p_D: %f\n',T_dinamarca);

% alinea (c):

n = 2;
while T_dinamarca > 2
  n = n+1;
  T_dinamarca = (T^n * I_0)(4);
end

meses = {'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', ...
            'Agosto', 'Setembro', 'Outobro', 'Novembro', 'Dezembro'};
mes = meses{n};
fprintf('1 de %s 2014\n',mes);

% alinea (b):

t_prev = T^0*I_0;

for i=1:4
  for j=1:12
    if t_prev(i) <= T^j * I_0(i)
      t_prev(i) = T^j * I_0(i);
    end
  end
end

fprintf('Angola: %f\n', t_prev(1));
fprintf('Brasil: %f\n', t_prev(2));
fprintf('Chile: %f\n', t_prev(3));
fprintf('Dinamarca: %f\n', t_prev(4));