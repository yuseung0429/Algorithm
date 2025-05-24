#include <stdio.h>

int main()
{

        int arr[5];
        int length = sizeof(arr)/sizeof(int);

        for (int i=0; i<length; i++)
        {
                scanf("%d", arr + i);
        }

        int powsum = 0;
        for (int i=0; i<length; i++)
        {
                powsum += (arr[i] * arr[i]);
        }

        printf("%d", powsum%10);
        return 0;
}