#include <stdio.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]){

    int fd = open(argv[1], O_RDONLY | O_CREAT, "r");
    char *c = (char *) calloc(100, sizeof(char));

    if(fd != -1){
        int poro = read(fd, c, 100);
        printf("%s", c);
    }

    int fd1 = open(argv[2], O_WRONLY | O_CREAT, "rw");
    write(fd1, c, 100);
    
    return 0;
}