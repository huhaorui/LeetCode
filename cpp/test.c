#include <stdio.h>
#include <string.h>

int main() {
    char a[100], b[100];
    int n[200] = {0};
    scanf("%s", a);
    scanf("%s", b);
    int aLen = strlen(a), bLen = strlen(b);
    for (int i = aLen - 1; i >= 0; i--) {
        for (int j = bLen - 1; j >= 0; j--) {
            n[aLen + bLen - i - j - 2] += (a[i] - '0') * (b[j] - '0');
        }
    }
    for (int i = 0; i < 199; i++) {
        n[i + 1] += n[i] / 10;
        n[i] %= 10;
    }
    int flag = 0;
    for (int i = 190; i >= 0; i--) {
        if (n[i] != 0) flag = 1;
        if (flag) printf("%d", n[i]);
    }
}