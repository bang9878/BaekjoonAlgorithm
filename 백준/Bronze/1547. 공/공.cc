#include <iostream>
using namespace std;
class Cup {
	int ball;
public:
	Cup(int b = 0) { ball = b; }
	void setball(int b) { ball = b; }
	int getball() { return ball; }
	friend void ChangeBall(int x, int y);
};
Cup cup[3];

void ChangeBall(int x, int y)
{
	int tmp1, tmp2;
	tmp1 = cup[y].getball();
	tmp2 = cup[x].getball();
	cup[x].setball(tmp1);
	cup[y].setball(tmp2);
}

int main()
{
	cup[0].setball(1);
	int m;
	int x, y;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		ChangeBall(x - 1, y - 1);
	}     

	for (int i = 0; i < 3; i++) {
		if (cup[i].getball() == 1)cout << i + 1;
	}
}
                                                                                         