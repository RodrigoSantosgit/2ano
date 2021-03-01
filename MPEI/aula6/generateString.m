function [ str ] = generateString (averageValue, variance, letters, distLettersPT)
length = averageValue + (sqrt(variance)* randn());         % tamanho das chaves segue uma distribuicao normal (com media 10 e variancia 5)
str = '';   
for i=1:  length
    letterIndex = find(distLettersPT > rand());
    str(i) = letters(letterIndex(1));
end

end