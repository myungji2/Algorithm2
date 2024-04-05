#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    answer.push_back(2+(brown-4+sqrt(pow(brown-4,2)-16*yellow))/4);
    answer.push_back(2+(brown-4-sqrt(pow(brown-4,2)-16*yellow))/4);
    sort(answer.rbegin(),answer.rend());
    return answer;
}