// CMPS390 
// alignMeMain.cpp

#include <stdio.h>

class myData0 {
	short int height;
	long int hairCount;
	long int numFreckles;
	short int weight;
};

class myData1 {
	short int height;
	short int weight;
	long int hairCount;
	long int numFreckles;
};

class myData2 {
	char bink[13];
	char twink[14];
	char fwink[16];
};


int main(void)
{
	char bink[13], twink[14], fwink[16];
	int j;

	printf("Hello TV Land \n");

	printf("size of myData0 in bytes = %d \n", sizeof(myData0));

	printf("size of myData1 in bytes = %d \n", sizeof(myData1));

	printf("size of myData2 in bytes = %d \n", sizeof(myData2));

	printf("\nsize of bink  = %d \n", sizeof(bink));
	printf("size of twink = %d \n", sizeof(twink));
	printf("size of fwink = %d \n\n", sizeof(fwink));

	for(j=48;j<48+10;j++) {
		printf("%d %c \n", j, j);
	}
	printf("\n");

	printf("Goodbye TV Land! \n");
}

/* OUTPUT
	Hello TV Land
	size of myData0 in bytes = 16
	size of myData1 in bytes = 12
	size of myData2 in bytes = 43
	
	size of bink  = 13
	size of twink = 14
	size of fwink = 16
	
	48 0
	49 1
	50 2
	51 3
	52 4
	53 5
	54 6
	55 7
	56 8
	57 9

	Goodbye TV Land!
*/
