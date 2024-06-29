#include <stdio.h>
int main()
{
    int i,j;
    int n;
    scanf("%d",&n);
    for(i=1; i<=n; i++){
        for(int j=i; j<n; j++)
            printf(" ");
        for(int k=0; k<i; k++)
            printf("*");
        printf("\n");
    }
}