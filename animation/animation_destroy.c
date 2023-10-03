#include "animation_int.h"
#include <string.h>

void	animation_destroy(t_animation *animation)
{
	if (!animation)
		return ;
	memset(animation->frames, 0, sizeof(void *) * animation->cap);
	free(animation->frames);
	*animation = (t_animation){};
	free(animation);
}
