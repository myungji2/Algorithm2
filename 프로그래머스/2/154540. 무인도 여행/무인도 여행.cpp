#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;
vector<vector<bool>> visit;
queue<pair<int,int>> q;
int subs = 'X' - '0';

int q_sum(int i, int j, vector<string>maps) {
    visit[i][j] = true;
    q.push(make_pair(i,j));
    return int(maps[i][j] - '0');
}

int check_n_sum(int size, int length, int sum, int i, int j, vector<string> maps) {
    if (i != 0 && visit[i - 1][j] == false && maps[i - 1][j] !='X') {//윗방향 탐색
        sum+=q_sum(i - 1, j, maps);}

    if (i != size - 1 && visit[i + 1][j] == false && maps[i + 1][j] != 'X') {//아랫방향 탐색
        sum+= q_sum(i + 1, j, maps);}

    if (j != length - 1 && visit[i][j + 1] == false && maps[i][j + 1] != 'X') {//오른쪽
        sum+= q_sum(i , j+1, maps);}

    if (j != 0 && visit[i][j - 1] == false && maps[i][j - 1] != 'X') {//왼쪽
        sum += q_sum(i, j-1, maps);}
    return sum;

}
vector<int> solution(vector<string> maps) {
    
    vector<int> answer;
   
    int length = maps[0].length();
    int size = maps.size();
    for (int i = 0; i < size; i++) {
        vector<bool> v;
        visit.push_back(v);
        for (int j = 0; j < length; j++) {
            visit[i].push_back(false);
        }
    }
    for (int i = 0; i < size;i++) {
        for (int j = 0; j < length; j++) {
            char num1 = maps[i][j];
            int num = num1 - '0';
            int sum = 0;
            
            if (visit[i][j] == false && num != subs) {
                visit[i][j] = true;
                
                sum =num + check_n_sum(size, length, sum, i, j, maps);
                while (!q.empty()) {
                    sum=check_n_sum(size, length, sum, q.front().first, q.front().second, maps);
                    q.pop();
                }
                answer.push_back(sum);
                cout <<sum<<endl;
            }
        }
    }
    if (answer.size() == 0) {
        answer.push_back(-1);
    }
            
    sort(answer.begin(), answer.end());
    
    return answer;
}