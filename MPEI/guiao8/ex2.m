% alinea (a):

T = [ 1/3    0.25    0;   ...
      1/3    0.55    1/2; ...
      1/3    0.20    1/2];
      
isEstocastica = sum(sum(T)) - size(T,1);
if isEstocastica == 0
  fprintf('É estocástica\n');
else
  fprintf('Não é estocástica\n');
end

% alinea (b):

I_0 = [1/2; 1/4; 1/4];

% alinea (c):

distribuicao_final = T^30 * I_0;
fprintf('Numero de estudantes no grupo A: %d\n', round(90*distribuicao_final(1)))
fprintf('Numero de estudantes no grupo B: %d\n', round(90*distribuicao_final(2)))
fprintf('Numero de estudantes no grupo C: %d\n', round(90*distribuicao_final(3)))

% alinea (d):

I_0 = [1/3; 1/3; 1/3];

distribuicao_final = T^30 * I_0;

fprintf('\nNumero de estudantes no grupo A: %d\n', round(90*distribuicao_final(1)))
fprintf('Numero de estudantes no grupo B: %d\n', round(90*distribuicao_final(2)))
fprintf('Numero de estudantes no grupo C: %d\n', round(90*distribuicao_final(3)))