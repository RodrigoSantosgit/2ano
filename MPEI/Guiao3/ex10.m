% alinea (a):

N = 1e4;
X = 0 + rand(1, N)*(10-0);

pA = 3/10;

successesA = sum(X < 3);
probA = successesA / N;

fprintf('pA : X < 3 \nTheoric: %f\nSimulation: %f\n', pA, probA);

% alinea (b):

pB = (10-7)/10;

successesB = sum(X > 7);
probB = successesB / N;

fprintf('\npB: X > 7 \nTheoric: %f\nSimulation: %f\n', pB, probB);

% alinea (c):

pC = (6-1)/10;

successesC = sum(X > 1 & X < 6);
probC = successesC / N;

fprintf('\npC: 1 < X < 6\nTheoric: %f\nSimulation: %f\n', pC, probC);








