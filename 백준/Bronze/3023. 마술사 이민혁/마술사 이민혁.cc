#include <iostream>
using namespace std;

int main() {
	
	int R,C;
	int A, B;
	char arr[110][110];
	cin>>R>>C;
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			cin>>arr[i][j];
		}
	}
	cin>>A>>B;
	A--; B--;
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			arr[i][j+C] = arr[i][C-j-1];
		}
	}
	
	for(int i=0; i<R; i++){
		for(int j=0; j<2*C; j++){
			arr[i+R][j]=arr[R-i-1][j];
		}
	}
	
	if(arr[A][B]=='.')arr[A][B]='#';
	else arr[A][B]='.';
	
	for(int i=0; i<2*R; i++){
		for(int j=0; j<2*C; j++){
			cout<<arr[i][j];
		}
		cout<<'\n';
	}
	
	return 0;
}