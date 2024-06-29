#include <stdio.h>
int main()
{
    int n,size,x,i,j=0;
    scanf("%d",&n);
    scanf("%d",&x);
    size=n;
    int arr[size];
    int res[size];
    for(i=0; i<n; i++){
        scanf("%d",&arr[i]);
    }
    for(i=0; i<n; i++){
        if(arr[i]<x){
            res[j]=arr[i];
            j++;
        }
    }
    for(i=0; i<j; i++){
        printf("%d ",res[i]);
    }
}