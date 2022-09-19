#include <sys/types.h> /* Type definitions used by many programs */
#include <stdio.h> /* Standard I/O functions */
#include <stdlib.h> /* Prototypes of commonly used library functions, plus EXIT_SUCCESS and EXIT_FAILURE constants */
#include <unistd.h> /* Prototypes for many system calls */
#include <errno.h> /* Declares errno and defines error constants */
#include <string.h> /* Commonly used string-handling functions */
#include <sys/wait.h>


int main(int argc, char *argv[])
{
    pid_t pid1,pid2,pid3;
    pid1=fork();
    pid2=fork();
    pid3=fork();
    if(pid1<0){
        printf("Forking Failed\n");
    }
    else if(pid1==0){
        printf("Child process\n");
	    printf("Parent PID: %d -- Child PID:%d\n",getppid(),getpid());
    }
    else if(pid1>0){
        printf("Parent process\n");
	    printf("Parent PID: %d -- Child PID:%d\n",getppid(),getpid());
    }
    

    return 0;
}
