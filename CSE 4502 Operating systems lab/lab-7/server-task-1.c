#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
// bubble sort
void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
        // Last i elements are already in place
        for (j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1])
                swap(&arr[j], &arr[j + 1]);
}

int main()
{   
    // char buff[100];
    // ftok to generate unique key
    // key_t key = ftok("shmfile",65);
    key_t key = 1122;
    // int buff[5];
  
    // shmget returns an identifier in shmid
    int shmid = shmget(key,1024,0666|IPC_CREAT);
  
    // shmat to attach to shared memory
    int *arr = (int *)shmat(shmid,0,0);
      
    printf("Give Data : ");
    for(int i=0; i<5; i++){
        scanf("%d", &arr[i]);
    }   

    bubbleSort(arr, 5);

    printf("Data written in memory: ");

    for(int i=0; i<5; i++) {
        printf("%d ", arr[i]);
    } 
    
      
    //detach from shared memory 
    shmdt(arr);
  
    return 0;
}