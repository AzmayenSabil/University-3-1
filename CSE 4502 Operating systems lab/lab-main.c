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
#include <pthread.h>
#include <stdio.h>
#include <readline/readline.h>
#include <readline/history.h>
#include <sys/ipc.h>
#include <sys/shm.h>

void *chooseOption(void *threadid){
    // the goal for this function was to go task by task and read
    // the instruction from the text file
    // and execute the intended function

}


void *isPalindrome(void *threadid)
{
    printf("%d\n", *(int*)threadid);
    //printf("%d\n", *(int)threadid);
    char *str;
    scanf("%s", str);

    int l = 0;
    int h = strlen(str) - 1;

    while (h > l)
    {
        if (str[l++] != str[h--])
        {
            printf("%s is not a palindrome\n", str);
            return NULL;
        }
    }
    printf("%s is a palindrome\n", str);

    //pthread_exit(NULL);
}


int main(int argc, char *argv[])
{
    char *filename1 = "task1.txt";
    char *filename2 = "task2.txt";
    char *filename3 = "task3.txt";
    char *filename4 = "task4.txt";

    int filehandle1 = open (filename1, O_WRONLY | O_CREAT, 0777);
    int filehandle2 = open (filename2, O_WRONLY | O_CREAT, 0777);
    int filehandle3 = open (filename3, O_WRONLY | O_CREAT, 0777);
    int filehandle4 = open (filename4, O_WRONLY | O_CREAT, 0777);

    close (filehandle1);
    close (filehandle2);
    close (filehandle3);
    close (filehandle4);

    for(int i=1;i<=4;i++) // loop will run n times (n=5)
    {
        if(fork() == 0)
        {
            char *fileName;
            char *instruction;

            if(i==1){
                fileName = "task1.txt";
                instruction = "palindrome_checking\n";
            }
            if(i==2){
                fileName = "task2.txt";
                instruction = "password_strength_checking\n";
            }
            if(i==3){
                fileName = "task3.txt";
                instruction = "prime_number_generation\n";
            }
            if(i==4){
                fileName = "task4.txt";
                instruction = "prime_number_checking\n";
            }

            printf("[son] pid %d from [parent] pid %d\n",getpid(),getppid());

            int sz;

            int fd = open(fileName, O_WRONLY | O_CREAT | O_TRUNC, 0644);
            if (fd < 0)
            {
                perror("r1");
                exit(1);
            }

            sz = write(fd, instruction, strlen(instruction));
            exit(0);
            close(fd);
        }
    }

    for(int i=1;i<=4;i++) // loop will run n times (n=5)
    wait(NULL);

    pthread_t tid[4];


    // Let us create three threads
    for (int i = 0; i < 4; i++){
        //pthread_create(&tid[i], NULL, isPalindrome, (void *)&i);
        pthread_create(&tid[i], NULL, isPalindrome, &i);
        pthread_join(tid[i], NULL);
    }

    //pthread_join(tid, NULL);
    pthread_exit(NULL);

    return 0;
}
