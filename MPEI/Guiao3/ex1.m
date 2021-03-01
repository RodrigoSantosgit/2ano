% alinea (a):

x = 1:6;
px = ones(1,6)/6;
subplot(1,2,1)
stem(x,px)
axis([0,7,0,0.20]);
xlabel('x');
ylabel('P_x(x)')
title('Funcao Massa de Probabilidade da variavel aleatoria X')
grid on

%alinea (b):

FX = cumsum([0,px,0]);
subplot(1,2,2)
stairs(0:7,FX);
axis([0,7,0,1.1]);
xlabel('x');
ylabel('F_x(x)');
title('Funcao Distribuicao Acumulada da variavel aleatoria X')
grid on