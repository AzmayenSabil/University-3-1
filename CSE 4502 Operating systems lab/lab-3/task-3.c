#include <sys/types.h> /* Type definitions used by many programs */
#include <stdio.h> /* Standard I/O functions */
#include <stdlib.h> /* Prototypes of commonly used library functions, plus EXIT_SUCCESS and EXIT_FAILURE constants */
#include <unistd.h> /* Prototypes for many system calls */
#include <errno.h> /* Declares errno and defines error constants */
#include <string.h> /* Commonly used string-handling functions */
#include <sys/wait.h>


int main()
{
    //execl("/bin/ls", "-l", NULL);
    //execlp("ls", "-lh", NULL);

    /*char *path = "/bin/ls";
    char *args[] = {path, "-l", NULL};

    execv(path, args);*/
    //char* args[] = { "calfibo", NULL };

    pid_t pid;

    pid = fork();

    if (pid > 0){
        printf("I'm the parent \n");
        wait(NULL);
    }
    else if(pid == 0){
        char* args[] = {"./chrome", NULL };
        execv(args[0], args);
    }



    return 0;
}

/*
*/