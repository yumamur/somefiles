#include <mlx.h>
#include <X11/keysym.h>
#include <stdint.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct s_img
{
	int		width;
	int		height;
	int		bbp;
	int		size_line;
	int		endian;
	unsigned int	*addr;
}	t_img;

typedef struct s_game
{
	void	*mlx;
	void	*win;
	void	*img;
}	t_game;

int	k_exit(int key, t_game *gm)
{
	if (key == XK_Escape)
		exit(0);
	else if (key == XK_space)
		mlx_put_image_to_window(gm->mlx, gm->win, gm->img, 0, 0);
	return (0);
}

void	imgget(t_img *str, void *img)
{
	str->addr = (unsigned int *)mlx_get_data_addr(img, &str->bbp, &str->size_line, &str->endian);
}

void	add_img(t_img *base, t_img *add, int posx, int posy)
{
	int	x;
	int	y;

	y = 0;
	while (y + posy < base->height && y < add->height)
	{
		x = 0;
		while (x + posx < base->width && x < add->width)
		{
			base->addr[((y + posy) * base->height) + x + posx]
				= add->addr[y * add->height + x];
			++x;
		}
		++y;
	}
}

int main(void)
{
	t_game	gm;
	void	*addi;
	t_img	add;
	t_img	base;
	
	gm.mlx = mlx_init();
	gm.win = mlx_new_window(gm.mlx, 1000, 1000, "gm");
	gm.img = mlx_new_image(gm.mlx, 512, 512);
	addi = mlx_xpm_file_to_image(gm.mlx, "asd.xpm", &add.width, &add.height);
	base.width = 512;
	base.height = 512;
	imgget(&add, addi);
	imgget(&base, gm.img);
	add_img(&base, &add, 0, 0);
	add_img(&base, &add, 64, 64);
	mlx_hook(gm.win, 2, 1 << 0L, k_exit, &gm);
	mlx_loop(gm.mlx);
}
