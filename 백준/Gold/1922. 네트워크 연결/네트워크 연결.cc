#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <memory.h>
#include <utility>
#include <queue>
#include <functional>


using namespace std;
int uf[1000];
int N, M;

int find(int a) {
	if (uf[a] < 0) return a;
	return uf[a] = find(uf[a]);
}

bool merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return false;
	uf[b] = a;
	return true;
}

struct Edge{
	int u, v, w;
	Edge() : Edge(-1, -1, 0) {}
	Edge(int u1, int v1, int w1) : u(u1), v(v1), w(w1) {}
	bool operator <(const Edge & O)const { return w < O.w; }
};




int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> N >> M;
	Edge e[100000];
	for (int i = 0; i < M; i++) {
		int u, v, dist;
		cin >> u >> v >> dist;
		e[i] = Edge(u - 1, v - 1, dist);
	}

	sort(e, e + M);
	int res = 0; int cnt = 0;
	fill(uf, uf + N, -1);
	for (int i = 0; ; i++) {
		if (merge(e[i].u, e[i].v)) {
			res += e[i].w;
			if (++cnt == N - 1) break;
		}
	}
	cout << res << "\n";
	

	return 0;

}