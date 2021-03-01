% passo3:

% alinea a:

m = 1000;
strLength = 40;
n = 8000;
k = 3;

% alinea b:

lengthTest = 10000;


alfabeto = ['A':'Z' 'a':'z' '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];  
ficheiros = {'pg21209.txt','pg21209.txt'};
pmfPT =pmfLetrasPT(ficheiros, alfabeto);
distPT = cumsum(pmfPT);

% Calcular probabilidade de falsos positivos para k = 3;
falsoPositivos = testeStrs_kHashs(n, lengthTest, k, m, strLength, alfabeto, distPT);
fprintf('Number of hash functions:%d\nProbability of false positives = %.4f\n',
 k, falsoPositivos/lengthTest);
