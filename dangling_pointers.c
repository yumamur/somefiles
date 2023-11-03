#include <stdio.h>
#include <unistd.h>

typedef char	t_byte7[7];

int	func(t_byte7 **a, int i)
{
	// static int	ctl;

	if (!i)
	// {
	// 	++ctl;
		*a = &(t_byte7){'a', 'a', 'a', 'a', 'a', 'a', 0};
	// }
	else
		*a = &(t_byte7){'b', 'b', 'b', 'b', 'b', 'b', 0};
	return (0);
}

int	main(void)
{
	t_byte7	*a;
	t_byte7	*b;

	// for (int i = 0; i < 100; ++i)
	// 	printf("%d\n", i * i + i);
	func(&a, 0);
	// for (int i = 0; i < 100; ++i)
	// 	printf("%d\n", i * i + i);
	func(&b, 1);
	printf("%s\n", *a);
	printf("%s\n", *b);
}
