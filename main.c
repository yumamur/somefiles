#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main()
{
	char *buf = getcwd(0, 0);
	printf("%s\n", buf);
	free(buf);
	chdir("..");
	buf = getcwd(0,0);
	printf("%s\n", buf);
	free(buf);
}
