#include <stdio.h>

typedef float v4 __attribute__((vector_size(16)));

int main()
{
	v4 a = {12343.244, 42.234, 12543.243, 854834.129239023};
	v4 b = __builtin_ia32_sqrtps(a);
	printf("%f %f %f %f\n", b.x, b.y, b.z, b.w);
}
