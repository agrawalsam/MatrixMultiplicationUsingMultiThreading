package multiThreading;

import java.util.*;

class matrix extends Thread{
	static int arr[][], arr1[][];
	static int m1n=0, m1m=0, m2n=0,m2m=0;
	int temp1,temp2;
	int total=0;
	matrix(){}
	matrix(int row, int column){
		temp1 = row; temp2 = column;
	}
	void setMatOne(int n, int m, int arr[][]) {
		matrix.arr = new int[n][m];
		matrix.arr = arr;
		m1n=n;m1m=m;
	}
	void setMatTwo(int n1, int m1, int arr1[][]) {
		matrix.arr1 = new int[n1][m1];
		matrix.arr1 = arr1;
		m2n=n1;m2m=m1;
	}
	public void run() {
		if(m1m == m2n) {
			for(int j=0;j<m1m;j++) {
				total+=arr[temp1][j] * arr1[j][temp2];
			}
			System.out.println("Output of position "+temp1+" and position "+temp2 +" = "+total);
		}
		else {
			System.out.println("Matrices cannot be multiplied .");
		}
	}
}
public class matrixMultiThread {
	public static void main(String	 args[]) {
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter the number of rows of matrix1");
		int n = in.nextInt();
		System.out.println("Enter the number of columns of matrix1");
		int m = in.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = in.nextInt();
			}
		}
		System.out.println("Enter the number of rows of matrix2");
		int n1 = in.nextInt();
		System.out.println("Enter the number of columns of matrix2");
		int m1 = in.nextInt();
		int arr1[][] = new int[n1][m1];
		for(int i=0;i<n1;i++) {
			for(int j=0;j<m1;j++) {
				arr1[i][j] = in.nextInt();
			}
		}
		in.close();
		matrix ma = new matrix();
		ma.setMatOne(n, m, arr);
		ma.setMatTwo(n1, m1, arr1);
		matrix ma1[][] = new matrix[n][m1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m1;j++) {
				ma1[i][j] = new matrix(i,j);
				ma1[i][j].start();
			}
		}
	}
}