#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;
int bfs(int start,int n, vector<vector<int>> edge) {
    vector<bool> visit(n + 1, false);
    vector<int> distance(n + 1, 0);
    
    queue<int> q;
    q.push(start);
    visit[start] = true;
    
    int answer = 1;
    while (!q.empty()) {

        int x = q.front();
        q.pop();

        for (int i = 0; i < edge[x].size(); i++) {
            int y = edge[x][i];
            if (!visit[y]) {
                
                q.push(y);
                visit[y] = true;
                distance[y] = distance[x]+1;
            }
        }
    }
    int max = 0;

    for (int k = 1; k < n+1; k++) {
        if (max < distance[k]) {
            max = distance[k];
            answer = 1;
        }
        else if (max == distance[k]) {
            answer++;
        }
    }
        

    return answer;
}

vector<vector<int>> make_edge_vec(vector<vector<int>> edge,int n) {
    vector<vector<int>> result(n+1); 
    for (int i = 0; i < edge.size(); i++) {
        result[edge[i][0]].push_back(edge[i][1]);
        result[edge[i][1]].push_back(edge[i][0]);

    }
    return result; 
}

int solution(int n, vector<vector<int>> edge) {
    edge = make_edge_vec(edge,n);
    
    int answer = bfs(1,n, edge);
    cout << answer << endl;
    return answer;
}