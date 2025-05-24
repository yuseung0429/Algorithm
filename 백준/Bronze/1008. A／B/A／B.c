#include <stdio.h>

int main()
{
        int a = 0;
        int b = 0;
        scanf("%d %d", &a, &b);
        printf("%.9lf", (double)a/b);
        return 0;
}