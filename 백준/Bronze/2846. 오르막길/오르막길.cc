#include <stdio.h>

int main(void) {
  int N;
  int arr[1000]={0,};
  int res;
  int first,last;
  int max=0;
  int flag = 0;

  scanf("%d",&N);
  for(int i=0; i<N; i++){
    scanf("%d",&arr[i]);
  }

  for(int i=0; i<N; i++){

    if(arr[i]<arr[i+1]&&!flag){
      first=arr[i];
      flag = 1;
    }

    if(arr[i]>=arr[i+1]&&flag){
      flag = 0;
      last = arr[i];
      res = last - first;
      max = res<max ? max : res;
    }
  }

  printf("%d",max);
}