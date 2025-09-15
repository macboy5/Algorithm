#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
//#include <stdlib.h>
//#include <math.h>
//#include <time.h>


int main(void) {
	int n;
	scanf("%d", &n);
	int cup[3] = { 0 };
	cup[0] = 1, cup[1] = 2, cup[2] = 3;
	int a, b, temp1, temp2;
	for (int i = 1; i <= n; i++) {
		scanf("%d%d", &a, &b);
		for (int j = 0; j < 3; j++) {
			if (cup[j] == a)
				temp1 = j;
			if (cup[j] == b)
				temp2 = j;
		}
		cup[temp2] = a, cup[temp1] = b;
	}

	printf("%d", cup[0]);
	return 0;
	}
