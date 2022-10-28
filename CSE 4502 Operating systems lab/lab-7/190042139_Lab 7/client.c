//#include <iostream>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
//using namespace std;
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
    int n =5;
    char buff[100];
    // ftok to generate unique key
    // key_t key = ftok("shmfile",65);
    key_t key = 1022;
  
    // shmget returns an identifier in shmid
    int shmid = shmget(key,sizeof(int)*6,0666);
  
    // shmat to attach to shared memory
    // char *str = (char*) shmat(shmid,NULL,0);
    int *a = (int*) shmat(shmid,NULL,0);
  
    int x;
    printf("Give value to search: ");
    scanf("%d",&x);
    
      
    int ans = binarySearch(a, x, 0, n-1);
    printf("This is the index of x: %d", ans);
    //detach from shared memory 
    shmdt(a);
  
    return 0;
}