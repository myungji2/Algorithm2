class Solution {
  public int solution(int[] a) {
    int n = a.length;
    int[] leftMin = new int[n]; // 각 위치에서 왼쪽의 최솟값을 저장할 배열
    int[] rightMin = new int[n]; // 각 위치에서 오른쪽의 최솟값을 저장할 배열

    // 각 위치에서 왼쪽의 최솟값 계산
    leftMin[0] = a[0];
    for (int i = 1; i < n; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], a[i]);
    }

    // 각 위치에서 오른쪽의 최솟값 계산
    rightMin[n - 1] = a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i + 1], a[i]);
    }

    int answer = n;

    // 각 요소가 해당 위치에서의 최솟값보다 작은지 확인
    for (int i = 0; i < n; i++) {
      if (a[i] > leftMin[i] && a[i] > rightMin[i]) {
        answer--;
      }
    }

    return answer;
  }
}