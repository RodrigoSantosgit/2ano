% alinea (a):

dinheiroInicial = [100; 200; 30];

T = [ 0.8   0.1   0.05; ...
      0.2   0.6   0.20; ...
      0.0   0.3   0.75];
  
dinheiro3Trans = T^3 * dinheiroInicial;

fprintf('Ana: $%4.2f\n', dinheiro3Trans(1));
fprintf('Bernardo: $%4.2f\n', dinheiro3Trans(2));
fprintf('Catarina: $%4.2f\n\n', dinheiro3Trans(3));

% alinea (b):

dinheiro365Trans = T^365 * dinheiroInicial;

fprintf('Ana: $%4.2f\n', dinheiro365Trans(1));
fprintf('Bernardo: $%4.2f\n', dinheiro365Trans(2));
fprintf('Catarina: $%4.2f\n\n', dinheiro365Trans(3));

% alinea (c):

n = 1;
dinheiroNTrans = T * dinheiroInicial;
while(true) 
    n = n + 1;
    dinheiroNTrans = T * dinheiroNTrans;
    
    if(dinheiroNTrans(3) > 130)
        break;
    end
end

meses = {'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', ...
            'Agosto', 'Setembro', 'Outobro', 'Novembro', 'Dezembro'};
 
diasMes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

diasAno = cumsum(diasMes);

mesInd = find((n+1) < diasAno, 1);
mes = meses{mesInd};

if (mesInd > 1)
    dia = (n+1) - diasAno(mesInd - 1);
else
    dia = (n+1);
end

fprintf('Na data: %d de %s.\n', dia, mes);