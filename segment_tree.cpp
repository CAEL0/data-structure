#include <iostream>
#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll tree[3000010];

ll summation(int a, int b, int height) {
    ll res = 0;
    a += pow(2, height) - 1;
    b += pow(2, height) - 1;
    while (a <= b) {
        if (a % 2) res += tree[a++];
        if (b % 2 == 0) res += tree[b--];
        a /= 2;
        b /= 2;
    }
    return res;
}
void update(int k, ll c, int height) {
    int idx = pow(2, height) + k - 1;
    ll gap = tree[idx] - c;
    while (idx >= 1) {
        tree[idx] -= gap;
        idx /= 2;
    }
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, x, y;
    cin >> n >> x >> y;

    int height = ceil(log2(n));

    for (int i = 0; i < n; i++) {
        cin >> tree[((int)pow(2, height) + i)];
    }
    for (int h = height - 1; h >= 0; h--) {
        for (int i = pow(2, h); i < pow(2, h + 1); i++) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }
    for (int i = 0; i < x + y; i++) {
        ll p, q, r;
        cin >> p >> q >> r;
        if (p == 1) update(q, r, height);
        else cout << summation(q, r, height) << '\n';
    }
}
