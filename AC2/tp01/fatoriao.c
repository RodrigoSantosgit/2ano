#include <stdio.h>

int main(void) {	
	
	int divisions = 0;
	int multiplications = 0;
	int factorials[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
	printf("Factorion numbers smaller than 10^6:\n");
	
	for (int num = 0; num < 1000000; num++) {
		
		int a = num / 100000; int b = num / 10000 % 10; int c = num / 1000 % 10;
		int d = num / 100 % 10;  int e = num / 10 % 10;  int f = num % 10;
		divisions += 10;

		
		int fact_sum;
		if (a != 0) {
			fact_sum = factorials[a] + factorials[b] + factorials[c] + factorials[d] + factorials[e] + factorials[f];
		} else if (b != 0) {
			fact_sum = factorials[b] + factorials[c] + factorials[d] + factorials[e] + factorials[f];
		} else if (c != 0) {
			fact_sum = factorials[c] + factorials[d] + factorials[e] + factorials[f];
		} else if (d != 0) {
			fact_sum = factorials[d] + factorials[e] + factorials[f];
		} else if (e != 0) {
			fact_sum = factorials[e] + factorials[f];
		} else {
			fact_sum = factorials[f];
		}

		if (num == fact_sum) {
			printf("%d | ", num);
		}
	}
	printf("\n\n");

	printf("Numero de divisõess: %d\n", divisions);
	printf("Numero de multiplicações: %d\n", multiplications);

	return 0;
}
