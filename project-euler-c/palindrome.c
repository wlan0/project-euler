#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int reverse (int i) {
	int ret = 0;
	while(i != 0) {
		ret = ret * 10;
		ret = ret + (i%10);
		i = i/10; 
	}
	return ret;
}

int isMultiple (char *num) {
	int i = 999;
	int numd = atoi(num);
	while(i>99) {
		if(numd%i == 0) {
			char temp[7];
			sprintf(temp, "%d", numd/i);
			if (strlen(temp) == 3) {
				return 1;
			}
		}
		i--;
	}
	return 0;
}

int main () {
	int i = 999;
	while(i > 99) {
		int rev = reverse(i);
		char *num = malloc(7);
		if(rev < 10) { 
			sprintf(num, "%d00%d",i,reverse(i));
		} else if (rev < 100) {
			sprintf(num, "%d0%d",i,reverse(i));
		} else {
			sprintf(num, "%d%d",i,reverse(i));	
		}
		if(isMultiple(num)) {
			printf("%s", num);
			return 0;
		}
		i--;
	}
	return 0;
}
