#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>


int binarySearch(int array[], int x, int low, int high) {
  
	// Repeat until the pointers low and high meet each other
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (array[mid] == x)
      return mid;

    if (array[mid] < x)
      low = mid + 1;

    else
      high = mid - 1;
  }

  return -1;
}
  
int main()
{   
    // char buff[100];
    // ftok to generate unique key
    // key_t key = ftok("shmfile",65);
    key_t key = 1122;
    int input;
  
    // shmget returns an identifier in shmid
    int shmid = shmget(key,1024,0666);
  
    // shmat to attach to shared memory
    // char *str = (char*) shmat(shmid,NULL,0);
    int *arr = (int *)shmat(shmid,0,0);
  
    printf("Data read from memory: ");
    for(int i=0; i<5; i++) {
        printf("%d ", arr[i]);
    }

    printf("\nEnter number to search: ");
    scanf("%d", &input);

    int index = binarySearch(arr, input, 0, 5);
    printf("%d\n", index);
      
    //detach from shared memory 
    shmdt(arr);
  
    return 0;
}