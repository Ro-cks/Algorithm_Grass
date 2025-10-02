#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <climits>
using namespace std;

typedef long long ll;
typedef pair<ll, ll> pii;
const int MAX = 200005;
ll N, M;
ll dp[MAX];
ll child[MAX];
ll res[MAX];
vector<pii> G[MAX];

void reroot(int curr, int par) {
	for (auto p : G[curr]) {
		int next = p.first;
		ll d = p.second;
		if (next == par)continue;
		res[next] = res[curr] + (N - 2 * child[next]) * d;
		reroot(next, curr);
	}
}

void reroot2(int curr, int par) {
	for (auto p : G[curr]) {
		int next = p.first;
		ll d = p.second;
		if (next == par)continue;
		res[next] = res[curr] + (M - 2 * child[next]) * d;
		reroot2(next, curr);
	}  
}

ll findChilds(int curr, int par) {
	child[curr] = 1;
	for (auto p : G[curr]) {
		int next = p.first;
		if (next == par) continue;
		child[curr] += findChilds(next, curr);
	}
	return child[curr];
}

void dfs(int curr, int par, ll dist) {
	dp[curr] = dist;
	for (auto p : G[curr]) {
		int next = p.first;
		ll d = p.second;
		if (next == par) continue;
		dfs(next, curr, dist + d);
	}
}


void solve() {
	dfs(1, 0, 0);
	dfs(N + 1, 0, 0);
	for (int i = 2; i <= N; i++) {
		res[1] += dp[i];
	}
	for (int i = N + 2; i <= N + M; i++) {
		res[N + 1] += dp[i];
	}
	findChilds(1, 0);
	findChilds(N + 1, 0);
	reroot(1, 0);
	reroot2(N + 1, 0);
	int mi = 0;
	ll mt = LLONG_MAX;
	for (int i = 1; i <= N; i++) {
		if (mt > res[i]) {
			mt = res[i];
			mi = i;
		}
	}
	int mi2 = 0;
	ll mt2 = LLONG_MAX;
	for (int i = N + 1; i <= N + M; i++) {
		if (mt2 > res[i]) {
			mt2 = res[i];
			mi2 = i;
		}
	}
	ll ans = (mt * M) + (mt2 * N) + (M*N);
	cout << mi << " " << mi2 - N << "\n";
	cout << ans << "\n";
}

void input() {
	cin >> N;
	for (int i = 0; i < N - 1; i++) {
		ll u, v, d;
		cin >> u >> v >> d;
		G[u].push_back({ v,d });
		G[v].push_back({ u,d });
	}
	cin >> M;
	for (int i = 0; i < M - 1; i++) {
		ll u, v, d;
		cin >> u >> v >> d;
		u += N;
		v += N;
		G[u].push_back({ v,d });
		G[v].push_back({ u,d });
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	input();
	solve();
	return 0;
}