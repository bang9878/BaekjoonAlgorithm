#include <stdio.h>
int main()
{
    int T,i,change;
    int Q,D,N,P;
    scanf("%d",&T);
    for(i=0; i<T; i++){
        scanf("%d",&change);
        Q=change/25;
        D=(change%25)/10;
        N=((change%25)%10)/5;
        P=(((change%25)%10)%5)/1;
        printf("%d %d %d %d\n",Q,D,N,P);
    }
}
