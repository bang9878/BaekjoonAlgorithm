#include <stdio.h>
int main()
{
    int sum=0,mode=0,mode_idx=0;
    int n,i,avg;
    int num[101]={0,};
    for(i=0; i<10; i++){
        scanf("%d",&n);
        sum+=n;
        num[n/10]++;
    }
    avg=sum/10;
    for(i=0; i<101; i++){
        if(mode<num[i]){
            mode=num[i];
            mode_idx=i;
        }
    }
    printf("%d\n",avg);
    printf("%d\n",mode_idx*10);
}