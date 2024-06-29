#include <stdio.h>
int main()
{
    int C[2000001]={0,};
    int N[100]={0,};
    int n,t,cnt=0;
    int i,j;
    scanf("%d %d",&n,&t);
    for(i=0; i<n; i++){
        scanf("%d",&N[i]);
    }
    for(i=0; i<n; i++){
        for(j=N[i]; j<=t; j+=N[i]){
            C[j]++;
        }
    }
    for(i=0; i<=t; i++){
        if(C[i]!=0)cnt++;
    }
    printf("%d",cnt);

}