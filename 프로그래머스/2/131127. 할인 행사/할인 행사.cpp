#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    map<string, int> m;
    int answer = 0;


    for (int j = 0; j < discount.size() - 9; j++) {
        int flag = 0;
        for (int i = 0; i < want.size(); i++) {
            m[want[i]] = number[i];
        }
        for (int i = j; i < j + 10; i++) {
            m[discount[i]] -= 1;
        }
        for (int i = 0; i < want.size(); i++) {
            if (m[want[i]] != 0) {
                flag = 1;
                break;
            };
        }
        if (flag == 0) {
            answer++;
        }
        ;
    }

    return answer;
}
