% ex2:

% (a):
N = 5;
B = 0.8;
NN = [1/N  1/N  1/N  1/N  1/N;
      1/N  1/N  1/N  1/N  1/N;
      1/N  1/N  1/N  1/N  1/N;
      1/N  1/N  1/N  1/N  1/N;
      1/N  1/N  1/N  1/N  1/N];
      
H = [0   1/2   1/3   1/4   0;
     1/2   0    0    1/4   1/2;
     1/2 1/2   1/3   1/4   0;
     0    0     0     0    1/2;
     0    0    1/3   1/4   0];
     
A = B*H + (1-B)*NN;

% (b):

I_0 = [1/N;1/N;1/N;1/N;1/N];

P_C = (A^10*I_0)(1);
P_D = (A^10*I_0)(1);
P_E = (A^10*I_0)(1);
P_F = (A^10*I_0)(1);
P_G = (A^10*I_0)(1);

fprintf('p_c: %f\n',P_C);
fprintf('p_d: %f\n',P_D);
fprintf('p_e: %f\n',P_E);
fprintf('p_f: %f\n',P_F);
fprintf('p_g: %f\n',P_G);