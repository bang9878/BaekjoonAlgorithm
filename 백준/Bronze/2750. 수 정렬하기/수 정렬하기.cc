#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;


void Merge(int arr[], int left, int mid, int right)
{
	int sort[1001];
	int i, j, k, l;
	i = left;
	j = mid + 1;
	k = left;
	while (i <= mid && j <= right) {
		if (arr[i] <= arr[j])
			sort[k++] = arr[i++];
		else
			sort[k++] = arr[j++];
	}
	if (i > mid) {
		for (l = j; l <= right; l++)
			sort[k++] = arr[l];
	}
	else {
		for (l = i; l <= mid; l++) {
			sort[k++] = arr[l];			}
	}
	for (l = left; l <= right; l++) {
		arr[l] = sort[l];
	}
}

void Merge_Sort(int arr[], int left, int right)
{
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		Merge_Sort(arr, left, mid);
		Merge_Sort(arr, mid + 1, right);
		Merge(arr, left, mid, right);
	}
}

int main()
{
	int n;
	int arr[1001];
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	Merge_Sort(arr, 0, (n - 1));
	for (int i = 0; i < n; i++)
		cout << arr[i] << endl;
}
