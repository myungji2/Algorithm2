#include <iostream>
#include <vector>
#include <algorithm>
#include <array>
using namespace std;



int main() {
	//array<int, 9> arr;
	int arr[9] = {};
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> arr[i];
		sum = sum + arr[i];
	}
	sort(arr, arr+9);
	sum = sum - 100;
	int flag = 0;
	for (int j = 0; j < 9; j++) {
		for (int k = 0; k < 9; k++) {
			if (j != k) {
				if (arr[j] + arr[k] == sum) {
					for (int h = 0; h < 9; h++) {
						if (h != j && h != k) {
							cout << arr[h] << endl;
						}
					}
				
					flag = 1;
					break;
				}
			}
		}
		if (flag == 1)					
			break;
	}
	
}