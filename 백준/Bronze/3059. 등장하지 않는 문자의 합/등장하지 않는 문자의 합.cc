#include <stdio.h>
int main()
{
    int alpha[26]={0,};
    char str[1000];
    int T,i,sum=0;
    scanf("%d",&T);
    for(i=0; i<T; i++){
        scanf("%s",str);
        for(int j=0; str[j]!='\0'; j++){
            alpha[str[j]-'A']++;
        }
        for(int k=0; k<26; k++){
            if(alpha[k]==0)sum=sum+(k+'A');
            alpha[k]=0;
        }
        printf("%d\n",sum);
        sum=0;
    }
}