tic, 
% Carrega o ficheiro dos dados dos filmes
udata=load('u.data'); 

% Fica apenas com as duas primeiras colunas
u= udata(1:end,1:2); clear udata;

% Lista de utilizadores
users = unique(u(:,1));                           % Extrai os IDs dos utilizadores
Nu= length(users);          % N�mero de utilizadores

% Constr�i a lista de filmes para cada utilizador
Set = cell(Nu,1);            % Usa c�ulas
for n = 1:Nu,                 % Para cada utilizador
    % Obt�m os filmes de cada um
    ind = find(u(:,1) == users(n));
    
    % E guarda num array. Usa c�lulas porque cada utilizador tem um n�mero
    % diferente de filmes. Se fossem iguais podia ser um array
    Set{n} = [Set{n} u(ind,2)];
end

% Calcula a dist�ncia de Jaccard entre todos os pares pela defini��o.
load J

% uncomment if J.mat does not exist
J = zeros(Nu);                   % array para guardar dist�ncias
h= waitbar(0,'Calculating');
for n1= 1: Nu,
    valueBar =  n1 / Nu;
    waitbar(valueBar,h, sprintf('Calculating...\n%.2f%% done.', valueBar * 100));
     
    for n2 = n1+1: Nu,
        % intersection 
        intersecao = length(intersect(Set{n1}, Set{n2}));
          
        % union
        uniao = length(Set{n1}) + length(Set{n2}) - intersecao;
        
        % Jaccard Distance
        J(n1, n2) = 1 - intersecao / uniao;
        
    end
end
delete (h)
save ('J', 'J')

% Com base na dist�ncia, determina pares com dist�ncia inferior a um limiar pr�-definido
threshold = 0.4;                          % limiar de decis�o

% Array para guardar pares similares (user1, user2, dist�ncia)
SimilarUsers= zeros(1,3);
k= 1;
for n1= 1:Nu,
    for n2= n1+1:Nu,
        if J(n1, n2) < 0.4
            SimilarUsers(k,:) = [users(n1) users(n2) J(n1,n2)];
            k= k+1;
        end
    end
end

numSimilarUsers = length(SimilarUsers);
fprintf('N�mero de pares de utilizadores com dist�ncias inferiores ao limiar %1.1f: %d\n', threshold, numSimilarUsers) 
fprintf('\nUser 1 ID\tUser 2 ID\tJaccard Distance\n')
for n = 1 : numSimilarUsers
    fprintf('%d\t%d\t%f\n', SimilarUsers(n, 1), SimilarUsers(n,2), SimilarUsers(n,3));
end
,toc