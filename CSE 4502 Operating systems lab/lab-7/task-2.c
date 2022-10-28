#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/dir.h>
#include <sys/param.h>
#include <sys/wait.h>
#include <errno.h>
#include <dirent.h>
#include <string.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>

int main()
{
        pid_t pid, p;
        int n, *num, i, j, temp;

        pid = getpid();
        printf("Parent process executing\n");

        printf("Enter the length of the fibonacci series: ");
        scanf("%d",&n);
      
        key_t key = 1022;
  
        // shmget returns an identifier in shmid
        int shmid = shmget(key,sizeof(int)*n,0666|IPC_CREAT);
        
        int *a = (int*)shmat(shmid,NULL,0);

        int inbuf[n];
    
        p = fork();

        if(p == 0 )
        {
                int arr[n];
                arr[0] = 0, arr[1] = 1;
                int nextTerm = 0;

                for (int i = 2; i < n; ++i) {
                        arr[i] = arr[i-1] + arr[i-2];
                }

                for(i = 0 ; i < n ; i++){
                        printf("%d ",arr[i]);
                }

                printf("\n");

                for(int i = 0; i<5;i++)
                        a[i] = arr[i];

                shmdt(a);

        }
        else if(p>0)
        {
                wait(NULL);

                int shmid = shmget(key,sizeof(int)*n,0666|IPC_CREAT);

                int *b = (int*) shmat(shmid,NULL,0);

                for(i = 0 ; i < n ; i++){
                        printf("%d ",b[i]);
                }

                printf("\n");
        }
            
        return 0;
}