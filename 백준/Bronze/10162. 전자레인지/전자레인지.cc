#include <stdio.h>
int main()
{
    int T;
    int a,b,c;
    int cnt5=0,cnt1=0,cnt10=0;
    scanf("%d",&T);
    if(T%10!=0)printf("-1");
    else{
        a=T/300;
        b=(T%300)/60;
        c=((T%300)%60)/10;
        printf("%d %d %d",a,b,c);
    }
}
