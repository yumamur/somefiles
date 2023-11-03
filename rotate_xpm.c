#include <mlx.h>
#include <unistd.h>
#include <X11/keysym.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int exit_g(int key, void *mlx)
{
	mlx_loop_end(mlx);
}

char **rotate(char **xpm)
{
	int w = atoi(xpm[0]);
	int h = atoi(strchr(xpm[0], 32));
	int ncolors = atoi(strchr(strchr(xpm[0], 32) + 1, 32));
	int len = 0;
	int i = 0;
	while (i <= ncolors)
	{
		len += strlen(xpm[i]);
		++i;
	}
	char **ret = malloc(h * (w + sizeof(char *))
		+ (ncolors + 1) * sizeof(char *) + len + (ncolors + h + 1) + sizeof(char *));
	ret[0] = (char *)(ret + ncolors + h + 2);
	i = 0;
	while (i <= ncolors)
	{
		ret[i + 1] = ret[i] + strlen(xpm[i]) + 1;
		++i;
	}
	len = 0;
	while (len < h)
	{
		ret[i + len + 1] = ret[i + len] + w + 1;
		++len;
	}
	i = 0;
	while (i <= h + ncolors)
	{
		strcpy(ret[i], xpm[i]);
		++i;
	}
	ret[i] = NULL;
	return (ret);
}
// #include "asd.xpm"
int main()
{
	void *mlx = mlx_init();
	void *win = mlx_new_window(mlx, 800, 600, "game");

	int w,h;
	// char **rt = rotate(xpm);
	// void *img = mlx_xpm_to_image(mlx, xpm, &w, &h);
	// void *im3 = mlx_xpm_to_image(mlx, rt, &w, &h);
	void *im2 = mlx_xpm_file_to_image(mlx, "/home/yusuf/Desktop/deneme/asd.xpm", &w, &h);
	// free(rt);
	usleep(100000);
	mlx_key_hook(win, exit_g, mlx);
	// mlx_put_image_to_window(mlx, win, img, 150, 150);
	// mlx_put_image_to_window(mlx, win, im3, 250, 150);
	usleep(100000);
	mlx_put_image_to_window(mlx, win, im2, 350, 150);
	usleep(100000);
	// mlx_destroy_image(mlx, img);
	mlx_destroy_image(mlx, im2);
	// mlx_destroy_image(mlx, im3);
	mlx_loop(mlx);
}
