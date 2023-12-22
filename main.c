#include <stdio.h>

int	func(int *i)
{
	return (*i = 5);
}

int	main()
{
	int a = 0;
	printf("%d\n%d\n", func(&a), a);
}
