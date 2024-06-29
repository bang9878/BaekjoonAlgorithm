#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main()
{
	queue<int >q;
	string  order;
	int test;
	int num;
	cin >> test;
	for (int i = 0; i < test; i++) {
		cin >> order;
		if (order == "push") {
			cin >> num;
			q.push(num);
		}
		if (order == "pop") {
			if (q.empty())cout << -1 << endl;
			else {
				cout << q.front() << endl;
				q.pop();
			}
		}
		if (order == "size")cout << q.size() << endl;
		if (order == "empty")cout << q.empty() << endl;
		if (order == "front")
		{
			if (q.empty())cout << -1 << endl;
			else cout << q.front() << endl;
		}
		if (order == "back")
		{
			if (q.empty())cout << -1 << endl;
			else cout << q.back() << endl;
		}
	}
}