#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/dir.h>
#include <sys/param.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <dirent.h>
#include <readline/readline.h>
#include <readline/history.h>


int main(int argc, char *argv[])
{

    // ls vim touch cat cp
    char input;

    while (scanf("%c", &input) != 0)
    {
        //char* input = argv[1];
        printf("%c\n", input);

        if (fork() == 0)
        {
            //printf("forked");

            if (input == 'v'){
                execlp("vim", "vim", NULL);
            }
            char ls = 'l';
            if(input == ls){
                char dirname[10];
                DIR*p;
                struct dirent *d;
                printf("Enter directory name\n");
                scanf("%s",dirname);
                p=opendir(dirname);
                if(p==NULL)
                {
                    perror("Cannot find directory");
                    exit(-1);
                }
                while(d=readdir(p))
                    printf("%s\n",d->d_name);

                //exit(0);

            }
            //-----

            //---myTouch
            char myTouch = 't';
            if(input == myTouch){
                char* input2;
                printf("Enter text file name\n");
                scanf("%s", input2);
                int create_file = open(input2, O_WRONLY | O_CREAT, "w");
            }
            //----------

            //---myCat
            char myCat = 'c';
            if(input == myCat){
                char* input2;
                printf("Enter text\n");
                scanf("%s", input2);
                int fd1 = open(input2, O_RDONLY | O_CREAT, "r");
                char *c1 = (char *) calloc(100, sizeof(char));

                if(fd1 != -1){
                    int poro = read(fd1, c1, 100);
                    printf("%s", c1);
                }
                //exit(0);
            }
            //-------

            //---mycp
            char myCp = 'p';
            if(input == myCp){
                char* input2;
                printf("Enter text file name\n");
                scanf("%s", input2);
                int fd2 = open(input2, O_RDONLY | O_CREAT, "r");
                char *c2 = (char *) calloc(100, sizeof(char));

                if(fd2 != -1){
                    int poro = read(fd2, c2, 100);
                    printf("%s", c2);
                }

                char* input3;
                printf("Enter text file name -2 \n");
                scanf("%s", input3);
                int fd2_2 = open(input3, O_WRONLY | O_CREAT, "rw");
                write(fd2_2, c2, 100);
                //exit(0);
            }
        }
        else
        {
            wait(NULL);
        }
    }

    return 0;
}