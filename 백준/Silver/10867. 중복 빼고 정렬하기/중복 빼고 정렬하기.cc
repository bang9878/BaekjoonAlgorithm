#include <stdio.h>
int main()
{
    int n,input;
    int numbers[2001]={0,};
    scanf("%d",&n);
    for(int i=0; i<n; i++){
        scanf("%d",&input);
        input+=1000;
        numbers[input]++;
    }
    for(int i=0; i<2001; i++){
        if(numbers[i]!=0)printf("%d ",i-1000);
    }
}