#include <stdio.h>
int main()
{
    int n,num;
    scanf("%d",&n);
    while(1){
        scanf("%d",&num);
        if(num==0)break;
        if(num%n==0)printf("%d is a multiple of %d.\n",num,n);
        else if(num%n!=0)printf("%d is NOT a multiple of %d.\n",num,n);
    }
}