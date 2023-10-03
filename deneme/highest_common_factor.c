#include <math.h>

static int	next_prime(int prime)
{
	int	ref;

	if (prime == 1 || !prime)
		return (2);
	if (prime % 2)
		prime += 2;
	else
		++prime;
	while (1)
	{
		ref = 2;
		while (ref < sqrt(prime))
		{
			if (!(prime % ref))
				break ;
			else if (ref == 2)
				++ref;
			else
				ref += 2;
		}
		if (ref > sqrt(prime))
			return (prime);
		prime += 2;
	}
}

int	i_hcf(int x, int y)
{
	int	ret;
	int	prime;

	ret = 1;
	prime = 2;
	while (prime <= x && prime <= y)
	{
		if (!(x % prime) && !(y % prime))
		{
			x /= prime;
			y /= prime;
			ret *= prime;
		}
		else
			prime = next_prime(prime);
	}
	return (ret);
}

#include <stdio.h>

int main()
{
	printf("%f\n", floor(log(pow(2, 64))/log(10))+1);
}
