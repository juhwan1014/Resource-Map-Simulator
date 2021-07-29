# Resource-Map-Simulator

## 1. Project Introduction<br />
This program is the simulator of resource map, which is a process of receiving dynamic allocation of memory and freeing it. I implemented the concept of best fit, which allocates the received memory to the best place in free space. Assuming that the total memory is 1 MB, the user receives a memory size and allocates that amount of memory. <br /><br />


## 2.  What is dynamic allocation?<br />
Unlike static allocation, which specifies memory requirements when writing a program, it allocates as much memory as is needed during execution. In some cases, memory requirements cannot be predicted at all when writing a program. Dynamic allocation refers to the allocation of memory when needed, and the use of it when used up. It has the advantage of being more memory efficient than static allocation, and dynamically allocated memory is a variable without a name. As it occupies an exclusive memory area, it is possible to remember the value for now, but since it has no name, it can only be accessed with a pointer. However, since JAVA does not have a pointer, the purpose of the program is to create a program that includes the function of the malloc.<br /><br />


## 3. Principles of memory management<br />

The substance of the memory is RAM mounted on the system. Depending on the system, the amount of RAM will vary, but the rich will have a lot of RAM for their computers, and the poor will not. If the system has a lot of physical RAM installed, the computer becomes faster and can do more, while if the RAM is small, the system slows down and the performance decreases. RAM is a workspace where programs work, and it is difficult to perform well if this space is small.<br />

Multiple programs need sophisticated memory management principles in order to use the necessary amount of memory well without charging. Memory management is one of the main tasks of the operating system, along with hardware management and scheduling, that cannot be done by applications and the operating system itself. <br /><br />

## 4. Four principles for operating systems to manage memory<br />

       - The main body of memory management is the operating system.
       
       - The operating system does not reject allocation requests as long as memory is present.

       - Once allocated memory space is never reallocated for another purpose.

       - When an application releases allocated memory, the operating system recognizes this space as an empty area and makes it available for other purposes.
