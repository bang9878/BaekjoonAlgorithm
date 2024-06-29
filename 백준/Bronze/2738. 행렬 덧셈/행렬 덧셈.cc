#include <stdio.h>
int main()
{
    int Matrix_A[100][100];
    int Matrix_B[100][100];
    int Matrix_sum[100][100];
    int i,j,n,m;
    scanf("%d %d",&n,&m);
    for(i=0; i<n; i++){
        for(j=0; j<m; j++){
            scanf("%d",&Matrix_A[i][j]);
        }
    }
    for(i=0; i<n; i++){
        for(j=0; j<m; j++){
            scanf("%d",&Matrix_B[i][j]);
        }
    }
    for(i=0; i<n; i++){
        for(j=0; j<m; j++){
            Matrix_sum[i][j]=Matrix_A[i][j]+Matrix_B[i][j];
        }
    }
    for(i=0; i<n; i++){
        for(j=0; j<m; j++){
            printf("%d ",Matrix_sum[i][j]);
        }
        printf("\n");
    }

}