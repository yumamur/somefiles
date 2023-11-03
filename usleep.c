#include <limits.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>

int main()
{
	struct timespec a,b,t;
	double	buf = 0;

	for (int i = 0; i < 10; ++i)
	{
		t.tv_sec = 1;
		t.tv_nsec = 0;
		clock_gettime(CLOCK_MONOTONIC_RAW, &a);
		nanosleep(&t, NULL);
		clock_gettime(CLOCK_MONOTONIC_RAW, &b);
		buf += (b.tv_sec * 1000000L + b.tv_nsec) - (a.tv_sec * 1000000L + a.tv_nsec);
	}
	printf("%lf\n", buf / 10);
}
