m = 1000;
strLength = 40;
n = 8000;
lengthTest = 10000;

kMax = 15;

alfabeto = ['A':'Z' 'a':'z' '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];
ficheiros = {'pg21209.txt','pg26017.txt'};
pmfPT=pmfLetrasPT(ficheiros, alfabeto);
distPT = cumsum(pmfPT);

teoricoFalsoPositivosFalsoPositivos = zeros (1, kMax);
falseoPositivos = zeros(1, kMax);

fprintf('\nNumber of hash functions:');
for k = 1: kMax
    falsoPositivos(k) = testStrs_kHashs(n, lengthTest, k, m, strLength, alphabet, distPT);
    teoricoFalsoPositivos(:, k) = (1 - exp(-k*m/n))^k;
    fprintf('\n%d :  Probability of false positives = %.4f\n', k, falsoPositivos(k)/lengthTest);
   
    figure(1);
    hold on
    
    plot(1:k, falsoPositivos(1:k)/lengthTest, 'r');
    xlabel('Number of hash functions');
    ylabel('Probability of false positives');
    drawnow;
    
    plot(1:k, teoricoFalsoPositivos(1:k), 'b');
    drawnow;
    
    hold off
    
    legend('Simulation values', 'Theoric Values')
end