#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
  
int main()
{   
    int n= 5;
    int buff[100];
    // ftok to generate unique key
    // key_t key = ftok("shmfile",65);
    key_t key = 1022;
  
    // shmget returns an identifier in shmid
    int shmid = shmget(key,sizeof(int)*6,0666|IPC_CREAT);
  
    // shmat to attach to shared memory
    // char *str = (char*) shmat(shmid,NULL,0);
    int *a = (int*) shmat(shmid,NULL,0);
  
    printf("Write Data : ");
    // read(0,buff,100);
    // strcpy(a,buff); 
    for(int i=0;i<n;i++)
        scanf("%d",&buff[i]);
    // a = (int*)malloc(sizeof(int)*5);

    for(int i = 0; i<5;i++)
        a[i] = buff[i];
 
    printf("Data written in memory: ");
    for(int i = 0; i<5;i++)
        printf("%d ", buff[i]);

    int temp;
        for(int i = 0 ; i < n ; i++ )
                {
                        for(int j = 0 ; j < n-i-1 ; j++)
                        {
                                if(a[j] > a[j+1])
                                {
                                        temp = a[j];
                                        a[j] = a[j+1];
                                        a[j+1] = temp;
                                }
                        }
                }
      
      printf("Data sorted: ");
    for(int i = 0; i<5;i++)
        printf("%d ", a[i]);
    //detach from shared memory 
    shmdt(a);
  
    return 0;
}