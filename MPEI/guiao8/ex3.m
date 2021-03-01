T = rand(20, 20);

% normalizar T:
for i=1:20
    T(:, i) = T(:, i) / sum(T(:, i));
end

I_0 = zeros(20,1);
I_0(1) = 1;

% 20 transiçoes:
trans_20 = T^20 * I_0;
fprintf('Probabilidade de tansitar entre 1º e ultimo estados em 20 transiçoes: %f\n', trans_20(20))

% 40 transiçoes:
trans_40 = T^40 * I_0;
fprintf('Probabilidade de tansitar entre 1º e ultimo estados em 40 transiçoes: %f\n', trans_40(20))

% 100 transiçoes:
trans_100 = T^100 * I_0;
fprintf('Probabilidade de tansitar entre 1º e ultimo estados em 100 transiçoes: %f\n', trans_100(20))