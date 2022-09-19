#include <sys/types.h> /* Type definitions used by many programs */
#include <stdio.h> /* Standard I/O functions */
#include <stdlib.h> /* Prototypes of commonly used library functions, plus EXIT_SUCCESS and EXIT_FAILURE constants */
#include <unistd.h> /* Prototypes for many system calls */
#include <errno.h> /* Declares errno and defines error constants */
#include <string.h> /* Commonly used string-handling functions */
#include <sys/wait.h>


int main(int argc, char *argv[])
{
    pid_t pid1,pid2,var=0;

    pid1=getpid();
    pid2=getppid();
    pid1=fork();

    if(pid1<0){
        printf("Forking Failed\n");
    }
    else if(pid1==0){
        printf("Child process\n");
	    var=var+22;
	    printf("id = %d\n",var);
    }
    else if(pid1>0){
        printf("Parent process\n");
	    var=var+122;
	    printf("id with last three digits = %d\n",var);
    }
    
    printf("parent pid: %d\n",pid2);


    return 0;
}
