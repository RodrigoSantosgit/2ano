% alinea (a):

T = [0.7 0.8; 
     0.3 0.2];
I_0 = [1; 0];
probabilidades_prox_semana= T^2 * I_0;
fprintf('P = %d', probabilidades_prox_semana(1));

% alinea (b):

I_0 = [0; 1];
probabilidades_prox_semana = T^2 * I_0;
fprintf('\nP = %d', probabilidades_prox_semana(1));

% alinea (c):

I_0 = [1; 0];
probabilidades_ultima_semana = T^29 * I_0;
fprintf('\nP = %d\n', probabilidades_ultima_semana(1));

% alinea (d):

I_0 = [0.85; 0.15];
prob_present = zeros(30,1);
prob_not_present = zeros(30,1);

for i=1:30
    ith_week_probabilities = T^(i-1) * I_0;
    prob_present(i) = ith_week_probabilities(1);
    prob_not_present(i) = ith_week_probabilities(2);
end

figure; 
hold on;
p1 = plot(prob_present);
p2 = plot(prob_not_present);
grid on
axis([0 30 0 1])
xlabel('Numero de aulas')
ylabel('Probabilidade de não ir a aula')
