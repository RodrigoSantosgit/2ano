package MPEI_Proj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimilarityFinder {

    private int numHash;
    private int[][] signatures;
    private Map<String, boolean[]> bitMap;
    
    public SimilarityFinder(int numHash){
        this.numHash = numHash;
    }
 
    public int getNumHash() {
		return numHash;
	}
    
    @Override
	public String toString() {
		return "SimilarityFinder [número de Funções de Hash = " + numHash + "]";
	}

	public double getSimilarity(Set<String> base, Set<String> setToVerify){
		initializeSignatures();
        initializeBitMap(base, setToVerify);
        
        getMinHash(0);
        getMinHash(1);
        
        return getSimilarity();
    }

	private void initializeBitMap(Set<String> base, Set<String> setToVerify){
        bitMap = new HashMap<String, boolean[]>();
        for (String elem : base){ // colocar no bitMap elementos do set base
            bitMap.put(elem, new boolean[] { true, false });
        }
        for (String elem : setToVerify){ // colocar no bitMap elementos do set setToVerify
            if (bitMap.containsKey(elem)){ // elemento pertcence ao set base
                bitMap.put(elem, new boolean[] { true, true });
            }
            else if (!bitMap.containsKey(elem)){ // elemento não pertence ao base
                bitMap.put(elem, new boolean[] { false, true });
            }
        }
    }
	
    private void initializeSignatures(){ // inicializa valores de minHash com o valor Maximo para que possa ser reduzido
        signatures = new int[2][numHash];
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < numHash; j++){
                signatures[i][j] = Integer.MAX_VALUE;
            }
        }
    }
 
    private double getSimilarity(){ // verifica numero de minHashes iguais entre os sets e calcula similaridade
        int equalSignatures = 0;
        for (int i = 0; i < numHash; i++){
            if (signatures[0][i] == signatures[1][i]){
                equalSignatures++;
            }
        }
        return (double)(equalSignatures)/(double)(numHash);
    }
    
    private void getMinHash(int setIndex){
        int index = 0;
        for (String element : bitMap.keySet()){ // para todos os Shingles (especificações no caso do testeGlobal)
            for (int i = 0; i < numHash; i++){ // para todas as funçoes de hash
                if(bitMap.get(element)[setIndex]){ // se essa especificação pertencer ao set
                	int hashValue = hashCode((String)element + i);
                    if (hashValue < signatures[setIndex][index]){  // alterar o valor minHash se este for menor que o atual
                        signatures[setIndex][i] = hashValue;
                    }
                }
            }
            index++;
        }
    }
 
    private int hashCode(String s) { // Universal Hashing
		int h = 5381;
		for (int i=0 ; i < s.length() ; ++i)
			h = ((h*33) + s.charAt(i)) % 8760;
		return h;
	}
}