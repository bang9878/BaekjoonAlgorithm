#include <iostream>
#include <queue>
using namespace std;
int cnt = 0;
int land[50][50];
int width, height;
int dirX[8] = { 0,0,-1,1,1,-1,1,-1 };
int dirY[8] = { 1,-1,0,0,1,-1,-1,1 };
int vis[50][50] = { 0, };
struct node { int y, x; };
bool range(int y, int x) { return (y >= 0) && (y < height) && (x >= 0) && (x < width); }

void bfs(int y, int x)
{
	queue<node> q;
	vis[y][x] = 1;
	node p = { y,x };
	q.push(p);
	while (!q.empty())
	{
		node tmp;
		tmp = q.front();
		q.pop();
		for (int i = 0; i < 8; i++) {
			node next;
			next.y = tmp.y + dirY[i];
			next.x = tmp.x + dirX[i];
			if (range(next.y, next.x) && vis[next.y][next.x] == 0 && land[next.y][next.x] == 1) {
				vis[next.y][next.x] = 1;
				q.push(next);
			}
		}
	}
	cnt++;
}



int main() {
	while (true) {
		cin >> width >> height;
		if (width == 0 && height == 0)break;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				cin >> land[i][j];
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (land[i][j] == 1 && vis[i][j] == 0)
					bfs(i, j);
			}
		}
		cout << cnt << '\n';
		cnt = 0;
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++)
				vis[i][j] = 0;
		}
	}
}
