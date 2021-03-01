% Passo 2 :

clear;
clc;

members = {'Espanha', 'Italia', 'Portugal', 'Jamaica', 'Reino Unido', 'Sri Lanka'};
test = {'Portugal', 'Polonia', 'França', 'Reino Unido'};

m = 100;        % Bloom filter size
k = 3;          % Number of hash 
B = init (m);

for i = 1: length(members)
    B = insert (B, k, members{i});
end

for i = 1: length(test)
    cont = contains(B, k, test{i});
    if (cont == 1)
           fprintf("%s -> pertence\n", test{i});
    else
           fprintf("%s -> não pertence\n", test{i});
    end
end