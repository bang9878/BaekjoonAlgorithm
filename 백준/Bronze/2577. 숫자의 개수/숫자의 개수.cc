#include <stdio.h>
int main()
{
    int a,b,c,res,i,namuji=0;
    int arr[10]={0,};
    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);
    res=a*b*c;
    while(res!=0){
        namuji=res%10;
        res/=10;
        arr[namuji]++;
    }
    for(i=0; i<10; i++){
        printf("%d\n",arr[i]);
    }
}