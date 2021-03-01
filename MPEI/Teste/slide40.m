T = [0 1/2 0 0;
     1/3 0 0 1/2;
     1/3 0 1 1/2;
     1/3 1/2 0 0];

x_0 = [1/4; 1/4; 1/4; 1/4];

for i=1:5
  x_i = T^i * x_0;
  fprintf('transição %d\n',i);
  fprintf('x_0(1): %f\n', x_i(1));
  fprintf('x_0(2): %f\n', x_i(2));
  fprintf('x_0(3): %f\n', x_i(3));
  fprintf('x_0(4): %f\n', x_i(4));
end
