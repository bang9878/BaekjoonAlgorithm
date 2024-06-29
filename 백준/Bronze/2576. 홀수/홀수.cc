#include <stdio.h>
int main()
{
    int digit[8],sum=0,min=100;
    int i,cnt=0;
    for(i=0; i<7; i++){
        scanf("%d",&digit[i]);
        if(digit[i]%2==0)cnt++;
        if(cnt==7){
            printf("-1");
            return 0;
        }
    }
    for(i=0; i<7; i++){
        if(digit[i]%2!=0){
            sum+=digit[i];
            if(digit[i]<min){
                min=digit[i];
            }
        }
    }
    printf("%d %d",sum,min);
}