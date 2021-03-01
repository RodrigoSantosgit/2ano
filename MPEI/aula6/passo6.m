% passo 6:

clc; clear all;

fileName = 'pg17186.txt';
wordsFile = readFile (fileName);

n =  length(wordsFile);                           
m = n * 15;                                       
k = round ((m / n) * log(2));                   
bloomFilter = init (m);

fprintf('\nA criar Bloom Filter para o ficheiro %s...\n', fileName);
bar = waitbar(0,'A criar Bloom Filter...');            
for i = 1: n
    bloomFilter = insert (bloomFilter, k, wordsFile{i});
    valueBar =  i / n;
    waitbar(valueBar, bar, sprintf('A criar Bloom Filter para o ficheiro %s...\n%.2f%% done.', fileName, valueBar * 100))
end
waitbar(1, bar, sprintf('\nConcluido!'))
delete(bar)

fprintf('Numero de ocorrencias de palavras: \n');
wordsFile = sort(unique(wordsFile));
n = length(wordsFile);
values = zeros(1, n);

for i = 1: n
    word = wordsFile{i};
    values(i) = count(bloomFilter, k, word);
    fprintf('\t%s -> %d\n', word, values(i));
end

[maxValue, maxIndex] = max(values);
fprintf('\nPalavra mais frequent: %s (%d times)\n', wordsFile{maxIndex}, maxValue);