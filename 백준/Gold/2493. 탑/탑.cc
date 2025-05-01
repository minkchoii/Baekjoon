#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> heights(N);
    for (int i = 0; i < N; ++i) {
        cin >> heights[i];
    }

    stack<pair<int, int>> s; // {index, height}
    vector<int> result(N, 0);

    for (int i = 0; i < N; ++i) {
        while (!s.empty() && s.top().second < heights[i]) {
            s.pop();
        }
        if (!s.empty()) {
            result[i] = s.top().first + 1; 
        }
        s.push({i, heights[i]});
    }

    for (int i = 0; i < N; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    return 0;
}

  