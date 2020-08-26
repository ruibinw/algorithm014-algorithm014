class MyCircularDeque:

    def __init__(self, k: int):
        self.capacity = k
        self.data = [0] * k
        self.size = 0
        # the trick is here to maintain front is one slot ahead rear at the beginning
        self.front = 0
        self.rear = 1


    def insertFront(self, value: int) -> bool:
        if self.isFull():
            return False
        else:
            self.data[self.front] = value
            self.front = (self.front - 1 + self.capacity) % self.capacity
            self.size += 1
            return True


    def insertLast(self, value: int) -> bool:
        if self.isFull():
            return False
        else:
            self.data[self.rear] = value
            self.rear = (self.rear + 1) % self.capacity
            self.size += 1
            return True


    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False
        else:
            self.front = (self.front + 1) % self.capacity
            self.size -= 1
            return True


    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False
        else:
            self.rear = (self.rear - 1 + self.capacity) % self.capacity
            self.size -= 1
            return True


    def getFront(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.data[(self.front + 1) % self.capacity]


    def getRear(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.data[(self.rear - 1 + self.capacity) % self.capacity]


    def isEmpty(self) -> bool:
        return self.size == 0


    def isFull(self) -> bool:
        return self.size == self.capacity