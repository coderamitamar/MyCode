char *takeString()
{
	int i=1;
	char *str,*ch;
	str=(char *)malloc(sizeof(char));
	ch=(char *)malloc(sizeof(char));
	fgets(str,1,stdin);
	*ch=getchar();
	while(*ch!='\n')
	{
		str=(char *)realloc(str,(++i)*sizeof(char));
		str=strncat(str,ch,1);
		*ch=getchar();
	}
	return str;	
}
