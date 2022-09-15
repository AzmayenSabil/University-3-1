#include <stdio.h>
#include <fcntl.h>
#include <sys/stat.h>


int main(int argc, char *argv[]){

    int create_file = open(argv[1], O_WRONLY | O_CREAT, "w");
    
    
    return 0;
}