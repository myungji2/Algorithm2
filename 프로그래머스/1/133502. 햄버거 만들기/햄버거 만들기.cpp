#include <stack>
#include <iostream>
#include <vector>
using namespace std;

int solution(vector<int> ingredient) {
    stack<int> st1;
    int answer = 0;
    for (int i = 0; i < ingredient.size(); i++) {
        int idx = ingredient[i];
        if (idx == 1) {
            if (!st1.empty()&&st1.top() == 3 ) {
                for (int j = 0; j < 3; j++) {
                    st1.pop();
                }
                answer++;
            }
            else { st1.push(idx); };
        }
        else {
            if (!st1.empty()&&st1.top() + 1 == idx) {
                st1.push(idx);
                
            }
            else {
                continue;
            }
        }
        
    }
    
    return answer;
}