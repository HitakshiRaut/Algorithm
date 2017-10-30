#include<stdio.h>

void bruteForceMaximumSubArray(int *a,int n, int *left, int *right, int *maxSum);

void bruteForceMaximumSubArray(int *a,int n, int *left, int *right, int *maxSum)
{
	int i,j,currSum;

	*left=1;
	*right=1;
	*maxSum=a[1];
	
	for(i=0;i<n;i++)
	{
		currSum=0;
		for(j=i;j<n;j++)
		{
			currSum+=a[j];
			if(currSum> *maxSum)
			{
				*left=i;
				*right=j;
				*maxSum=currSum;
			}
		}
	}
}
int main()
{
	int n,i,left,right,maxSum;
	printf("Number of values in the array : ");
	scanf("%d",&n);
	int a[n];
	printf("PLease enter array elements : ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	bruteForceMaximumSubArray(a,n,&left,&right,&maxSum);

	printf("Maximum Sub array:\n");
	printf("Maximum Sum :%d\n",maxSum);
	printf("\nStart Index :%d, End Index :%d\n",left,right);
	printf("Array Elements :\n");
	for(i=left;i<=right;i++)
		printf("%d\t",a[i]);
}
		
