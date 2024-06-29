#include <stdio.h>
#include <string.h>
int main()
{
    char per[1000];
    char doc[1000];
    scanf("%s",per);
    scanf("%s",doc);
    if(strlen(per)>=strlen(doc))printf("go");
    else printf("no");
}
