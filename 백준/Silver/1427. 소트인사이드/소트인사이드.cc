#include <stdio.h>
#include <string.h>
int main()
{
    int i,j,len;
    char temp;
    char arr[10];
    scanf("%s",arr);
    len=strlen(arr);
    for(i=0; i<len-1; i++){
        for(j=0; j<len-1-i; j++){
            if(arr[j]<arr[j+1]){
                temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
        }
    }
    printf("%s",arr);
}
