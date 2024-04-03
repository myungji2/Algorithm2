#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int number, int limit, int power) {
    int answer = 0;
    vector<int> list;
    if (number == 0) {
        return 0;
    }
    list.push_back(1);
    for (int i = 2; i < number+1; i++) {
        int num = 0;
        for (int j = 1; j <= i/2; j++) {
            if (i % j == 0) {
                num++;
            }
        }
        list.push_back(num+1);
    }
    for (int k = 0; k < list.size(); k++) {
        int num2 = list[k];
        if (num2 > limit) {
            answer += power;
        }
        else {
            answer +=num2;
        }
    }


    return answer;
}