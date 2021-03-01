N = 1e3;                  % N�mero de experi�ncias
n = 8000;                 % N�mero de experiencias de Bernoulli
p = 1/1000;
k = 7;

experience = rand(n, N);
faultyChips = sum(experience < p); 

numSuccesses = faultyChips == k;
probBinomSimul = sum(numSuccesses) / N;

lambda = n*p % � = np na distribui��o Binomial de Poisson

probPoisson = (lambda^k/factorial(k)) * exp(-lambda);

fprintf('Probabilidade de numa amostra de 8000 chips aparecerem 7 defeituosos: \nDistribui��o binomial:\nTheoric: %f', probBinomTheor);
fprintf('\nSimulation: %f', probBinomSimul);
fprintf('\nDistribui��o de Poisson: %f\n', probPoisson);