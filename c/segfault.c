#include <unistd.h>
#include <stdio.h>

void recurse(int d)
{
	char	buf[1024];
	buf[d%1024] = 'a';
	if (d > 0)
		recurse(d - 1);
}

int main()
{
	recurse(1024*2*2*2);
}
