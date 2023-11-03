#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
#include <term.h>

int main()
{
	int err = 0xff;
	printf("%d\n", (err & 0x0f) == 0x0f);
	printf("%d\n", (err & 0xf0) == 0xf0);
}
