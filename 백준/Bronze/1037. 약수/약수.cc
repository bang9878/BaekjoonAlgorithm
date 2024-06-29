#include <stdio.h>
int main()
{
    int num,i,max=0,min=1000001;
    int measure[50]={0,};
    scanf("%d",&num);
    for(i=0; i<num; i++){
        scanf("%d",&measure[i]);
    }
    for(i=0; measure[i]!=0; i++){
        if(max<measure[i])max=measure[i];
        if(min>measure[i])min=measure[i];
    }
    printf("%d",min*max);
}