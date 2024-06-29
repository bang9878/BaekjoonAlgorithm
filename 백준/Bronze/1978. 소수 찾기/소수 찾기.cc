#include <stdio.h>
int main()
{
    int n,arr[100],count=0,res;
    scanf("%d",&n);
    for(int i=0; i<n; i++){
        scanf("%d",&arr[i]);
    }
    for(int i=0; i<n; i++){
        if(arr[i]==1)count++;
        for(int j=2; j<arr[i]; j++){
            if(arr[i]%j==0){
                count++;
                break;
            }
        }
    }
    res=n-count;
    printf("%d\n",res);
}