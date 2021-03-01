function [ valor ] = count ( B, k, word )
    m = length(B);
    
    valores = zeros(1, k);
    wordToHash=word;
    
    for j= 1: k
        wordToHash = [wordToHash num2str(j)];               
        h = rem (string2hash(wordToHash), m) + 1;
        valores(j) = B(h);
    end
 
    valor = min(valores);
end