#include <iostream>
#include <cstring>

char *add(char *a, char *b) {
    char *c = (char *) malloc(strlen(a) + strlen(b));
    strcpy(c, a);
    strcat(c, b);
    return c;
}

int main() {
    char *a = "hello ";
    char *b = "world";
    std::cout << add(a, b);
}