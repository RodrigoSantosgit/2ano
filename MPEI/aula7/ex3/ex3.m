Set = LoadInfo('u.data');
setSize = length(Set);

% Get minhashs
kMax = 15;
h = zeros(kMax, setSize);
minHash = zeros(kMax);

% para todas as funçoes de hash
for k = 1: kMax
    % para todos os membros do set
    for n = 1: setSize
        key = strcat(Set(n), num2str(k));
        h(k, n) = rem (string2hash(key), m) + 1;
    end
    % min hash
    minHash(k) = min(h(k,:));
end

% Estimate Jaccard Similarity
for k = 1: kMax
        differentValues = differentValues + length(unique(h(k:k+1,:)));
end
jaccardSimilarity = differentValues / kMax