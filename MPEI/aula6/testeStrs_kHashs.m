function falsoPositivos= testeStrs_kHashs (bloomFilterSize, lengthTest, k, numStrings, strLength, alphabet, distLetters)

B = init(bloomFilterSize);

for i = 1 : numStrings
    string = generateString (strLength, 0, alfabeto, distLetters);
    B = insert (B, k, string);
end 

falsoPositivos=0;

for i = 1 : lengthTest
  
    string = generateString(strLength, 0, alfabeto, distLetters);
    r = verify (B, k, string);
    
    if r == 1
        falsoPositivos = falsoPositivos+1;
    end
    
end 