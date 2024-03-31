#include <iostream>
#include <vector>
#include <string>
#include<sstream>
using namespace std;

vector<int> quick_sort(vector<int> vec) {

	int size = vec.size();
	if (size == 0) {
		return vec;
	}
	int pivot = vec.size() / 2;
	vector<int> list1;
	vector<int> list2;
	for (int i = 0; i < size; i++) {
		if (vec[pivot] > vec[i]) {
			list1.push_back(vec[i]);
		}
		else if (vec[pivot] < vec[i]) {
			list2.push_back(vec[i]);
		}
		else { continue; }

	}
	list1=quick_sort(list1);
	list2=quick_sort(list2);
	list1.push_back(vec[pivot]);
	list1.insert(list1.end(), list2.begin(), list2.end());
	return list1;
}
string solution(string s) {
    vector<int> vec;

	stringstream stream;
	stream.str(s);
	string num = "";
	while (stream >> num) {
		vec.push_back(stoi(num));
	}

	vec=quick_sort(vec);

	string answer = to_string(vec.front())+ " " + to_string(vec.back());
    
    return answer;
}