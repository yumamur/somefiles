#include <stdlib.h>
#include <stdio.h>

typedef struct s_str
{
	int		i;
	char	c;
}	t_str;

void	*initialize(void)
{
	return (malloc(sizeof(t_str)));
}

void	internal(t_str *data)
{
	data->i = 15;
	data->c = 'A';
}

void	intprint(t_str *data)
{
	printf("%i\n%c\n", data->i, data->c);
}

void	destroy(t_str *data)
{
	free(data);
}
