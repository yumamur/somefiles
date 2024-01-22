void	function(void **arr, char *str)
{
	str = (((char **)arr)[1] = str);
}
