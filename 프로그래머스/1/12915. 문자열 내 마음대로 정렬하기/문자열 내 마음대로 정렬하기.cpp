#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
class Comparator {
public:
    int n;
    Comparator(int param) : n(param) {}
    bool operator()(string s1, string s2) const {
        char c1 = s1[n];
        char c2 = s2[n];
        if (c1 == c2) {
            for (int i = 0; i < min(s1.length(), s2.length()); i++) {
                if (i == n) {
                    continue;
                }
                if (s1[i] != s2[i]) {
                    return s1[i] < s2[i];
                }
            }
        }
        else {
            return c1 < c2;
        }
     
    }
};

vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    Comparator comp(n);
    sort(strings.begin(), strings.end(), comp);
    for (string s : strings) {
        cout << s << endl;
    }
    return strings;
}
