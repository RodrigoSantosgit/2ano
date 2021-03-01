% alinea (a):

p = 0.4;
q = 0.6;
T = [   p.^2, 0, 0, q.^2;       ...
    (1-p).^2, 0, 0, q.*(1-q);   ...
    p.*(1-p), 0, 0, q.*(1-q);   ...
    p.*(1-p), 1, 1, (1-q).^2];

% alinea (b):

I_0 = [1; 0; 0; 0];

trans_10 = T^10 * I_0;

fprintf('Probabilidade estar no estado A depois de 10 transiçoes: %f\n', trans_10(1))
fprintf('Probabilidade estar no estado B depois de 10 transiçoes: %f\n', trans_10(2))
fprintf('Probabilidade estar no estado C depois de 10 transiçoes: %f\n', trans_10(3))
fprintf('Probabilidade estar no estado D depois de 10 transiçoes: %f\n', trans_10(4))