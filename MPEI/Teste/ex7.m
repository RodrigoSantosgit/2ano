T = [ 0.8   0.1   0.05;
      0.2   0.6   0.20; 
      0.0   0.3   0.75];
  
x = T^3 * [100;200;30];

fprintf('(a) Ana: $%4.2f\n', x(1));
fprintf('(a) Bernardo: $%4.2f\n', x(2));
fprintf('(a) Catarina: $%4.2f\n\n', x(3));

%alinea b)
xb = T^365 * [100;200;30];
fprintf('(b) Ana: $%4.2f\n', xb(1));
fprintf('(b) Bernardo: $%4.2f\n', xb(2));
fprintf('(b) Catarina: $%4.2f\n\n', xb(3));

%alinea C)
i = 1;
xc = T * [100;200;30];
while(1) 
    i = i + 1;
    xc = T * xc;
    
    if(xc(3) > 130)
        break;
    end
end
i
fprintf('1 de janeiro de 2016 + %d dias é 10 de janeiro de 2016. o dia em que vai ter 130 euros',i)
