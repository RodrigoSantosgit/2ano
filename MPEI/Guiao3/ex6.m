N = 1e3;                  % Número de experiências
n = 8000;                 % Número de experiencias de Bernoulli
p = 1/1000;
k = 7;

experience = rand(n, N);
faultyChips = sum(experience < p); 

numSuccesses = faultyChips == k;
probBinomSimul = sum(numSuccesses) / N;

lambda = n*p % µ = np na distribuição Binomial de Poisson

probPoisson = (lambda^k/factorial(k)) * exp(-lambda);

fprintf('Probabilidade de numa amostra de 8000 chips aparecerem 7 defeituosos: \nDistribuição binomial:\nTheoric: %f', probBinomTheor);
fprintf('\nSimulation: %f', probBinomSimul);
fprintf('\nDistribuição de Poisson: %f\n', probPoisson);