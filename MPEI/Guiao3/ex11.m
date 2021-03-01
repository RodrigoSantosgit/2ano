N = 1e5;
experiencias = 2*randn(1,N)+14;

% alinea (a):

Pa = sum(experiencias > 12 & experiencias < 16)/N;
fprintf("P(classifica��o entre 12 e 16 valores) = %.4f\n", Pa);

% alinea (b):

Pb = sum(experiencias > 10 & experiencias < 18)/N;
fprintf("P(classifica��o entre 10 e 18 valores) = %.4f\n", Pb);

% alinea(c):

Pc = sum(experiencias > 10)/N;
fprintf("P(classifica��o maior que 10 valores) = %.4f\n", Pb);