#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string t, string p) {
    vector<long> numlist;
    int size = p.length();
    for (int i = 0; i < t.length() - size + 1; i++) {
        numlist.push_back(stoll(t.substr(i, size)));
    }
    long long p_num = stoll(p);
    int answer = 0;
    for (int j = 0; j < numlist.size(); j++) {
        if (numlist[j] <= p_num) {
            answer++;
        }
    }

    return answer;
}
int main() {
    cout<<solution("3154111441544592", "2546541654171");
}