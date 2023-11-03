#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

pthread_mutex_t	mutex;

void	*routine(void *i)
{
	for (int c = 0; c < 10000; ++c)
	{
		pthread_mutex_lock(&mutex);
		++*(int *)i;
		pthread_mutex_unlock(&mutex);
	}
	return (i);
}

int	main(void)
{
	// pthread_t	t1;
	// pthread_t	t2;
	int			c = 0;

	pthread_mutex_init(&mutex, 0);
	pthread_mutex_lock(&mutex);
	printf("first\n");
	pthread_mutex_lock(&mutex);
	printf("second\n");
	// pthread_create(&t1, 0, routine, &c);
	// pthread_create(&t2, 0, routine, &c);
	// pthread_join(t1, 0);
	// pthread_join(t2, 0);
	pthread_mutex_destroy(&mutex);
	printf("%d\n",c);
}
