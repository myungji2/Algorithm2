#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    long long answer = 0;
    vector<long long>fibo;
    fibo.push_back(0);
    fibo.push_back(1);
    for (int i = 0; i < n-1; i++) {
        fibo.push_back((fibo[i]%1234567+fibo[i+1]%1234567)%1234567);

    }
    answer=fibo.back();
    
    return answer;
}