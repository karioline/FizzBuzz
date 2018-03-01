//Kari Shelton
//CMPS 390
//ArrayPointer.c
//Programming Assignment 1 : C Arrays and Pointers


#include <stdio.h>

/*
//a: array pointer, m: # of rows, n: # of columns
void printMatrixRowMajor(int *a, int m, int n){
	int r, c;
	int *ptr;
	ptr = a;
	for(r = 0; r < m; r++){
		for(c = 0; c < n; c++){
			printf("%d ", *ptr);
			ptr++;
		}
		printf("\n");
	}
}//end RowMajor 

void printMatrixColMajor(int *a, int m, int n){
	int r, c;
	for(c = 0; c < n; c++){
		for(r = 0; r < m; r++){
			printf("%d ", *(a + (r * 4) + c));
		}
		printf("\n");
	}
}//end ColMajor

main(){

	//create array and fill using looping
	int row, col;
	int x[3][4], *xptr;
	int j = 0;
	
	for(row = 0; row < 3; row++){
		for(col = 0; col < 4; col++){
			x[row][col] = j;
			j++;
		}
	}
	
	//call method to print row major 
	printf("Matrix row major fashion: \n");
	xptr = &(x[0][0]);
	printMatrixRowMajor(xptr, 3, 4);
	
	printf("\n");
	
	//cal method to print column major
	printf("Matrix column major fashion: \n");
	xptr = &(x[0][0]);
	printMatrixColMajor(xptr, 3, 4);
	
}//end Main
*/


// a: array pointer, m: # of rows, n: # of columns
void printMatrixRowMajor(int *a, int m, int n) {
	int row, col;
	int *ptr;
	printf("\nMatrix row major fashion: \n");
	ptr = a;
	for(row=0; row<m;row++){
		for(col=0; col<n;col++){
			printf("%d", *ptr);
			ptr++;
		}
		printf("\n");
	}
}
// a: array pointer, m: # of rows, n: # of columns
void printMatrixColMajor(int *a, int m, int n) {
	int row, col;
	int *ptr;
	printf("\nMatrix column major fashion: \n");
	ptr = a;
	for(col=0; col<n;col++){
		for(row=0; row<m;row++){
			ptr = a + (row*n) + col;
			printf("%d", *ptr);
			ptr++;
		}
		printf("\n");
	}
}
main() {
	int m= 3, n = 4;
	int a[m][n];
	int row, col;
	for(row = 0; row < m; row++){
		for(col = 0; col < n;col++){
			a[row][col] = row * n + col;
		}
	}
	printMatrixRowMajor(&a[0][0], m, n);
	printMatrixColMajor(&a[0][0], m, n);
}
/* OUTPUT
Matrix row major fashion:
0 1 2 3
4 5 6 7
8 9 10 11
Matrix column major fashion:
0 4 8
1 5 9
2 6 10
3	
*/
