#include <sys/types.h> /* Type definitions used by many programs */
#include <stdio.h> /* Standard I/O functions */
#include <stdlib.h> /* Prototypes of commonly used library functions, plus EXIT_SUCCESS and EXIT_FAILURE constants */
#include <unistd.h> /* Prototypes for many system calls */
#include <errno.h> /* Declares errno and defines error constants */
#include <string.h> /* Commonly used string-handling functions */
#include <sys/wait.h>


int main(int argc, char *argv[])
{
    pid_t pid1,pid2;
    pid1=getpid();
    pid2=getppid();
    pid1=fork();
    if(pid1<0){
		printf("Forking Failed\n");
	}
    else if(pid1==0){
        printf("Child process\n");
		int n=5, first = 0, second = 1, next, c;

  		//scanf("%d", &n);

  		for (c = 1; c <= n; c++)
  		{
    		if (c <= 1)
      			next = c;
    		else
    		{
      			next = first + second;
      			first = second;
      			second = next;
    		}
    		
			printf("%d\n", next);
  		}
	}
    else if(pid1 > 0){
        printf("Parent process\n");
    }

    return 0;
}
