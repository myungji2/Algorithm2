#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    map<char, int> m;
    string al = "RTCFJMAN";

    for (int j = 0; j < al.length(); j++) {
        m[al[j]] = 0;
    }
    
    for (int i = 0; i < survey.size(); i++) {
        string sur=survey[i];
        int score = choices[i];
        if (score > 4) {
            m[sur[1]] += score - 4;
        }
        else if (score < 4) {
            score = abs(score - 4);
            m[sur[0]] += score;
        }
        else {
            continue;
        }
    }
    string answer = "";
    for (int k = 0; k < al.length(); k=k + 2) {

        if (m[al[k]] > m[al[k+1]]) {
            answer+=al[k];
        }
        else if (m[al[k]] < m[al[k + 1]]) {
            answer += al[k+1];
        }
        else {
            if (al[k] > al[k + 1]) {
                answer += al[k+1];
            }
            else {
                answer += al[k];
            }
        }
    }
    
    return answer;
}