#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int T;
	int num;
	int max, min;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> num;
		if (i == 0)
		{
			max = num;
			min = num;
		}
		if (max < num)max = num;
		else if (min > num)min = num;
	}
	cout << min << " " << max;
}