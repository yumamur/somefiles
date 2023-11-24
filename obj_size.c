#include <stdio.h>

int	get_size(const void *addr)
{
	return __builtin_object_size(addr, 0);
}

int	main(void)
{
	static int	l = 1;
	static int	*p = &l;

	printf("%d\n", get_size(p));
}
