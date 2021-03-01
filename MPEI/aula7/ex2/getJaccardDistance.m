function [ J ] = getJaccardDistance( Set )
%Calcular as distâncias de Jaccard entre os elementos do conjunto 
setSize = length(Set);

J = zeros(setSize);    % array para guardar distâncias entre elementos
h= waitbar(0,'Calculating');

for n1= 1: setSize,
    valueBar =  n1 / setSize;
    waitbar(valueBar,h, sprintf('Calculating\n%.2f%%.', valueBar * 100));
    
    for n2 = n1+1: setSize,
        intersecao = length(intersect(Set{n1}, Set{n2}));
        
        uniao = length(Set{n1}) + length(Set{n2}) - intersecao;
        
        J(n1, n2) = 1 - intersecao / uniao;
        
    end
end
delete (h)

end