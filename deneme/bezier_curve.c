#include <mlx.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <unistd.h>
#define WIDTH 800
#define HEIGHT 600

typedef struct {
    int x;
    int y;
} Point;

// Bézier curve function
Point bezier(Point p0, Point p1, Point p2, Point p3, float t) {
    Point result;
    float u = 1 - t;
    float tt = t * t;
    float uu = u * u;
    float uuu = uu * u;
    float ttt = tt * t;

    result.x = uuu * p0.x + 3 * uu * t * p1.x + 3 * u * tt * p2.x + ttt * p3.x;
    result.y = uuu * p0.y + 3 * uu * t * p1.y + 3 * u * tt * p2.y + ttt * p3.y;

    return result;
}

int exit_g(int key, void *mlx)
{
	mlx_loop_end(mlx);
	exit(1);
}

int main() {
    void *mlx;
    void *win;
    
    mlx = mlx_init();
    win = mlx_new_window(mlx, WIDTH, HEIGHT, "Bézier Curve");

    Point p0 = {100, 500};
    Point p1 = {200, 100};
    Point p2 = {600, 400};
    Point p3 = {700, 500};

    float t;
    Point curvePoint;

	usleep(10000);
    for (t = 0; t <= 1; t += 0.001) {
        curvePoint = bezier(p0, p1, p2, p3, t);
        mlx_pixel_put(mlx, win, curvePoint.x, curvePoint.y, 0xFFFFFF);
    }

	mlx_key_hook(win, exit_g, mlx);
    mlx_loop(mlx);

    return 0;
}
