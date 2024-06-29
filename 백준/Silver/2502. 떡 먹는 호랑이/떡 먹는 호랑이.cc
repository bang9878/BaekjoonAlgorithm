#include <iostream>
using namespace std;

int main() {
	int D;
	int K;
	cin>>D>>K;
	int A[35];
	int B[35];
	A[1] = 1;
	A[2] = 0;
	B[1] = 0;
	B[2] = 1;
	for(int i=3; i<=D; i++){
		A[i] = A[i-2] + A[i-1];
		B[i] = B[i-2] + B[i-1];
	}
	for(int i=1; i<=K; i++){
		int Spare = K-(A[D]*i);
		if(Spare%B[D]==0){
			cout<<i<<"\n"<<Spare/B[D];
			return 0;
		}
	}
}