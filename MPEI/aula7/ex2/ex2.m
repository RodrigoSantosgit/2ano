Set = LoadInfo('u.data');
J = getJaccardDistance(Set);
SimilarPairs = getSimilarPairs(Set, J, 0.4);